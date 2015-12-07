package checkpoint.andela.readersclub;

import checkpoint.andela.main.Book;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Semiu on 02/12/2015.
 */
public class ClubManagementTest {
  ClubManagement readersClub = new ClubManagement();
  Staff staff1 = new Staff("Hassan Semiu", 'M', "10/06/1986", "hassan.ayomon@andela.com", "08036294879", 1234, 71.550);
  {
    try {
      Thread.sleep(500);
    }catch(InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  Staff staff2 = new Staff("Opeyemi Hassan",'M',"10th June, 1986", "semiu_hassan@ymail.com", "08056706725", 345, 45.663);
  Staff staff3 = new Staff("Rahmon Saheed",'M',"10th June, 1986", "semiu_hassan@ymail.com", "08056706725", 345, 45.663);


  Student student1 = new Student("John Doe", 'F', "12th May, 1996", "semiu_hassan@hotmail.com", "08056706725",231, 12 );
  {
    try {
      Thread.sleep(500);
    }catch(InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
  Student student2 = new Student("Andela Guru", 'M', "10th May, 2010", "andela.guru@andela.com", "08085435202",2324, 01);
  {
    try {
      Thread.sleep(500);
    }catch(InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
  Student student3 = new Student("Tosin", 'M', "10th May, 2010", "andela.guru@andela.com", "08085435202",2324, 01);

  Book book11 = new Book("book1","Chinua Achebe", 2, "ISBN:08798-48");
  Book book22 = new Book("book2","Opeyemi Idowu", 1, "ISBN:123-48M");


  @Test
  public void testRegisterMember() throws Exception {
    readersClub.registerMember(staff2);
    readersClub.registerMember(staff1);
    readersClub.registerMember(student1);
    readersClub.registerMember(student2);
    readersClub.registerMember(student3);
    assertEquals(readersClub.staffs.size(),2);
    assertEquals(readersClub.students.size(),3);
  }

  // isMemberRegistered() should return true if the member is registered in the club
  // otherwise it should return false
  @Test
  public void testIsMemberRegistered() throws Exception {
    assertFalse(readersClub.isMemberRegistered(staff1));
    assertFalse(readersClub.isMemberRegistered(student1));
    readersClub.registerMember(staff1);
    readersClub.registerMember(student1);
    assertTrue(readersClub.isMemberRegistered(staff1));
    assertTrue(readersClub.isMemberRegistered(student1));
  }

  // The getClubSize() method should display total number of registered users.
  @Test
  public void testGetClubSize() throws Exception {
    readersClub.registerMember(staff2);
    readersClub.registerMember(staff1);
    readersClub.registerMember(student1);
    readersClub.registerMember(student2);
    readersClub.registerMember(student3);
    assertEquals(readersClub.getClubSize(),5);
  }

  // The getClubSize() method should return false if we negate
  // the total number of registered users
  @Test
  public void testGetClubSize2() throws Exception {
    readersClub.registerMember(staff2);
    readersClub.registerMember(student2);
    readersClub.registerMember(student3);
    assertEquals(readersClub.getClubSize() != 3, false);
  }

  // addBook() method should increase the size of the books list by the number of different books added.
  @Test
  public void testAddBook() throws Exception {
    assertTrue(readersClub.library.size() == 0);
    readersClub.addBook(book11);
    assertEquals(readersClub.library.size(),1);
    readersClub.addBook(book22);
    assertEquals(readersClub.library.size(),2);
    readersClub.library.clear();
    assertEquals(readersClub.library.size(),0);
  }

  // addBook() method should not increase the size of the books list
  // If the book being added already exist in the book list.
  @Test
  public void testAddBook2() throws Exception {
    assertEquals(readersClub.library.size(),0);
    readersClub.addBook(book11);
    readersClub.addBook(book11);
    assertEquals(readersClub.library.size(),1);
    readersClub.addBook(book22);
    readersClub.addBook(book22);
    assertEquals(readersClub.library.size(),2);
    readersClub.library.clear();
    assertEquals(readersClub.library.size(),0);
  }

  // addBook() method should not increase the size of the books list
  // If the book being added already exist in the book list.
  // It should increase the number of copy of that book  by the
  // number of copies being added.
  @Test
  public void testAddBook3() throws Exception {
    // Check the number of copies of book11
    assertEquals(book11.getNumberOfCopies(), 2);

    // Check the size of books list to be sure it is empty
    assertEquals(readersClub.library.size(),0);
    readersClub.addBook(book11);

    // Check the size of books list to be sure it increased when a book is added
    assertEquals(readersClub.library.size(),1);
    assertEquals(book11.getNumberOfCopies(), 2);
    readersClub.addBook(book11);

    // Check the size of books list to be sure it does not increase
    // when the book being added already exist in the book list
    assertEquals(readersClub.library.size(),1);

    // Check to be sure to be sure the when a book is added
    assertEquals(book11.getNumberOfCopies(), 4);
    readersClub.addBook(book22);
    readersClub.addBook(book22);

    // Check the size of books list to be sure it increased when a new book is added
    assertEquals(readersClub.library.size(),2);
    readersClub.library.clear();
  }

  // When member request to borrow book, they should be placed on the queue for that book
  // if the book is available in the library
  @Test
  public void testRequestToBorrowBook() throws Exception {
    assertEquals(readersClub.getQueue(book22.getBookTitle()).size(), 0);
    readersClub.registerMember(staff1);
    readersClub.library.add(book22);
    readersClub.requestToBorrowBook(staff1, book22);
    assertEquals(readersClub.getQueue(book22.getBookTitle()).size(), 1);
  }

  // When the person requesting to borrow book, is not a registered member,
  // they should not be place on the queue
  @Test
  public void testRequestToBorrowBook2() throws Exception {
    assertEquals(readersClub.getQueue(book22.getBookTitle()).size(), 0);
    readersClub.library.add(book22);
    readersClub.requestToBorrowBook(staff1, book22);
    assertEquals(readersClub.getQueue(book22.getBookTitle()).size(), 0);
  }

  // When member request to borrow book, they should not be place on the queue
  // if the book is available in the library
  @Test
  public void testRequestToBorrowBook3() throws Exception {
    assertEquals(readersClub.getQueue(book22.getBookTitle()).size(), 0);
    readersClub.requestToBorrowBook(staff1, book22);
    assertEquals(readersClub.getQueue(book22.getBookTitle()).size(), 0);
  }

  // This should return true if the club have the book in their library collection
  // otherwise, it should return false
  @Test
  public void testIsBookAvailable() throws Exception {
    assertEquals(readersClub.isBookAvailable(book11), false);
    readersClub.library.add(book11);
    assertEquals(readersClub.isBookAvailable(book11), true);
    readersClub.library.clear();
    assertEquals(readersClub.isBookAvailable(book11), false);
  }

  @Test
  public void testAddBorrowerToQueue() throws Exception {
    assertEquals(readersClub.getQueue(book11.getBookTitle()).size(), 0);
    readersClub.addBorrowerToQueue(staff1, book11);
    assertEquals(readersClub.getQueue(book11.getBookTitle()).size(), 1);
  }

  @Test
  public void testLendBook() throws Exception {
    readersClub.registerMember(staff1);
    readersClub.registerMember(staff2);
    readersClub.registerMember(staff3);
    readersClub.registerMember(student2);
    readersClub.registerMember(student1);

    book22.setNumberOfCopies(2);
    book11.setNumberOfCopies(2);

    readersClub.library.add(book22);
    readersClub.library.add(book11);

    readersClub.requestToBorrowBook(staff2, book22);
    readersClub.requestToBorrowBook(staff1, book22);
    readersClub.requestToBorrowBook(student1, book22);
    readersClub.requestToBorrowBook(staff3, book22);
    readersClub.requestToBorrowBook(student2, book22);
    assertEquals(readersClub.queues.book2Queue.size(), 5);

    readersClub.requestToBorrowBook(staff2, book11);
    readersClub.requestToBorrowBook(staff1, book11);
    readersClub.requestToBorrowBook(student1, book11);
    readersClub.requestToBorrowBook(student2, book11);
    assertEquals(readersClub.queues.book1Queue.size(), 4);

    readersClub.lendBook(book22);
    readersClub.lendBook(book11);

    assertEquals(readersClub.queues.book2Queue.size(), 3);
    assertEquals(readersClub.queues.book1Queue.size(), 2);
  }

  @Test
  public void testGetQueue() throws Exception {
    assertEquals(readersClub.getQueue(book11.getBookTitle()),readersClub.queues.book1Queue);
    assertEquals(readersClub.getQueue(book22.getBookTitle()),readersClub.queues.book2Queue);
  }

  @Test
  public void testReturnBook() throws Exception {
    readersClub.registerMember(staff1);
    readersClub.registerMember(staff2);
    readersClub.registerMember(staff3);
    readersClub.registerMember(student2);
    readersClub.registerMember(student1);

    book22.setNumberOfCopies(5);
    book11.setNumberOfCopies(5);

    readersClub.library.add(book22);
    readersClub.library.add(book11);

    readersClub.requestToBorrowBook(staff2, book22);
    readersClub.requestToBorrowBook(staff1, book22);
    readersClub.requestToBorrowBook(student1, book11);
    readersClub.requestToBorrowBook(staff3, book11);
    readersClub.requestToBorrowBook(student2, book22);

    readersClub.lendBook(book22);
    readersClub.lendBook(book11);

    assertEquals(book11.getNumberOfCopies(), 3);
    assertEquals(book22.getNumberOfCopies(), 2);
    readersClub.returnBook(staff3, book11);
    readersClub.returnBook(student1, book11);
    readersClub.returnBook(staff1, book22);
    readersClub.returnBook(staff2, book22);
    readersClub.returnBook(student2, book22);

    assertEquals(book11.getNumberOfCopies(), 5);
    assertEquals(book22.getNumberOfCopies(), 5);
  }

  @Test
  public void testWhoGetBook() throws Exception {

    readersClub.registerMember(staff1);
    readersClub.registerMember(staff2);
    readersClub.registerMember(student3);
    readersClub.registerMember(student2);
    readersClub.registerMember(student1);

    book22.setNumberOfCopies(3);
    readersClub.library.add(book22);
    assertEquals(book22.getNumberOfCopies(), 3);

    readersClub.requestToBorrowBook(staff2, book22);
    readersClub.requestToBorrowBook(staff1, book22);
    readersClub.requestToBorrowBook(student1, book22);
    readersClub.requestToBorrowBook(student3, book22);
    readersClub.requestToBorrowBook(student2, book22);

    assertEquals(readersClub.queues.book2Queue.size(), 5);

    System.out.println(readersClub.whoGetBook(book22));
    System.out.println(readersClub.whoGetBook(book22));
    System.out.println(readersClub.whoGetBook(book22));
    System.out.println(readersClub.whoGetBook(book22));
    System.out.println(readersClub.whoGetBook(book22));
    readersClub.lendBook(book22);

    assertEquals(readersClub.queues.book2Queue.size(), 2);
  }
}