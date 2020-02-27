package sampler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by heisenbug on 2020/02/27.
 */
public class StreamBasicSampler {

    public static void joining(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("1");
        list.add("2");

        final String result = list.stream().map(s -> "["+s+"]").collect(Collectors.joining("|"));

        System.out.println("result "+result);
    }

    public static void main(String[] arg){
        joining();
    }
}
