package checkpoint.andela.readersClub;

import checkpoint.andela.main.Member;
import checkpoint.andela.members.*;

import java.util.Comparator;

/**
 * Created by Semiu on 26/11/2015.
 * This is a simple comparator interface that will be use to sort the queue.
 * It take two members as its argument and compare their status and rank.
 * It return -1, 0 or 1 accordingly.
 */
public class ComparatorInterface implements Comparator<Member> {

  @Override
  public int compare(Member member1, Member member2) {
    if (member1.getClass() == member2.getClass()) {
      return member1.getRegistrationDate().compareTo(member2.getRegistrationDate());
    }
    if(member1 instanceof Staff && member2 instanceof Student) {
      return -1;
    }
    return 1;
  }
}
