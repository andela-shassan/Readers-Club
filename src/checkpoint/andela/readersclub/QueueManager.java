package checkpoint.andela.readersclub;

import checkpoint.andela.main.Member;

import java.util.PriorityQueue;

/**
 * Created by Semiu on 02/12/2015.
 */
public class QueueManager {
  PriorityQueue<Member> book1Queue;
  PriorityQueue<Member> book2Queue;
  PriorityQueue<Member> book3Queue;
  PriorityQueue<Member> book1ReturnQueue;
  PriorityQueue<Member> book2ReturnQueue;
  PriorityQueue<Member> book3ReturnQueue;
  PriorityQueue<Member> generalQueue;

  ComparatorInterface compareMembers = new ComparatorInterface();
  // The constructor
  public QueueManager() {
    book1Queue = new PriorityQueue<>(10, compareMembers);
    book2Queue = new PriorityQueue<>(10, compareMembers);
    book3Queue = new PriorityQueue<>(10, compareMembers);
    book1ReturnQueue = new PriorityQueue<>(10, compareMembers);
    book2ReturnQueue = new PriorityQueue<>(10, compareMembers);
    book3ReturnQueue = new PriorityQueue<>(10, compareMembers);
  }

  public PriorityQueue<Member> createNewQueue(){
    generalQueue = new PriorityQueue<>(10, compareMembers);
    return generalQueue;
  }
}