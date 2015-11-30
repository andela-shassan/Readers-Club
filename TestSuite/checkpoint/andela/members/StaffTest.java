package checkpoint.andela.members;

import checkpoint.andela.main.Book;
import checkpoint.andela.readersClub.ReadersClubManagement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Semiu on 26/11/2015.
 */
public class StaffTest {
  Staff staff1 = new Staff();
  Book book1 = new Book();


  @Test
  public void testBorrowBook() throws Exception {
    ReadersClubManagement.books.add(book1);
    book1.setNumberOfCopies(2);
    staff1.borrowBook(book1);
    assertEquals(book1.getNumberOfCopies(), 1);
    ReadersClubManagement.bookBorrowingQueue.clear();
    ReadersClubManagement.books.clear();
  }

  @Test
  public void testReturnBook() throws Exception {
    book1.setNumberOfCopies(1);
    staff1.returnBook(book1);
    assertEquals(book1.getNumberOfCopies(), 2);
    ReadersClubManagement.bookReturningQueue.clear();
    ReadersClubManagement.books.clear();
  }
}