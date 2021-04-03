package lambda;
/**
 * Lambda_03
 */

import java.util.function.*;

/**
 * Lambda3
 */

/**
 * Lambda3
 */
// public class Lambda_03 {

//     public static void main(String[] args) {
//         Supplier<Integer> mylambda = () -> 1;
//         System.out.println(mylambda.get());
//     }
// }

/**
 * Lambda3
 */
public class Lambda_03 {

    static void printMessage(String name){  
        System.out.println("Hello "+name);  
    }  
    static void printValue(int val){  
        System.out.println(val);  
    }  
    public static void main(String[] args) {  
        // Referring method to String type Consumer interface   
        Consumer<String> consumer1 = Lambda_03::printMessage;  
        consumer1.accept("John");   // Calling Consumer method  
        // Referring method to Integer type Consumer interface  
        Consumer<Integer> consumer2 = Lambda_03::printValue;  
        consumer2.accept(12);   // Calling Consumer method  
    } 
}



//  Predicate
// public class Lambda3 {

//     static void pred(int number, Predicate<Integer> mylambda){
//         if(mylambda.test(number)){
//             System.out.println(number);
//         }
//     }
//     public static void main(String[] args) {
//         pred(10,(i)->i>7);
//     }
// }

