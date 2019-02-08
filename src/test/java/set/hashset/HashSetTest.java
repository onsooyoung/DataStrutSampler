package set.hashset;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

public class HashSetTest {

    HashSet<String> stringSet = new HashSet();

    Set<String> stringSetSecond = new HashSet();

    @Before
    public void setupData(){
        stringSet.add("element1");
        stringSet.add("element2");
        stringSet.add("element3");
        stringSet.add("element4");
    }

    @Test
    public void checkExist(){
        Assert.assertTrue(stringSet.contains("element1"));
    }

    @Test
    public void checkNoneExist(){
        Assert.assertFalse(stringSet.contains("element0"));
    }

    @Test
    public void checkSize(){
        Assert.assertTrue(stringSet.size() == 4);
    }

    @Test
    public void checkClear(){
        stringSet.clear();
        Assert.assertTrue(stringSet.isEmpty());
    }

    @Test
    public void checkAdd(){
        setupData();
        stringSet.add("element4");//duplicate
        stringSet.add("element5");
        Assert.assertTrue(stringSet.size() == 5);
    }

    @Test
    public void checkAddAll(){
        stringSetSecond.add("element5");//duplicate
        stringSetSecond.add("element6");
        stringSetSecond.add("element7");
        stringSetSecond.add("element8");
        stringSet.addAll(stringSetSecond);
        Assert.assertTrue(stringSet.size() == 8);
    }

    @Test
    public void checkContainAll(){

        stringSetSecond.add("element8");
        Assert.assertFalse(stringSet.containsAll(stringSetSecond));
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

        Assert.assertTrue(stringSetSecond.hashCode() == tempSet.hashCode());//value same is hashCode same
        Assert.assertTrue(stringSetSecond.equals(tempSet));
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

        Assert.assertFalse(stringSetSecond.hashCode() == tempSet.hashCode());
        Assert.assertFalse(stringSetSecond.equals(tempSet));

    }

    @Test
    public void checkRemove(){

        Assert.assertTrue(stringSet.contains("element1"));
        stringSet.remove("element1");
        Assert.assertFalse(stringSet.contains("element1"));
    }

    @Test
    public void checkRemoveAll(){

        stringSetSecond.add("element5");//duplicate
        stringSetSecond.add("element6");
        stringSetSecond.add("element7");
        stringSetSecond.add("element8");
        stringSet.addAll(stringSetSecond);

        Assert.assertTrue(stringSet.size() == 8);
        Assert.assertTrue(stringSet.removeAll(stringSetSecond));
        Assert.assertTrue(stringSet.size() == 4);
    }

    @Test
    public void checkIterable(){

        Set<String> stringSetTarget = new HashSet();
        Iterator<String> itr = stringSet.iterator();
        while( itr.hasNext()){
            stringSetTarget.add(itr.next());
        }

        Assert.assertTrue(stringSet.equals(stringSetTarget));
    }

    @Test
    public void checkRetainAll(){//교집합

        stringSetSecond.add("element2");//duplicate
        stringSetSecond.add("element3");
        stringSetSecond.add("element4");
        stringSetSecond.add("element5");
        stringSet.retainAll(stringSetSecond);

        Assert.assertTrue(stringSet.size()==3);//중복되는 요소는 3개

        Set<String> tempSet = new HashSet();
        tempSet.add("element2");//duplicate
        tempSet.add("element3");
        tempSet.add("element4");

        Assert.assertEquals(stringSet, tempSet);

    }

    @Test
    public void viewSpliterator(){

        Spliterator<String> s = stringSet.spliterator();//java8
        s.forEachRemaining(System.out::println);
    }




}
