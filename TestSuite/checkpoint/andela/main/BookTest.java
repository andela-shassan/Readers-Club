package checkpoint.andela.main;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Semiu on 26/11/2015.
 */
public class BookTest {
  Book book1 = new Book("God are not to blame","Chinua Achebe", 5, "ISBN:08798-48");

  @Test
  public void testSetBookTitle() throws Exception {
    assertEquals(book1.getBookTitle(),"God are not to blame");
    book1.setBookTitle("Die another day");
    assertEquals(book1.getBookTitle(),"Die another day");
  }

  @Test
  public void testGetBookTitle() throws Exception {
    assertEquals(book1.getBookTitle(),"God are not to blame");
    assertEquals(book1.getNumberOfCopies(), 5);
  }

  @Test
  public void testSetBookAuthor() throws Exception {
    book1.setBookAuthor("Wole Soyinka");
    assertEquals(book1.getBookAuthor(),"Wole Soyinka");
  }


  @Test
  public void testDecrementBook() throws Exception {
    book1.decrementBook();
    assertEquals(book1.getNumberOfCopies(), 4);
  }

  // Test decrementBook() when the book is not currently available;
  @Test
  public void testDecrementBook2() throws Exception {
    book1.setNumberOfCopies(0);
    book1.decrementBook();
    assertEquals(book1.getNumberOfCopies(), 0);
  }

  @Test
  public void testIncrementBook() throws Exception {
    book1.incrementBook();
    assertEquals(book1.getNumberOfCopies(), 6);
  }
}