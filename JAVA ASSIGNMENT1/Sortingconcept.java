package sortingconcept;
import java.util.Scanner;
import java.util.Arrays;

public class Sortingconcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner in = new Scanner(System.in); 
		        int n = in.nextInt();    
		        int[] array = new int[n];
		        int c;
		        for (c = 0; c < n; c++){
		            array[c] = in.nextInt();  
		        }
		        for (int i = 0; i < n-1; i++) 
		            for (int j = 0; j < n-i-1; j++) 
		                if (array[j] > array[j+1]) 
		                { 
		                    // swap arr[j+1] and arr[j] 
		                    int temp = array[j]; 
		                    array[j] = array[j+1]; 
		                    array[j+1] = temp; 
		                }
		        System.out.println(Arrays.toString(array));
		    }
		

	}

