package ch29.k3;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ch29.a.AppConfig;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext appCtx = 
        new AnnotationConfigApplicationContext(AppConfig.class);
  
  }
}
