package manager;

import dto.Friend;
import dto.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Created by heisenbug on 2020/02/08.
 */
public class TestSampleDataFactory {

    private SampleDataFactory sampleDataFactory;

    @BeforeAll
    public void init(){
        sampleDataFactory = SampleDataFactory.getInstance();
    }

    @Test
    public void getFriendListTest(){

        List<Friend> friendList = sampleDataFactory.getFriendListForOld();
        assertTrue(friendList.contains(new Friend("Harry")));
        assertFalse(friendList.contains(new Friend("XXXXXXX")));

        //lambda 표현식으로 구현한 부분도 결과값이 같은가?
        List<Friend> friendListLambda = sampleDataFactory.getFriendListForLambda();
        assertTrue(friendListLambda.contains(new Friend("Harry")));
        assertFalse(friendListLambda.contains(new Friend("XXXXXXX")));

    }

    @Test
    public void getProductMapTest(){

        assertEquals(sampleDataFactory.getProductMapOld(1000).size(), 1000);
        assertEquals(sampleDataFactory.getProductMapForLambda(1000).size(), 1000);
    }

    @Test
    public void getOrderListTest(){

        List<Order> orderList = sampleDataFactory.getOrderListOld(10, 20);
        assertTrue(orderList.size() == 10);
        assertTrue(orderList.get(0).getProductList().size() == 20);

        List<Order> orderListLambda = sampleDataFactory.getOrderListForLambda(10, 20);
        assertTrue(orderListLambda.size() == 10);
        assertTrue(orderListLambda.get(0).getProductList().size() == 20);

    }









}
