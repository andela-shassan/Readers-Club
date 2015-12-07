package checkpoint.andela.members;

import checkpoint.andela.main.Member;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Semiu on 05/12/2015.
 */
public class StaffTest {
  Staff staff = new Staff();

  // Every staff should be an instance of Member Class
  @Test
  public void testStaffInstance() {
    assertTrue(staff instanceof Member);
  }

  // Every staff should be an instance of Staff Class
  @Test
  public void testStaffInstance2() {
    assertTrue(staff instanceof Staff);
  }

}