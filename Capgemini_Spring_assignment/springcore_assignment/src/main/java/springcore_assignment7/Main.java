package springcore_assignment7;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@ComponentScan({"com.example.question_7"})
public class Main {

    public static void main(String[] args) {

        //ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");
        SPEL spel1 = applicationContext1.getBean(SPEL.class);
        //SPEL spel = applicationContext.getBean(SPEL.class);
        System.out.println(spel1.getAdd());
        System.out.println(spel1.getAddString());
        Car car = applicationContext1.getBean("someCar",Car.class);
        System.out.println(car);
    }

}
