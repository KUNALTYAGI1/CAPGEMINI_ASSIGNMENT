package springcore_assignment10;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class App1 implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware{
	
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

	public void setApplicationContext(ApplicationContext context) throws BeansException {
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Bean name is: "+name);
		
	}

}
