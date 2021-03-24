package armstrongnumber;
import java.util.Scanner;
public class Armstrongnumbercheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		        Scanner scan = new Scanner(System.in);
		        int number= scan.nextInt();
		        int temp = number; //153
		        int c=0,a;
		        while(number>0){
		            a = number%10; //1
		            number = number/10; //0
		            c = c +(a*a*a);  //27+125+1=153
		        }
		        if (temp==c){
		            System.out.println("It is an Armstrong number");
		        }
		        else{
		            System.out.println("It is not an Armstrong number");
		        }
		
		
	}

}
