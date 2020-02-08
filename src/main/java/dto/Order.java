package dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by heisenbug on 2020/02/08.
 */
@Data
public class Order {

    private String orderId;
    private String orderDate;
    private Map<String, Product> productList;

    public Order(String orderId, String orderDate, Map<String, Product> productList) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.productList = productList;
    }
}
