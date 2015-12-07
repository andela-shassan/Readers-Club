package checkpoint.andela.members;

import checkpoint.andela.main.Member;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Semiu on 05/12/2015.
 */
public class StudentTest {
  Student student = new Student();

  // Every student should be an instance of Member Class
  @Test
  public void testStaffInstance() {
    assertTrue(student instanceof Member);
  }

  // Every student should be an instance of Student Class
  @Test
  public void testStaffInstance2() {
    assertTrue(student instanceof Student);
  }
}