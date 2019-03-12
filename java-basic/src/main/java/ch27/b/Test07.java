// reflection API - 클래스가 갖고 있는 메서드 정보 알아내기
// => 클래스 안을 들여다 볼 때 사용하는 도구이다.
package ch27.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Test07 {
  public static void main(String[] args) throws Exception {

    Class<?> clazz = String.class;
    
    Constructor[] constructors = clazz.getConstructors();
    for (Constructor c : constructors) {
      System.out.printf("%s:\n",c.getName());
      
      Parameter[] params = c.getParameters();
      for (Parameter p : params) {
        System.out.printf("   %s:%s\n",
            p.getName(),
            p.getType()
            );
      }
    }
  }

}
