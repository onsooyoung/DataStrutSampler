package set.treeset;

import dto.Friend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

    TreeSet<Friend> friendList = new TreeSet<Friend>();

    @Before
    public void setupData(){

        friendList.add(new Friend(1, "Harry"));
        friendList.add(new Friend(2, "Ron"));
        friendList.add(new Friend(5,"Dumbledore"));

        /*friendList.add(new Friend(3,"Hermione"));
        friendList.add(new Friend(4,"Severus"));*/
    }

    @Test
    public void compareTo(){//Friend 객체에 재정의된 compareTo를 이용해서 비교

        Assert.assertTrue(new Friend(5,"Dumbledore").compareTo(new Friend(5,"Dumbledore")) == 0);
    }

    @Test
    public void viewFriendList(){

        Iterator<Friend> i = friendList.iterator();
        while (i.hasNext()){
            Friend friend = i.next();
            System.out.printf("viewFriendList %d, %s\n",friend.hashCode(), friend.toString());
        }

        //i.forEachRemaining(System.out::println);
    }

    @Test
    public void existFriend(){

        //데이터는 동일하지만 해시코드는 다르다.
        System.out.printf("%d\n", new Friend(1, "Harry").hashCode());

        //Harry 는 당연이 친구로 인정된다.
        Assert.assertTrue(friendList.contains(new Friend(1, "Harry")));

        //name이 Malfoy라도 key가 Harry와 동일한 키므로 friend로 인정된다. 이럴수가..
        Assert.assertTrue(friendList.contains(new Friend(1, "Malfoy")));

    }

    @Test
    public void searchFriend(){

        // from ~ to
        SortedSet<Friend> searchFriendList
                = friendList.subSet(new Friend(1, "Harry"), new Friend(3,"Hermione"));

        Iterator<Friend> i = searchFriendList.iterator();
        while (i.hasNext()){
            Friend friend = i.next();
            System.out.printf("searchFriend %s\n", friend.toString());
        }
    }

    @Test
    public void searchFriendHeadSet(){

        // key를 기준으로 작은것(기준값 미포함)
        SortedSet<Friend> searchFriendList
                = friendList.headSet(new Friend(3, "Hermione"));

        Iterator<Friend> i = searchFriendList.iterator();
        while (i.hasNext()){
            Friend friend = i.next();
            System.out.printf("searchFriendHeadSet %s\n", friend.toString());
        }

        Assert.assertEquals(searchFriendList.size(), 2);
    }

    @Test
    public void searchFriendTailSet(){

        // key를 기준으로 큰것(기준값 포함)
        SortedSet<Friend> searchFriendList
                = friendList.tailSet(new Friend(3, "Hermione"));

        Iterator<Friend> i = searchFriendList.iterator();
        while (i.hasNext()){
            Friend friend = i.next();
            System.out.printf("searchFriendTailSet %s\n", friend.toString());
        }

        Assert.assertEquals(searchFriendList.size(), 3);
    }

    @Test
    public void cloneFriend(){

        TreeSet<Friend> friendCopyList = (TreeSet<Friend>)friendList.clone();
        Iterator<Friend> i = friendCopyList.iterator();
        while (i.hasNext()){
            Friend friend = i.next();
            System.out.printf("cloneFriend %d %s\n", friend.hashCode(), friend.toString());
        }

        Assert.assertEquals(friendList.size(), friendCopyList.size());

    }

    @Test
    public void searchFriendCeiling(){

        //Object보다 같거나 큰 객체 찾기
        Friend hermione = new Friend(3, "Hermione");
        Friend whois = friendList.ceiling(hermione);

        System.out.printf("%d\n", whois.getKey());

        Assert.assertEquals(whois.getKey() , 3);

    }

    @Test
    public void searchFriendFloor(){

        //Object보다 같거나 작은 객체 찾기
        Friend ron = new Friend(2, "Ron");
        Friend whois = friendList.floor(ron);

        System.out.printf("%d\n", whois.getKey());

        Assert.assertEquals(whois.getKey() , 2);

    }

    @Test
    public void searchFriendHigher(){

        //Object보다 큰 객체 찾기
        Friend ron = new Friend(2, "Ron");
        Friend whois = friendList.higher(ron);

        System.out.printf("%d\n", whois.getKey());

        Assert.assertEquals(whois.getKey() , 3);
    }

    @Test
    public void searchFriendLower(){

        //Object보다 작은 객체 찾기
        Friend ron = new Friend(2, "Ron");
        Friend whois = friendList.lower(ron);

        System.out.printf("%d\n", whois.getKey());

        Assert.assertEquals(whois.getKey() , 1);
    }


}
