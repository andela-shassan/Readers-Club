package checkpoint.andela.main;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Semiu on 26/11/2015.
 */
public class BookTest {
  Book book1 = new Book("God are not to blame","Chinua Achebe", 5, "ISBN:08798-48");
  Book book2 = new Book();

  @Test
  public void testSetBookTitle() throws Exception {
    assertEquals(book2.getBookTitle(),null);
    book2.setBookTitle("Die another day");
    assertEquals(book2.getBookTitle(),"Die another day");
  }

  @Test
  public void testGetBookTitle() throws Exception {
    assertEquals(book1.getBookTitle(),"God are not to blame");
    assertEquals(book1.getNumberOfCopies(), 5);
  }

  @Test
  public void testSetBookAuthor() throws Exception {
    book2.setBookAuthor("Wole Soyinka");
    assertEquals(book2.getBookAuthor(),"Wole Soyinka");
  }


  @Test
  public void testDecrementBook() throws Exception {
    book1.decrementBook();
    book2.decrementBook();
    assertEquals(book1.getNumberOfCopies(), 4);
    assertEquals(book2.getNumberOfCopies(), 0);
  }

  @Test
  public void testIncrementBook() throws Exception {
    book1.incrementBook();
    assertEquals(book1.getNumberOfCopies(), 6);
  }
}