package search;
import java.util.Scanner;

public class Search {
	
	
	    public static void main(String[] args) {
	        int[] a={5,12,14,6,78,19,1,23,26,35,37,7,52,86,47};
	        int i;
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
	        int num = scan.nextInt();
	        for(i=0;i<a.length;i++){
	            if (a[i]==num){
	                System.out.println(num+" value is in array");
	                break;
	            }
	        }
	        if (i ==15){
	            System.out.println(num+" value not in array");
	        }
	    }
	
	
	
	

}
