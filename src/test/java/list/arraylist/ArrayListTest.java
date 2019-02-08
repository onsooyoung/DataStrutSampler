package list.arraylist;

import dto.Friend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Iterator;

//Method 이름 정렬
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayListTest {

    ArrayList<Friend> friendList = new ArrayList<Friend>();

    @Before
    public void setupData(){

        //friendList.ensureCapacity(3);
        friendList.add(new Friend(1, "Harry"));
        friendList.add(new Friend(2, "Ron"));
        friendList.add(new Friend(5, "Dumbledore"));//key를 섞어보자.
        friendList.add(new Friend(3, "Hermione"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));
        friendList.add(new Friend(4, "Severus"));//Severrus copy magic

    }

    @Test
    public void checkSize(){
        System.out.printf("checkSize %s\n", friendList.toString());
        Assert.assertEquals(friendList.size(), 16);
    }

    @Test
    public void viewListByIterator(){
        //Iterator 통한 전체 조회
        Iterator iterator = friendList.iterator();
        while (iterator.hasNext()) {
            System.out.printf("viewListByIterator %s\n", iterator.next().toString());
        }
    }

    @Test
    public void checkFriend(){
        //viewList 볼때는 key로 정렬되어 보이나, 실제 할당된 객체는 다르다.
        Assert.assertEquals(friendList.get(2).getName(), "Dumbledore");
    }

    @Test
    public void viewListByForEash(){
        friendList.forEach(friend->
                System.out.printf("friendList　%s\n", friend.toString())
        );
    }

    @Test
    public void checkAddAll(){

        Assert.assertEquals(friendList.get(3).getName(), "Hermione");

        ArrayList<Friend> tmpFriendList = new ArrayList<Friend>();

        tmpFriendList.add( new Friend(6, "Sirius"));

        friendList.addAll(3, tmpFriendList);

       /* friendList.forEach(friend->
                System.out.printf("checkAddAll　%s\n", friend.toString())
        );*/

        Assert.assertEquals(friendList.get(3).getName(), "Sirius");
    }

    @Test
    public void chekIndexOf(){
        Assert.assertTrue(friendList.indexOf(new Friend(6, "Sirius"))==-1);//Sirius non exist
        Assert.assertTrue(friendList.indexOf(new Friend(3, "Hermione"))== 3);//Hermione exist
    }

    @Test
    public void checkLastIndexOf(){
        Assert.assertEquals(friendList.indexOf(new Friend(4, "Severus")), 4);
        Assert.assertEquals(friendList.lastIndexOf(new Friend(4, "Severus")), 15);
    }

    @Test
    public void checkSet(){

        //not append set is update
        friendList.set(1, new Friend(4, "Severus"));

        Assert.assertEquals(friendList.get(1), new Friend(4, "Severus"));
    }


}
