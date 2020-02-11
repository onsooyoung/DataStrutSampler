package sampler;

import dto.Order;
import manager.SampleDataFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by heisenbug on 2020/02/10.
 */
public class OrderStreamSampler {

    private static Predicate<Order> predicate  = o-> o.getOrderId().equals("O00002");

    //특정 주문건 찾기
    private static void orderList(){

        List<Order> orderList = SampleDataFactory.getInstance().getOrderListForLambda(10, 10);
        Optional<Order> orderOptional = orderList.stream().filter(predicate).findFirst();
        orderOptional.ifPresent(System.out::println);
    }

    public static void main(String[] arg){

        orderList();

    }
}
