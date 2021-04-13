package springcore_assignment9;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("springcore_assignment9/Assignment9.xml");
		App1 obj = (App1) context.getBean("App");
		obj.run();
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}

