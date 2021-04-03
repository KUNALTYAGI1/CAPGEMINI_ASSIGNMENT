package collection_a;

import java.util.*; 

/**
 * Collection2
 */
public class Collection_02 {

    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();  //HashSet is an unordered list
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        System.out.println(set);

        LinkedHashSet<String> set1=new LinkedHashSet();  //LinkedHashSet is a ordered list
        set1.add("one");
        set1.add("two");
        set1.add("three");
        set1.add("four");
        set1.add("five");
        System.out.println(set1);
    }
}



