package checkpoint.andela.readersclub;

import checkpoint.andela.members.Staff;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Semiu on 09/12/2015.
 */
public class BookQueueTest {
  BookQueue bookQueue = new BookQueue();
  Staff staff1 = new Staff("Tosin", 'M', "10/06/1986", "hassan.ayomon@andela.com", "08036294879", 1234, 71.550);
  Staff staff2 = new Staff("Opeyemi Hassan",'M',"10th June, 1986", "semiu_hassan@ymail.com", "08056706725", 345, 45.663);

  @Test
  public void testAddMemberToQueue() throws Exception {
    assertEquals(bookQueue.getQueueSize(),0);
    bookQueue.addMemberToQueue(staff1);
    bookQueue.addMemberToQueue(staff2);
    assertEquals(bookQueue.getQueueSize(),2);

  }

  @Test
  public void testIsEmpty() throws Exception {
    assertEquals(bookQueue.isEmpty(), true);
    bookQueue.addMemberToQueue(staff1);
    assertEquals(bookQueue.isEmpty(), false);
  }

  @Test
  public void testPollQueue() throws Exception {
    assertEquals(bookQueue.getQueueSize(),0);
    bookQueue.addMemberToQueue(staff1);
    bookQueue.addMemberToQueue(staff2);
    assertEquals(bookQueue.pollQueue(), staff1);
    assertEquals(bookQueue.getQueueSize(),1);
  }

  @Test
  public void testGetQueueSize() throws Exception {
    assertEquals(bookQueue.getQueueSize(),0);
    bookQueue.addMemberToQueue(staff1);
    bookQueue.addMemberToQueue(staff2);
    assertEquals(bookQueue.getQueueSize(),2);
  }
}