package assignment2;
abstract class Bike {
    abstract void run();
}

class Honda4 extends Bike {
    void run() {
        System.out.println("running safely");
    }
}
/**
 * absclass
 */
public class Abstractclass {

    public static void main(String[] args) {
        Bike obj = new Honda4();  
        obj.run(); 
    }
}


// 1 yes, if a class has abstract method then that must be abstract class.
// 2 Abstract class cannot be instantiate.
// 3 yes we must declare abstrract method in subclass.
// 4 abstract method cannot be private.
// 5 class can be either abstract or final, but not both
// 6 yes, we can declare class abstract without having an abstract method.




