package dto;

import lombok.Data;
import lombok.ToString;

import java.util.Random;

/**
 * Created by heisenbug on 2020/02/08.
 */
@Data
@ToString
public class Friend{

    private int age;
    private String name;

    public Friend(String name){
        this.name = name;
        this.age = getRandomAge();
    }

    int getRandomAge(){
        return new Random().nextInt(15);
    }

}
