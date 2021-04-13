package springcore_assignment5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springcore_assignment5/Assignment5.xml");
        SurfaceArea surfaceArea = applicationContext.getBean("area",SurfaceArea.class);
        System.out.println(surfaceArea.display());
    }

}

