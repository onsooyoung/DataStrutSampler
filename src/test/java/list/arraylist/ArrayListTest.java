package list.arraylist;

import dto.HarryFriend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    ArrayList<HarryFriend> HarryFriendList = new ArrayList<HarryFriend>();

    @BeforeAll
    public void setupData(){

        //HarryFriendList.ensureCapacity(3);
        HarryFriendList.add(new HarryFriend(1, "Harry"));
        HarryFriendList.add(new HarryFriend(2, "Ron"));
        HarryFriendList.add(new HarryFriend(5, "Dumbledore"));//key를 섞어보자.
        HarryFriendList.add(new HarryFriend(3, "Hermione"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));
        HarryFriendList.add(new HarryFriend(4, "Severus"));//Severrus copy magic

    }

    @Test
    public void checkSize(){
        System.out.printf("checkSize %s\n", HarryFriendList.toString());
        assertEquals(HarryFriendList.size(), 16);
    }

    @Test
    public void viewListByIterator(){
        //Iterator 통한 전체 조회
        Iterator iterator = HarryFriendList.iterator();
        while (iterator.hasNext()) {
            System.out.printf("viewListByIterator %s\n", iterator.next().toString());
        }
    }

    @Test
    public void checkHarryFriend(){
        //viewList 볼때는 key로 정렬되어 보이나, 실제 할당된 객체는 다르다.
        assertEquals(HarryFriendList.get(2).getName(), "Dumbledore");
    }

    @Test
    public void viewListByForEash(){
        HarryFriendList.forEach(HarryFriend->
                System.out.printf("HarryFriendList　%s\n", HarryFriend.toString())
        );
    }

    @Test
    public void checkAddAll(){

        assertEquals(HarryFriendList.get(3).getName(), "Hermione");

        ArrayList<HarryFriend> tmpHarryFriendList = new ArrayList<HarryFriend>();

        tmpHarryFriendList.add( new HarryFriend(6, "Sirius"));

        HarryFriendList.addAll(3, tmpHarryFriendList);

       /* HarryFriendList.forEach(HarryFriend->
                System.out.printf("checkAddAll　%s\n", HarryFriend.toString())
        );*/

        assertEquals(HarryFriendList.get(3).getName(), "Sirius");
    }

    @Test
    public void chekIndexOf(){
        assertTrue(HarryFriendList.indexOf(new HarryFriend(6, "Sirius"))==-1);//Sirius non exist
        assertTrue(HarryFriendList.indexOf(new HarryFriend(3, "Hermione"))== 3);//Hermione exist
    }

    @Test
    public void checkLastIndexOf(){
        assertEquals(HarryFriendList.indexOf(new HarryFriend(4, "Severus")), 4);
        assertEquals(HarryFriendList.lastIndexOf(new HarryFriend(4, "Severus")), 15);
    }

    @Test
    public void checkSet(){

        //not append set is update
        HarryFriendList.set(1, new HarryFriend(4, "Severus"));

        assertEquals(HarryFriendList.get(1), new HarryFriend(4, "Severus"));
    }


}
