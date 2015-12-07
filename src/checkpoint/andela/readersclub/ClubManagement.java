package checkpoint.andela.readersclub;

import checkpoint.andela.main.*;
import checkpoint.andela.members.*;


import java.util.*;

/**
 * Created by Semiu on 27/11/2015.
 * This is the general class that manage the affairs of the reader's club.
 * It register members and place them in the appropriate list.
 * It manages the list of books available.
 * It is also in charge of lending and retrieving books to and from members.
 */
public class ClubManagement {
  List<Book> library = new ArrayList<>();
  List<Staff> staffs = new ArrayList<>();
  List<Student> students = new ArrayList<>();
  QueueManager queues = new QueueManager();

  // Constructors
  public ClubManagement() {}

  // Register member
  public void registerMember(Member member) {
    if (member instanceof Staff) {
      staffs.add((Staff) member);
    } else if (member instanceof Student) {
      students.add((Student) member);
    }
  }

  // Check whether a member is registered
  public boolean isMemberRegistered(Member member) {
    if(staffs.contains(member) || students.contains(member)) {
      return true;
    }
    return false;
  }

  // Get the number of registered member in the club
  public int getClubSize() {
    return staffs.size() + students.size();
  }

  // Add a book to the library
  public void addBook(Book newBook) {
    for(Book book : this.library) {
      if(book == newBook){
        book.incrementBookByNoOfCopies(newBook.getNumberOfCopies());
        return;
      }
    }
    library.add(newBook);
  }

  // Member requesting to borrow book
  public void requestToBorrowBook(Member member, Book book) {
    if(isBookAvailable(book) && isMemberRegistered(member)) {
      addBorrowerToQueue(member, book);
      lendBook(book);
    }
  }

  // Check book availability
  public boolean isBookAvailable(Book book) {
    return  library.contains(book);
  }


  // Add borrower to queue
  public void addBorrowerToQueue(Member member, Book book){
    switch (book.getBookTitle()) {
      case "book1":
        this.queues.book1Queue.add(member);
        break;
      case "book2":
        this.queues.book2Queue.add(member);
        break;
      case "book3":
        this.queues.book3Queue.add(member);
        break;
      default:
        // create a queue named generalQueue and add member to it.
        this.queues.createNewQueue().add(member);
        break;
    }
  }

  // Lend book to members
  public void lendBook(Book book) {
    PriorityQueue<Member> queue = getQueue(book.getBookTitle());
    while(!queue.isEmpty() && book.getNumberOfCopies() > 0) {
      book.decrementBook();
      queue.poll();
    }
  }

  // Get the require borrowing queue
  public PriorityQueue<Member> getQueue(String queueName) {
    switch(queueName) {
      case "book1":
        return queues.book1Queue;
      case "book2":
        return queues.book2Queue;
      case "book3":
        return queues.book3Queue;
      default:
        return queues.generalQueue;
    }
  }

  // The return book  methods
  public void returnBook(Member member, Book book) {
    addToReturnQueue(member, book);
    PriorityQueue<Member> queue = getReturnQueue(book.getBookTitle());
    while(!queue.isEmpty()) {
      book.incrementBook();
      queue.poll();
    }
  }

  // Add member to  return queue
  public void addToReturnQueue(Member member, Book book){
    switch (book.getBookTitle()) {
      case "book1":
        this.queues.book1ReturnQueue.add(member);
        break;
      case "book2":
        this.queues.book2ReturnQueue.add(member);
        break;
      case "book3":
        this.queues.book3ReturnQueue.add(member);
        break;
      default:
        this.queues.createNewQueue().add(member);
        break;
    }
  }

  // Get the require returning queue
  public PriorityQueue<Member> getReturnQueue(String queueName) {
    switch(queueName) {
      case "book1":
        return queues.book1ReturnQueue;
      case "book2":
        return queues.book2ReturnQueue;
      case "book3":
        return queues.book2ReturnQueue;
      default:
        return queues.generalQueue;
    }
  }

  // To determine who get book from the queue
  public String whoGetBook(Book book) {
    PriorityQueue<Member> queue = getQueue(book.getBookTitle());
    while(book.getNumberOfCopies() > 0 && !(queue.isEmpty())) {
      Member member = queue.poll();
      book.decrementBook();
      return member.getName();
    }
    return "";
  }
}