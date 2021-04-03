package collection_a;
import java.util.*;  
public class Collection_03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }
}

