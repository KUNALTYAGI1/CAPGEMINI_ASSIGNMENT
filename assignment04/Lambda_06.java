package lambda;
import java.util.*;
import java.util.function.UnaryOperator;


/**
 * Lambda6
 */
public class Lambda_06 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Kunal");
        list.add("Aman");
        list.add("Raunak");
        UnaryOperator<String> uo = l -> l.toUpperCase();
        list.replaceAll(uo);
        System.out.println(list);
    }
}



// COnventional method in java7
/**
 * Lambda6
 */
// public class Lambda6 {
//     public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>();
        // list.add("Kunal");
        // list.add("Aman");
        // list.add("Raunak");
//         // list[1]="aman";
//         for (String l:list){
//             int index = list.indexOf(l);
//             String str = l.toUpperCase();
//             list.set(index, str);
//         }
//         System.out.println(list);
//     }
// }
