package manager;

import dto.Friend;
import dto.Order;
import dto.Product;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by heisenbug on 2020/02/08.
 */
public class SampleDataFactory {

    private static SampleDataFactory sampleDataFactory;

    public static synchronized SampleDataFactory getInstance(){

        if(sampleDataFactory == null){
            return new SampleDataFactory();
        }
        return sampleDataFactory;
    }

    private final String[] names = {
                              "Harry"
                            , "Dumbledore"
                            , "Voldemort"
                            , "Snape"
                            , "Sirius"
                            , "Hermione"
                            , "Ron"
                            , "Draco"
                            , "Hagrid"
                            , "Neville"
                            , "Dobby"
                            , "Moody"
                            , "Lupin"
                            , "Bellatrix"
                            , "McGonagall"
                            , "Newt Scamander"
                            , "Grindelwald"
                            , "Tina"
                            , "Queenie"
                            , "Jacob" };

    public final static Date getRandomTimestamp() {
        return new Date(ThreadLocalRandom.current().nextInt() * 1000L);
    }

    public List<Friend> getFriendListForLambda(){
        return  Arrays.stream(names).map(n-> new Friend(n)).collect(Collectors.toList());
    }

    public Map<String, Product> getProductMap(int cnt){

        Map<String, Product> productMap = new HashMap<>();
        for(int i=0;i< cnt;i++){
            Product product = new Product();
            productMap.put(product.getProductId(), product);
        }

        return productMap;
    }

    public List<Order> getOrderList(int orderCnt , int orderByProductCnt){

        List<Order> order = new ArrayList<>();
        for(int i=0;i< orderCnt;i++){
            order.add(new Order(  String.format("O%05d", new Random().nextInt(orderCnt))
                                , getRandomTimestamp().toString()
                                , getProductMap(orderByProductCnt)));
        }

        return order;

    }


}
