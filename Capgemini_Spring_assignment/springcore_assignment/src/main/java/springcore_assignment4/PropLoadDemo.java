package springcore_assignment4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 

public class PropLoadDemo {
 
    public static void main(String a[]){
 
        @SuppressWarnings("resource")
        ApplicationContext context = 
                        new AnnotationConfigApplicationContext(MyApplicationConfig.class);
        MyDbConfig dbConfig = (MyDbConfig) context.getBean("dbConfig");
        System.out.println(dbConfig.toString());
    }
}

