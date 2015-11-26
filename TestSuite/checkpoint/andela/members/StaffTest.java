package checkpoint.andela.members;

import checkpoint.andela.main.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Semiu on 26/11/2015.
 */
public class StaffTest {
  Staff staff1 = new Staff();
  Book book1 = new Book();


  @Test
  public void testBorrowBook() throws Exception {
    book1.setNumberOfCopies(2);
    staff1.borrowBook(book1);
    assertEquals(book1.getNumberOfCopies(), 1);
  }

  @Test
  public void testReturnBook() throws Exception {
    book1.setNumberOfCopies(1);
    staff1.returnBook(book1);
    assertEquals(book1.getNumberOfCopies(), 2);
  }
}