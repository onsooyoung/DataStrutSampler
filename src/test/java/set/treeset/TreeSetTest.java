package set.treeset;

import dto.HarryFriend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

    TreeSet<HarryFriend> HarryFriendList = new TreeSet<HarryFriend>();

    @BeforeAll
    public void setupData(){

        HarryFriendList.add(new HarryFriend(1, "Harry"));
        HarryFriendList.add(new HarryFriend(2, "Ron"));
        HarryFriendList.add(new HarryFriend(5,"Dumbledore"));

        /*HarryFriendList.add(new HarryFriend(3,"Hermione"));
        HarryFriendList.add(new HarryFriend(4,"Severus"));*/
    }

    @Test
    public void compareTo(){//HarryFriend 객체에 재정의된 compareTo를 이용해서 비교

        assertTrue(new HarryFriend(5,"Dumbledore").compareTo(new HarryFriend(5,"Dumbledore")) == 0);
    }

    @Test
    public void viewHarryFriendList(){

        Iterator<HarryFriend> i = HarryFriendList.iterator();
        while (i.hasNext()){
            HarryFriend HarryFriend = i.next();
            System.out.printf("viewHarryFriendList %d, %s\n",HarryFriend.hashCode(), HarryFriend.toString());
        }

        //i.forEachRemaining(System.out::println);
    }

    @Test
    public void existHarryFriend(){

        //데이터는 동일하지만 해시코드는 다르다.
        System.out.printf("%d\n", new HarryFriend(1, "Harry").hashCode());

        //Harry 는 당연이 친구로 인정된다.
        assertTrue(HarryFriendList.contains(new HarryFriend(1, "Harry")));

        //name이 Malfoy라도 key가 Harry와 동일한 키므로 HarryFriend로 인정된다. 이럴수가..
        assertTrue(HarryFriendList.contains(new HarryFriend(1, "Malfoy")));

    }

    @Test
    public void searchHarryFriend(){

        // from ~ to
        SortedSet<HarryFriend> searchHarryFriendList
                = HarryFriendList.subSet(new HarryFriend(1, "Harry"), new HarryFriend(3,"Hermione"));

        Iterator<HarryFriend> i = searchHarryFriendList.iterator();
        while (i.hasNext()){
            HarryFriend HarryFriend = i.next();
            System.out.printf("searchHarryFriend %s\n", HarryFriend.toString());
        }
    }

    @Test
    public void searchHarryFriendHeadSet(){

        // key를 기준으로 작은것(기준값 미포함)
        SortedSet<HarryFriend> searchHarryFriendList
                = HarryFriendList.headSet(new HarryFriend(3, "Hermione"));

        Iterator<HarryFriend> i = searchHarryFriendList.iterator();
        while (i.hasNext()){
            HarryFriend HarryFriend = i.next();
            System.out.printf("searchHarryFriendHeadSet %s\n", HarryFriend.toString());
        }

        assertEquals(searchHarryFriendList.size(), 2);
    }

    @Test
    public void searchHarryFriendTailSet(){

        // key를 기준으로 큰것(기준값 포함)
        SortedSet<HarryFriend> searchHarryFriendList
                = HarryFriendList.tailSet(new HarryFriend(3, "Hermione"));

        Iterator<HarryFriend> i = searchHarryFriendList.iterator();
        while (i.hasNext()){
            HarryFriend HarryFriend = i.next();
            System.out.printf("searchHarryFriendTailSet %s\n", HarryFriend.toString());
        }

        assertEquals(searchHarryFriendList.size(), 3);
    }

    @Test
    public void cloneHarryFriend(){

        TreeSet<HarryFriend> HarryFriendCopyList = (TreeSet<HarryFriend>)HarryFriendList.clone();
        Iterator<HarryFriend> i = HarryFriendCopyList.iterator();
        while (i.hasNext()){
            HarryFriend HarryFriend = i.next();
            System.out.printf("cloneHarryFriend %d %s\n", HarryFriend.hashCode(), HarryFriend.toString());
        }

        assertEquals(HarryFriendList.size(), HarryFriendCopyList.size());

    }

    @Test
    public void searchHarryFriendCeiling(){

        //Object보다 같거나 큰 객체 찾기
        HarryFriend hermione = new HarryFriend(3, "Hermione");
        HarryFriend whois = HarryFriendList.ceiling(hermione);

        System.out.printf("%d\n", whois.getKey());

        assertEquals(whois.getKey() , 3);

    }

    @Test
    public void searchHarryFriendFloor(){

        //Object보다 같거나 작은 객체 찾기
        HarryFriend ron = new HarryFriend(2, "Ron");
        HarryFriend whois = HarryFriendList.floor(ron);

        System.out.printf("%d\n", whois.getKey());

        assertEquals(whois.getKey() , 2);

    }

    @Test
    public void searchHarryFriendHigher(){

        //Object보다 큰 객체 찾기
        HarryFriend ron = new HarryFriend(2, "Ron");
        HarryFriend whois = HarryFriendList.higher(ron);

        System.out.printf("%d\n", whois.getKey());

        assertEquals(whois.getKey() , 3);
    }

    @Test
    public void searchHarryFriendLower(){

        //Object보다 작은 객체 찾기
        HarryFriend ron = new HarryFriend(2, "Ron");
        HarryFriend whois = HarryFriendList.lower(ron);

        System.out.printf("%d\n", whois.getKey());

        assertEquals(whois.getKey() , 1);
    }


}
