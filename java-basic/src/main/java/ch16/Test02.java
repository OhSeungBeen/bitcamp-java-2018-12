// 제네릭 적용 전 - object를 이용한 다형적 변수 사용 할때 형변환이 불편하다.
package ch16;


import java.util.Calendar;
import java.util.Date;

public class Test02 {
  public static void main(String[] args) {
    
    // echo() 의 리턴 값을 원하는 타입으로 받기 위해 형변환 해야 하는 일이 번거롭다.
    // => 해결책? 각 타입에 대해 echo()를 만들라
    //
    String obj = echo(new String("Hello"));
    Date obj2 = echo(new Date());
    Calendar obj3 = echo(Calendar.getInstance());
    
    // 이렇게 각 타입에 맞는 echo()를 정의하면 사용하기 편하다.
    // 형변환 할 필요가 없다.
    // 그러나 각 타입에 맞는 echo()를 여러 개 정의해야 하기 때문에
    // 그것도 똑같은 기능을 수행하는 메서드를 여러 개 만들어야 하기 때문에
    // 유지보수에 좋지 않다.
    //
    // Object의 다형적 변수를 이용한 방법과 각 메서드를 타입별로 만들어
    // 형변환을 하지 않는 이점을 모두 취할 수 있는 문법이 "제네릭(generic)"이다.
    //
  }
  
  // 제네릭 적용 전
  public static String echo(String obj) {
    return obj;
  }
  
  public static Date echo(Date obj) {
    return obj;
  }
  
  public static Calendar echo(Calendar obj) {
    return obj;
  }
}