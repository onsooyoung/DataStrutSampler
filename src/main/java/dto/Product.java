package dto;

import lombok.Data;
import lombok.Getter;

import java.util.Random;
import java.util.UUID;

/**
 * Created by heisenbug on 2020/02/08.
 */
@Data
@Getter
public class Product {

    private String productId;
    private String productName;
    private long price;



    public Product(String productId, String productName, long price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}
