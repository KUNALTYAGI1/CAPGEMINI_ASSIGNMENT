package collection_a;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;

//public class Collection8 {
//  public static void main(String[] args)
//  {
//      Map<String, String> cityCode = new HashMap<String, String>();
//      cityCode.put("Delhi", "India");
//      cityCode.put("Moscow", "Russia");
//      cityCode.put("New York", "USA");

//      Iterator iterator = cityCode.keySet().iterator();

//      while (iterator.hasNext()) {
//          System.out.println(cityCode.get(iterator.next()));

//          // adding an element to Map
//          // exception will be thrown on next call
//          // of next() method.
//          cityCode.put("Istanbul", "Turkey");
//      }
//  }
//}

//************************************************************************************************************ */
//Fast-Safe Iterator

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

class Collection8 {
 public static void main(String args[])
 {
     CopyOnWriteArrayList<Integer> list
         = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });
     Iterator itr = list.iterator();
     while (itr.hasNext()) {
         Integer no = (Integer)itr.next();
         System.out.println(no);
         if (no == 5)

             // This will not print,
             // hence it has created separate copy
             list.add(14);
     }
 }
}

public class Collection_08 {

}
