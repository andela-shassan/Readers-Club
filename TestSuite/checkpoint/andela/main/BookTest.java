package checkpoint.andela.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Semiu on 04/12/2015.
 */
public class BookTest {
  Book book1 = new Book("God are not to blame","Chinua Achebe", 2, "ISBN:08798-48");
  Book book2 = new Book("Success Is Mine","Opeyemi Idowu", 1, "ISBN:123-48M");


  @Test
  public void testSetNumberOfCopies() throws Exception {
    book2.setNumberOfCopies(10);
    assertEquals(book2.getNumberOfCopies() == 10, true);
  }

  // The number of copies of the book should decrease by one(1)
  // with every call of this method.
  @Test
  public void testDecrementBook() throws Exception {
    assertEquals(book1.getNumberOfCopies(),2);
    book1.decrementBook();
    assertEquals(book1.getNumberOfCopies(),1);
    book1.decrementBook();
    assertEquals(book1.getNumberOfCopies(),0);
  }

  // The number of copies of the book should not decrease
  // with call of this method if the number is not greater than zero.
  @Test
  public void testDecrementBook2() throws Exception {
    assertEquals(book1.getNumberOfCopies(),2);
    book1.setNumberOfCopies(0);
    assertEquals(book1.getNumberOfCopies(),0);
    book1.decrementBook();
    assertEquals(book1.getNumberOfCopies(),0);
    book1.decrementBook();
    book1.decrementBook();
    assertEquals(book1.getNumberOfCopies(),0);
  }

  // The number of copies of the book should increase by one(1)
  // with every call of this method.
  @Test
  public void testIncrementBook() throws Exception {
    assertEquals(book1.getNumberOfCopies(),2);
    book1.incrementBook();
    assertEquals(book1.getNumberOfCopies(),3);
    book1.incrementBook();
    book1.incrementBook();
    assertEquals(book1.getNumberOfCopies(),5);
  }

  @Test
  public void testIncrementBookByNoOfCopies() throws Exception {
    assertEquals(book1.getNumberOfCopies(),2);
    book1.incrementBookByNoOfCopies(5);
    assertEquals(book1.getNumberOfCopies(),7);
  }
}