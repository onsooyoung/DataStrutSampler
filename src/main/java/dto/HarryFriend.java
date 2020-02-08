package dto;

import java.util.Comparator;

/**
 * Created by heisenbug on 2020/02/08.
 */
public class HarryFriend implements Comparable<HarryFriend>{
    private int key = 0;
    private String name = "";

    public HarryFriend(int key, String name){
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        HarryFriend friend = (HarryFriend)obj;
        if(key == friend.getKey() && name.equals(friend.getName()))
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(HarryFriend o) {
        return 0;
    }
}
