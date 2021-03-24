import java.util.Scanner;
/**
 * CalSICI
 */
public class CalSICI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float p= scan.nextInt();
        float t= scan.nextInt();
        float r= scan.nextInt();
        float SI = ((p*r*t)/100);
        double CI = p*(Math.pow((1+r/100),t))-1;
        System.out.println("Simple Interest pf given value: "+SI);
        System.out.println("Compound Interest pf given value: "+CI);
    }
}