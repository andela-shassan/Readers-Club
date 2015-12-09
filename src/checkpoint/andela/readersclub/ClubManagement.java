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
  List<Book> library;
  List<Staff> staffs;
  List<Student> students;
  Hashtable<String, BookQueue>  borrowBookQueue;

  // Constructors
  public ClubManagement() {
    library = new ArrayList<>();
    staffs = new ArrayList<>();
    students = new ArrayList<>();
    borrowBookQueue = new Hashtable<>();
  }

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
    String bookTitle = book.getBookTitle();
    if (borrowBookQueue.containsKey(bookTitle)){
      BookQueue queue = getQueue(bookTitle);
      queue.addMemberToQueue(member);
    }else {
      BookQueue queue = new BookQueue();
      queue.addMemberToQueue(member);
      borrowBookQueue.put(bookTitle, queue);
    }
  }

  // Lend book to members
  public void lendBook(Book book) {
    BookQueue queue = getQueue(book.getBookTitle());
    while(!queue.isEmpty() && book.getNumberOfCopies() > 0) {
      book.decrementBook();
      queue.pollQueue();
    }
  }

  // Get the require borrowing queue
  public BookQueue getQueue(String bookTitle) {
    return borrowBookQueue.get(bookTitle);
  }


  // To determine who get book from the queue
  public String whoGetBook(Book book) {
    BookQueue queue = getQueue(book.getBookTitle());
    while(book.getNumberOfCopies() > 0 && !(queue.isEmpty())) {
      Member member = queue.pollQueue();
      book.decrementBook();
      return member.getName();
    }
    return "";
  }

}