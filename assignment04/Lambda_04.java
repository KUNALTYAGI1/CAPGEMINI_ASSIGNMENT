package lambda;
import java.util.ArrayList;
//import java.util.concurrent.CopyOnWriteArrayList;

/**
* Lambda4
*/
public class Lambda_04 {
 public static void main(String[] args) {
     ArrayList<String> list = new ArrayList<>();
     list.add("a");
     list.add("ab");
     list.add("abc");
     list.add("abcd");

     list.removeIf((i) -> ((i.length())%2!=0));
     System.out.println(list);
 }
}




//Conventional Java 7 method
//public class Lambda4 {
//  public static void main(String[] args) {
//      // ArrayList<String> list = new ArrayList<>();
//      CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//      list.add("a");
//      list.add("ab");
//      list.add("abc");
//      list.add("abcd");
//      for(String l:list)
//          if(l.length()%2!=0){
//              list.remove(l);
//          }
//      System.out.println(list);
//  }
 
//}

