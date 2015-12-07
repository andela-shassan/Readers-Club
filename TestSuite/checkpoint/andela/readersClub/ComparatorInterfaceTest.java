package checkpoint.andela.readersclub;

import checkpoint.andela.members.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Semiu on 05/12/2015.
 */
public class ComparatorInterfaceTest {
  Staff staff0 = new Staff();
  Staff staff1 = new Staff();
  {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
  Staff staff2 = new Staff();
  Student student1 = new Student();
  {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
  Student student2 = new Student();
  Student student3 = new Student();
  ComparatorInterface myComparator = new ComparatorInterface();

  // Test that it returns -1 if the first member has higher
  // precedence over the second member
  @Test
  public void testCompare() throws Exception {
    assertEquals(myComparator.compare(staff1, staff2), -1);
    assertEquals(myComparator.compare(staff1, student1), -1);
    assertEquals(myComparator.compare(staff2, student1), -1);
    assertEquals(myComparator.compare(student1, student2), -1);
  }

  // Test that it returns 1 if the second member has higher
  // precedence over the first member
  @Test
  public void testCompare2() throws Exception {
    assertEquals(myComparator.compare(staff2, staff1), 1);
    assertEquals(myComparator.compare(student3, staff1), 1);
    assertEquals(myComparator.compare(student1, staff2), 1);
    assertEquals(myComparator.compare(student2, student1), 1);
  }

  // Test that it returns 0
  // if the two members are equal in status and rank.
  @Test
  public void testCompare3() throws Exception {
    assertEquals(myComparator.compare(staff0, staff1), 0);
    assertEquals(myComparator.compare(student2, student3), 0);
  }
}