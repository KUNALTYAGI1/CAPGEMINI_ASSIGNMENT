package springcore_assignment8;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class App1 {
	
	public void run() {
		System.out.println("Application1 is running");
	}
	
	public void init(){
	      System.out.println("Bean is going through init.");
	}
	
	@PostConstruct
	public void start(){
	      System.out.println("Application is init.");
	}
	@PreDestroy
	public void end() {
	      System.out.println("Application is destroy.");
	}
	
	public void destroy() {
	      System.out.println("Bean will destroy now.");
	}

}

