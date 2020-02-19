package sampler;

import com.sun.org.apache.xpath.internal.operations.Or;
import dto.Order;
import manager.SampleDataFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by heisenbug on 2020/02/10.
 */
public class OrderStreamSampler {

    private static List<Order> orderList = null;

    //특정 주문건 찾기
    private static void createOrderList(int orderCnt, int productCnt){
        orderList = SampleDataFactory.getInstance().getOrderListForLambda(orderCnt, productCnt);
    }

    private static Predicate<Order> getPredicate(String orderId){

        return o-> o.getOrderId().equals(orderId);
    }

    // orderId에 해당하는 주문건을 찾아 응답, 미존재시 디폴트 주문 객체 응답
    private static Order findOrderById(String orderId){

        Stream<Order> orderStream = orderList.stream().filter(getPredicate(orderId));
        return orderStream.findFirst()
                .orElse(new Order(String.format("O%05d", 0) , "", null));
    }

   public static void main(String[] arg){

        createOrderList(100, 10);

        Order order = findOrderById("O00002");

        System.out.println(order.getOrderId());

    }
}
