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
    public void getFriendListForLambdaTest(){

        List<Friend> friendList = sampleDataFactory.getFriendListForLambda();
        assertTrue(friendList.contains(new Friend("Harry")));
        assertFalse(friendList.contains(new Friend("XXXXXXX")));

    }

    @Test
    public void getProductMapTest(){
        assertEquals(sampleDataFactory.getProductMap(1000).size(), 1000);
    }

    @Test
    public void getOrderListTest(){

        List<Order> orderList = sampleDataFactory.getOrderList(10, 20);
        assertTrue(orderList.size() == 10);
        assertTrue(orderList.get(0).getProductList().size() == 20);

    }









}
