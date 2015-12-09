package checkpoint.andela.readersclub;

import checkpoint.andela.main.Member;

import java.util.PriorityQueue;

/**
 * Created by Semiu on 02/12/2015.
 */
public class BookQueue {
  private PriorityQueue<Member> queue;

  ComparatorInterface compareMembers = new ComparatorInterface();

  public BookQueue() {
    queue = new PriorityQueue<>(10, compareMembers);
  }

  public void addMemberToQueue(Member member) {
    queue.add(member);
  }

  public boolean isEmpty(){
    return queue.isEmpty();
  }

  public Member pollQueue(){
    return queue.poll();
  }

  public int getQueueSize(){
    return queue.size();
  }

  public PriorityQueue<Member> getQueue(){
    return queue;
  }
}