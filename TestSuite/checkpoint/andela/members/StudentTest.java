package checkpoint.andela.members;

import checkpoint.andela.main.Book;
import checkpoint.andela.readersClub.ReadersClubManagement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Semiu on 26/11/2015.
 */
public class StudentTest {
  Student student1 = new Student();
  Book book1 = new Book();

  @Test
  public void testBorrowBook() throws Exception {
    ReadersClubManagement.books.add(book1);
    book1.setNumberOfCopies(10);
    student1.borrowBook(book1);
    assertEquals(book1.getNumberOfCopies(), 9);
    ReadersClubManagement.bookBorrowingQueue.clear();
    ReadersClubManagement.books.clear();
  }

  @Test
  public void testReturnBook() throws Exception {
    book1.setNumberOfCopies(9);
    student1.returnBook(book1);
    assertEquals(book1.getNumberOfCopies(), 10);
    ReadersClubManagement.bookReturningQueue.clear();
    ReadersClubManagement.books.clear();
  }
}