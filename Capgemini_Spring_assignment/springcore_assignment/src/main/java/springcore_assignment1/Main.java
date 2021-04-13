package springcore_assignment1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

		public class Main {
			
			private static ApplicationContext context;

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				context = new ClassPathXmlApplicationContext("springcore_assignment1/Assignment1.xml");
				Customer cust = (Customer) context.getBean("customer");
				cust.details();

			}

		
		// TODO Auto-generated method stub

	}

