// reflection API - 클래스가 갖고 있는 메서드 정보 알아내기
// => 클래스 안을 들여다 볼 때 사용하는 도구이다.
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import static java.lang.reflect.Modifier.*;

public class Test05 {
  public static void main(String[] args) throws Exception {

    Class<?> clazz = String.class;

    Method[] methods = clazz.getDeclaredMethods();
    for(Method m : methods) {
      System.out.printf("메서드명: %s.%s\n", m.getDeclaringClass().getSimpleName(),
          m.getName());


      System.out.println("파라미터:");
      Parameter[] params = m.getParameters();
      System.out.printf("파라미터: %d\n",m.getParameterCount());
      for (Parameter p : params) {
        System.out.printf("    %s:%s\n", 
            p.getName(), // 파라미터명
            p.getType()); // 파라미터 타입명
      }
      System.out.println("리턴 타입:");
      System.out.printf("    %s\n", m.getReturnType().getSimpleName());

      System.out.println("접근 제어");
      int modifiers = m.getModifiers();
      if ((modifiers & PUBLIC) == PUBLIC ){
        System.out.println("public");
      }else if ((modifiers & PROTECTED ) == PROTECTED ){
        System.out.println("protected");
      }else if ((modifiers & PRIVATE) == PRIVATE ){
        System.out.println("private");
      }else if ((modifiers & STATIC) != 0 ){
        System.out.println("static");
      }else if ((modifiers & FINAL) != 0 ){
        System.out.println("final");
      }


      System.out.println("-------------------------------");
    }
  }
}
