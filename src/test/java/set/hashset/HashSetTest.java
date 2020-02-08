package set.hashset;

import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashSetTest {

    HashSet<String> stringSet = new HashSet();

    Set<String> stringSetSecond = new HashSet();

    @BeforeAll
    public void setupData(){
        stringSet.add("element1");
        stringSet.add("element2");
        stringSet.add("element3");
        stringSet.add("element4");
    }

    @Test
    public void checkExist(){
        assertTrue(stringSet.contains("element1"));
    }

    @Test
    public void checkNoneExist(){
        assertFalse(stringSet.contains("element0"));
    }

    @Test
    public void checkSize(){
        assertTrue(stringSet.size() == 4);
    }

    @Test
    public void checkClear(){
        stringSet.clear();
        assertTrue(stringSet.isEmpty());
    }

    @Test
    public void checkAdd(){
        setupData();
        stringSet.add("element4");//duplicate
        stringSet.add("element5");
        assertTrue(stringSet.size() == 5);
    }

    @Test
    public void checkAddAll(){
        stringSetSecond.add("element5");//duplicate
        stringSetSecond.add("element6");
        stringSetSecond.add("element7");
        stringSetSecond.add("element8");
        stringSet.addAll(stringSetSecond);
        assertTrue(stringSet.size() == 8);
    }

    @Test
    public void checkContainAll(){

        stringSetSecond.add("element8");
        assertFalse(stringSet.containsAll(stringSetSecond));
    }

    @Test
    public void checkEquality(){

        stringSetSecond.add("element5");//duplicate
        stringSetSecond.add("element6");
        stringSetSecond.add("element7");
        stringSetSecond.add("element8");

        Set<String> tempSet = new HashSet();
        tempSet.add("element5");//duplicate
        tempSet.add("element6");
        tempSet.add("element7");
        tempSet.add("element8");

        assertTrue(stringSetSecond.hashCode() == tempSet.hashCode());//value same is hashCode same
        assertTrue(stringSetSecond.equals(tempSet));
    }

    @Test
    public void checkNotEquality(){

        stringSetSecond.add("element5");//duplicate
        stringSetSecond.add("element6");
        stringSetSecond.add("element7");
        stringSetSecond.add("element8");

        Set<String> tempSet = new HashSet();
        tempSet.add("element5");//duplicate
        tempSet.add("element6");
        tempSet.add("element7");
        tempSet.add("element8");
        tempSet.add("element9");

        assertFalse(stringSetSecond.hashCode() == tempSet.hashCode());
        assertFalse(stringSetSecond.equals(tempSet));

    }

    @Test
    public void checkRemove(){

        assertTrue(stringSet.contains("element1"));
        stringSet.remove("element1");
        assertFalse(stringSet.contains("element1"));
    }

    @Test
    public void checkRemoveAll(){

        stringSetSecond.add("element5");//duplicate
        stringSetSecond.add("element6");
        stringSetSecond.add("element7");
        stringSetSecond.add("element8");
        stringSet.addAll(stringSetSecond);

        assertTrue(stringSet.size() == 8);
        assertTrue(stringSet.removeAll(stringSetSecond));
        assertTrue(stringSet.size() == 4);
    }

    @Test
    public void checkIterable(){

        Set<String> stringSetTarget = new HashSet();
        Iterator<String> itr = stringSet.iterator();
        while( itr.hasNext()){
            stringSetTarget.add(itr.next());
        }

        assertTrue(stringSet.equals(stringSetTarget));
    }

    @Test
    public void checkRetainAll(){//교집합

        stringSetSecond.add("element2");//duplicate
        stringSetSecond.add("element3");
        stringSetSecond.add("element4");
        stringSetSecond.add("element5");
        stringSet.retainAll(stringSetSecond);

        assertTrue(stringSet.size()==3);//중복되는 요소는 3개

        Set<String> tempSet = new HashSet();
        tempSet.add("element2");//duplicate
        tempSet.add("element3");
        tempSet.add("element4");

        assertEquals(stringSet, tempSet);

    }

    @Test
    public void viewSpliterator(){

        Spliterator<String> s = stringSet.spliterator();//java8
        s.forEachRemaining(System.out::println);
    }




}
