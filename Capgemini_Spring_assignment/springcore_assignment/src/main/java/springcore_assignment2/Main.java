package springcore_assignment2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


		public class Main {
			
			private static ApplicationContext context;

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				context = new ClassPathXmlApplicationContext("springcore_assignment2/Assignment2.xml");
				Collection col = (Collection) context.getBean("collection");
				
//				col.getQuestionList();
//				col.getQuestionSet();
//				col.getQuestionMap();
				col.showList();
				System.out.println("***********************");
				col.showSet();
				System.out.println("***********************");
				col.showMap();
			}

		}




