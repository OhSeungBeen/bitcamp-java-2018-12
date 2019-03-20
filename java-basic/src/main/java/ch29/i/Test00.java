package ch29.i;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test00 {
  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/i/application-context-00.xml");
System.out.println("---------------------------------------------------------------");
    String[] names = iocContainer.getBeanDefinitionNames();
    
    for (String name : names) {
      System.out.print(name+" ==> ");
      System.out.println(iocContainer.getBean(name).getClass().getName());
    }
  }


}
