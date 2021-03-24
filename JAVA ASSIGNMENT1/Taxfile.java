package tax;
import java.util.Scanner;

public class Taxfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		/**
		 * tax
		 */
		
		        Scanner scan = new Scanner(System.in);
		        int salary = scan.nextInt();
		        if (salary>=0 && salary<=180000){
		            System.out.println("Zero Tax");
		        }
		        else if (salary>=181001 && salary<=300000){
		            int tax = (salary*10)/100;
		            System.out.println("Tax amount: "+ tax);
		        }
		        else if (salary>=300001 && salary<=500000){
		            int tax = (salary*20)/100;
		            System.out.println("Tax amount: "+ tax);
		        }
		        else if (salary>=500001 && salary<=1000000){
		            int tax = (salary*30)/100;
		            System.out.println("Tax amount: "+ tax);
		        }
		        else{
		            System.out.println("Hamari aaukat ke bahr");
		        }
		    
		

	}

}
