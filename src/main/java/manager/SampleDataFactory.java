package manager;

import dto.Friend;
import dto.Order;
import dto.Product;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by heisenbug on 2020/02/08.
 */
public class SampleDataFactory {

    private static SampleDataFactory sampleDataFactory;

    public final static String[] productCategoryCode = {"A", "B", "C" , "X", "Y", "Z" , "R"};
    public final static long[] productPrice = {1000, 1300, 2000, 5000,1000,1200, 10000};
    public final static String[] productName = {"IPAD", "IPHONE", "MACBOOK"};

     enum productName{
        IPAD, IPHONE, MACBOOK
    }

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


    public List<String> getFriendsNameList(){

        return Arrays.asList(names);
    }


    public List<Friend> getFriendListForOld(){

        List<Friend> friends = new ArrayList<>();
        for(String name: names){
            friends.add(new Friend(name));
        }

        return friends;
    }

    public List<Friend> getFriendListForLambda(){
        return  Arrays.stream(names).map(n-> new Friend(n)).collect(Collectors.toList());
    }


    public Map<String, Product> getProductMapOld(int cnt) {

        Map < String, Product > productMap = new HashMap<>();
         for (int i = 0; i < cnt; i++) {
            Product product = new Product(
                      productCategoryCode[new Random().nextInt(productCategoryCode.length-1)]
                    , productName[new Random().nextInt(productName.length-1)]
                    , productPrice[productPrice.length-1]
            );
            productMap.put(product.getProductId(), product);

        }
        return productMap;
    }

    public static Map<String, Product> getProductMapForLambda(int cnt){

        return IntStream.range(0,cnt).mapToObj(i->{
            return new Product(
                     productCategoryCode[new Random().nextInt(productCategoryCode.length-1)]
                            + String.format("%05d", i)
                    , productName[new Random().nextInt(productName.length-1)]
                    , productPrice[productPrice.length-1]);
        }).collect(Collectors.toMap(Product::getProductId, Function.identity()));
    }

    public List<Order> getOrderListOld(int orderCnt , int orderByProductCnt){

        List<Order> order = new ArrayList<>();
        for(int i=0;i< orderCnt;i++){
            order.add(new Order(  String.format("O%05d", new Random().nextInt(orderCnt))
                                , getRandomTimestamp().toString()
                                , getProductMapForLambda(orderByProductCnt)));
        }
        return order;
    }

    public List<Order> getOrderListForLambda(int orderCnt , int orderByProductCnt){

        return IntStream.range(0, orderCnt).mapToObj(i->
                {
                    return new Order(String.format("O%05d", i)
                            , getRandomTimestamp().toString()
                            , getProductMapForLambda(orderByProductCnt));
                }
        ).collect(Collectors.toList());
    }


}
