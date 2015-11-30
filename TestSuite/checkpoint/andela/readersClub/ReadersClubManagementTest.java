package checkpoint.andela.readersClub;

import checkpoint.andela.main.Book;
import checkpoint.andela.members.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Semiu on 29/11/2015.
 */
public class ReadersClubManagementTest {
  Staff staff1 = new Staff("Hassan Semiu", 'M', "10/06/1986", "hassan.ayomon@andela.com", "08036294879", 1234, 71.550);
  {
    try {
      Thread.sleep(500);
    }catch(InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  Staff staff2 = new Staff("Opeyemi Hassan",'M',"10th June, 1986", "semiu_hassan@ymail.com", "08056706725", 345, 45.663);

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
  Student student3 = new Student();

  Book book1 = new Book("God are not to blame","Chinua Achebe", 2, "ISBN:08798-48");
  Book book2 = new Book("Success Is Mine","Opeyemi Idowu", 1, "ISBN:123-48M");
  @Test
  public void testRegisterMember() throws Exception {
    ReadersClubManagement.registerMember(staff2);
    ReadersClubManagement.registerMember(staff1);
    ReadersClubManagement.registerMember(student1);
    ReadersClubManagement.registerMember(student2);
    ReadersClubManagement.registerMember(student3);
    assertEquals(ReadersClubManagement.staffs.size(),2);
    assertEquals(ReadersClubManagement.students.size(),3);
  }

  @Test
  public void testAddBook() {
    ReadersClubManagement.books.add(book1);
    assertEquals(ReadersClubManagement.books.size(),1);
    ReadersClubManagement.books.add(book2);
    assertEquals(ReadersClubManagement.books.size(),2);
    ReadersClubManagement.books.clear();
    assertEquals(ReadersClubManagement.books.size(),0);
  }

  @Test
  public void testLendingBook() throws Exception {
    ReadersClubManagement.books.add(book1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 0);
    staff1.borrowBook(book1);
    assertEquals(book1.getNumberOfCopies() > 0, true);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 1);
    ReadersClubManagement.bookBorrowingQueue.clear();
    ReadersClubManagement.books.clear();
  }

  @Test
  public void testRetrieveBook() throws Exception {
    ReadersClubManagement.books.add(book1);
    staff1.borrowBook(book1);
    assertEquals(book1.getNumberOfCopies() == 1, true);
    assertEquals(ReadersClubManagement.bookReturningQueue.size(), 0);
    staff1.returnBook(book1);
    assertEquals(ReadersClubManagement.bookReturningQueue.size(), 1);
    assertEquals(book1.getNumberOfCopies() == 2, true);
    ReadersClubManagement.bookBorrowingQueue.clear();
    ReadersClubManagement.bookReturningQueue.clear();
    ReadersClubManagement.books.clear();
  }

  @Test
  public void testIsBookAvailable() throws Exception {
    assertEquals(ReadersClubManagement.isBookAvailable(book1), false);
    ReadersClubManagement.books.add(book1);
    assertEquals(ReadersClubManagement.isBookAvailable(book1), true);
    ReadersClubManagement.books.clear();
    assertEquals(ReadersClubManagement.isBookAvailable(book1), false);
  }

  @Test
  public void testAddToBorrowQueue() throws Exception {
    ReadersClubManagement.books.add(book1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 0);
    student1.borrowBook(book1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 1);
    ReadersClubManagement.bookBorrowingQueue.clear();
    ReadersClubManagement.books.clear();
  }

  @Test
  public void testAddToReturningQueue() throws Exception {
    ReadersClubManagement.books.add(book1);
    ReadersClubManagement.bookBorrowingQueue.clear();
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 0);
    student1.borrowBook(book1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 1);
    assertEquals(ReadersClubManagement.bookReturningQueue.size(), 0);
    student1.returnBook(book1);
    assertEquals(ReadersClubManagement.bookReturningQueue.size(), 1);
    ReadersClubManagement.bookBorrowingQueue.clear();
    ReadersClubManagement.bookReturningQueue.clear();
    ReadersClubManagement.books.clear();
  }

  @Test
  public void testWhoGetBook() throws Exception {
    ReadersClubManagement.books.add(book1);
    book1.setNumberOfCopies(3);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 0);
    student2.borrowBook(book1);
    staff2.borrowBook(book1);
    student3.borrowBook(book1);
    staff1.borrowBook(book1);
    student1.borrowBook(book1);
    ReadersClubManagement.whoGetBook(book1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.size(), 5);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.poll(), staff1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.poll(), staff2);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.poll(), student1);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.poll(), student2);
    assertEquals(ReadersClubManagement.bookBorrowingQueue.poll(), student3);
  }
}

