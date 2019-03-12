// reflection API - 인스턴스 생성하기
package ch27.c;

import java.lang.reflect.Method;

public class Test02 {
  public static void main(String[] args) throws Exception {
    Student s1 = new Student("홍길동", "hong@test.com", true, 25);
    
    
    //인스턴스 메서드 호출하기:
    // => setName()
    Method m1 = s1.getClass().getMethod("setName", String.class);
    
    // => invoke(객체주소, 파라미터값, ...)
    m1.invoke(s1, "임꺽정"); // => s1.setName("임꺾정")
    System.out.println(s1);
    
    Method m2 = s1.getClass().getMethod("greeting", String.class, int.class, boolean.class);
    String str =  (String) m2.invoke(null, "유관순", 17, false);
    System.out.println(str);
  }
}
