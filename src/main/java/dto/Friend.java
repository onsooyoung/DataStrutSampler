package dto;

/**
 * Created by PC000411 on 2019-01-31.
 */
// Comparator를 구현
public class Friend implements Comparable<Friend>{
    private int key = 0;
    private String name = "";

    public Friend(int key, String name){
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
        Friend friend = (Friend)obj;
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

    //객체 비교 방법 재정의
    @Override
    public int compareTo(Friend o) {

        //System.out.printf("compareTo %d, %d\n",this.key, o.key );
        if(this.key > o.key){
            return 1;
        }else if(this.key < o.key){
            return -1;
        }else{
            return 0;
        }
    }


}
