package checkpoint.andela.members;

import org.junit.Test;
import checkpoint.andela.main.Book;

import static org.junit.Assert.*;

/**
 * Created by Semiu on 26/11/2015.
 */
public class StudentTest {
  Student student1 = new Student();
  Book book4 = new Book();

  @Test
  public void testBorrowBook() throws Exception {
    book4.setNumberOfCopies(10);
    student1.borrowBook(book4);
    assertEquals(book4.getNumberOfCopies(), 9);
  }

  @Test
  public void testReturnBook() throws Exception {
    book4.setNumberOfCopies(9);
    student1.returnBook(book4);
    assertEquals(book4.getNumberOfCopies(), 10);
  }
}