package checkpoint.andela.readersClub;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

import java.util.*;

/**
 * Created by Semiu on 27/11/2015.
 * This is the general class that manage the affairs of the reader's club.
 * It register members and place them in the appropriate list.
 * It manages the list of books available.
 * It is also in charge of lending and retrieving books to and from members.
 */
public class ReadersClubManagement {

  // Lists of books staffs and students
  public static List<Book> books = new ArrayList<Book>();
  static List<Staff> staffs = new ArrayList<Staff>();
  static List<Student> students = new ArrayList<Student>();

  static Comparator<Member> compareMember = new ComparatorInterface();
  public static PriorityQueue<Member> bookBorrowingQueue = new PriorityQueue<Member>(10, compareMember);
  public static PriorityQueue<Member> bookReturningQueue = new PriorityQueue<Member>(10, compareMember);

  // Register member
  public static boolean registerMember(Member member) {
    if(member instanceof Staff) {
      staffs.add((Staff) member);
    }else if (member instanceof Student) {
      students.add((Student) member);
    }
    return true;
  }

  // Add a book to the library
  public boolean addBook(Book book){
    books.add(book);
    return true;
  }

  // The lending  methods
  public static void lendingBook(Member member, Book book){
    if(isBookAvailable(book)){
      bookBorrowingQueue.add(member);
      book.decrementBook();
    }
  }

  // The lending  methods
  public static void retrieveBook(Member member, Book book){
    bookReturningQueue.add(member);
    books.add(book);
    book.incrementBook();
  }

  // Check book availability
  public static boolean isBookAvailable(Book book) {
    if(books.contains(book)) {
      return true;
    }
    return false;
  }

  public static boolean addToBorrowQueue(Member member) {
    bookBorrowingQueue.add(member);
    return true;
  }

  public static boolean addToReturningQueue(Member member) {
    bookReturningQueue.add(member);
    return true;
  }

  // To determine who get book from the queue
  public static void whoGetBook(Book book) {
    int copies = book.getNumberOfCopies();
    Iterator<Member> iterate = bookBorrowingQueue.iterator();
    while(copies > 0 && iterate.hasNext()) {
      bookBorrowingQueue.poll();
      book.decrementBook();
    }
  }
}

