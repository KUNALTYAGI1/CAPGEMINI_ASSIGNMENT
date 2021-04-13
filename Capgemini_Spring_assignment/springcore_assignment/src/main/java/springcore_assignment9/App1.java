package springcore_assignment9;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

public class App1 implements InitializingBean, DisposableBean {
	
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
	
	public void stop() {
	      System.out.println("Bean will destroy now.");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("running interface");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub	
		System.out.println("destroy interface");
	}

}

