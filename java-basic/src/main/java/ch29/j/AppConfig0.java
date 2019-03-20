package ch29.j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:/ch29/j/jdbc.properties")
public class AppConfig0 {
  
  @Autowired
   Environment env;
  
  @Value("${jdbc.url}") String jdbcUrl;
  @Value("${jdbc.driver}") String jdbcDriver;
   
  @Bean
  public BlackBox blackBox() {
    BlackBox blackBox= new BlackBox();
    blackBox.setMaker(env.getProperty(jdbcUrl));
    blackBox.setModel(env.getProperty(jdbcDriver));
    return blackBox;
  }
  
  @Bean
  public Car car(BlackBox blackBox) {
    Car car = new Car();
    car.setMaker(jdbcUrl);
    car.setModel(env.getProperty("jdbc.driver"));
    car.setAuto(true);
    car.setBlackBox(blackBox);
    return car;
  }
  
  @Bean
  public Car car2(ApplicationContext iocContainer) {
    BlackBox blackBox =  (BlackBox) iocContainer.getBean("blackBox");
    
    Car car2 = new Car();
    car2.setMaker("비트자동차");
    car2.setModel("모델1");
    car2.setAuto(true);
    car2.setBlackBox(blackBox);
    return car2;
  }
}
