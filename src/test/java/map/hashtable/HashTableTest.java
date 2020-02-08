package map.hashtable;

import dto.HarryFriend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by PC000411 on 2019-02-07.
 */
public class HashTableTest {

    Hashtable<Integer, HarryFriend> HarryFriendTable = new Hashtable<Integer, HarryFriend>();

    @BeforeAll
    public void setupData(){

        HarryFriendTable.put(0, new HarryFriend(1, "Harry"));
        HarryFriendTable.put(1, new HarryFriend(2, "Ron"));
        HarryFriendTable.put(2, new HarryFriend(5, "Dumbledore"));
        /*HarryFriendTable.put(3, new HarryFriend(3, "Hermione"));
        HarryFriendTable.put(4, new HarryFriend(4, "Severus"));//magic copy
        HarryFriendTable.put(5, new HarryFriend(4, "Severus"));
        HarryFriendTable.put(6, new HarryFriend(4, "Severus"));
        HarryFriendTable.put(7, new HarryFriend(4, "Severus"));
        HarryFriendTable.put(8, new HarryFriend(4, "Severus"));*/
    }

    @Test
    public void checkKey(){
        assertTrue(HarryFriendTable.containsKey(0));
    }

    @Test
    public void check(){

        Hashtable<Integer, HarryFriend> fakeHarryFriendTable = new Hashtable<Integer, HarryFriend>();
        fakeHarryFriendTable.put(0, new HarryFriend(1, "Harry"));
        fakeHarryFriendTable.put(1, new HarryFriend(2, "Ron"));
        fakeHarryFriendTable.put(2, new HarryFriend(5, "Dumbledore"));
        assertTrue(HarryFriendTable.contains(new HarryFriend(1, "Harry")));
        //
    }

}
