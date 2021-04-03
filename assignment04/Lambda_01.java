package lambda;
/**
 * Lambda_01
 */
public class Lambda_01 {

    public static void main(String[] args) {
        
        airthmeticLambda addition = ( a, b) -> a+b;
        airthmeticLambda subtraction = ( a, b) -> a-b;
        airthmeticLambda multiplication = ( a, b) -> a*b;
        airthmeticLambda Division = ( a, b) -> a/b;
        System.out.println(addition.airthmetic(2, 2));
        System.out.println(subtraction.airthmetic(2, 2));
        System.out.println(multiplication.airthmetic(2, 2));
        System.out.println(Division.airthmetic(2, 2));
    }
}

/**
 * InnerLambda1
 */
interface airthmeticLambda {
    int airthmetic(int a, int b);
}

