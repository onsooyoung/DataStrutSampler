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

    private final static String[] productCategoryCode = {"A", "B", "C" , "X", "Y", "Z" , "R"};

    public Product() {
        this.productId = String.format(productCategoryCode[new Random().nextInt(productCategoryCode.length)]+"%5d",UUID.randomUUID().toString());
        this.productName = UUID.randomUUID().toString().substring(0,5);
        this.price = new Random().nextLong();

    }

}
