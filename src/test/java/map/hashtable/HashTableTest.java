package map.hashtable;

import dto.Friend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by PC000411 on 2019-02-07.
 */
public class HashTableTest {

    Hashtable<Integer, Friend> friendTable = new Hashtable<Integer, Friend>();

    @Before
    public void setupData(){

        friendTable.put(0, new Friend(1, "Harry"));
        friendTable.put(1, new Friend(2, "Ron"));
        friendTable.put(2, new Friend(5, "Dumbledore"));
        /*friendTable.put(3, new Friend(3, "Hermione"));
        friendTable.put(4, new Friend(4, "Severus"));//magic copy
        friendTable.put(5, new Friend(4, "Severus"));
        friendTable.put(6, new Friend(4, "Severus"));
        friendTable.put(7, new Friend(4, "Severus"));
        friendTable.put(8, new Friend(4, "Severus"));*/
    }

    @Test
    public void checkKey(){
        Assert.assertTrue(friendTable.containsKey(0));
    }

    @Test
    public void check(){

        Hashtable<Integer, Friend> fakeFriendTable = new Hashtable<Integer, Friend>();
        fakeFriendTable.put(0, new Friend(1, "Harry"));
        fakeFriendTable.put(1, new Friend(2, "Ron"));
        fakeFriendTable.put(2, new Friend(5, "Dumbledore"));
        Assert.assertTrue(friendTable.contains(new Friend(1, "Harry")));
        //
    }

}
