package armstrongnumber;

public class armstrongfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		        for(int i=100;i<=999;i++){
		            int number = i;
		            int temp = number;
		            int c=0,a;
		            while(number>0){
		                a = number%10;
		                number = number/10;
		                c = c +(a*a*a);
		            }
		            if (temp==c){
		                System.out.println(temp);
		            }
		        }
		    
		

	}

}
