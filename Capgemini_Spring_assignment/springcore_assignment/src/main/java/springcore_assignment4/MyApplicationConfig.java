package springcore_assignment4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
 
@Configuration
@PropertySource("classpath:/springcore_assignment4/DB.properties")
public class MyApplicationConfig {
 
    @Autowired
    Environment env;
     
    @Bean(name="dbConfig")
    public MyDbConfig getDbConfig(){
         
        MyDbConfig dbConf = new MyDbConfig();
        dbConf.setDbHost(env.getProperty("db.host.url"));
        dbConf.setDbPort(env.getProperty("db.port.number"));
        dbConf.setDbService(env.getProperty("db.service.name"));
        dbConf.setDbUser(env.getProperty("db.user"));
        dbConf.setDbPassword(env.getProperty("db.password"));
        return dbConf;
    }
}


