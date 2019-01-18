// 제네릭 적용 후 - 메서드가 다루는 객체의 타입을 파라미터로 받는다.
package ch16;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Test04 {
  public static void main(String[] args) {
    
    // echo() 의 리턴 값을 원하는 타입으로 받기 위해 형변환 해야 하는 일이 번거롭다.
    // => 해결책? 각 타입에 대해 echo()를 만들라
    //
    String obj = echo(new String("Hello"));
    Date obj2 = echo(new Date());
    Calendar obj3 = echo(Calendar.getInstance());
    File obj4 = echo(new File("okok"));
    Integer obj5 = echo(Integer.valueOf(100));
  }
  
  // 제네릭을 이용하면 여러 타입을 모두 수용할 수 있는 메서드를 만들 수 있다.
  // <다루는 타입의 별명> 리턴타입 메서드명(다루는_타입_별명 파라미터, ....){...}
  
  //다음 메서드 해석하기
  // => echo{} 메서드가 다루는 타입을 "Ok"라고 가정하자!
  // => echo()는 Ok라는 타입의 파라미터 값을 받고, Ok라는 타입의 객체(주소)를 리턴한다.
  // => 제네릭을 사용하면 특정 타입을 다루는 메서드를 여러 개 정의할 것을 한 개로 줄일 수 있다.
  // => 이때 "Ok"를 타입을 가리키는 별명으로 "타입 파라미터"라고 부른다.
  //
  public static <Ok> Ok echo(Ok obj) {
    return obj;
  }
}

/*
# 제네릭의 타입 파라미터로 많이 사용하는 이름
=> 보통 긴 이름을 사용하지 않고 다음과 같이 한 개의 대문자로 된 이름을 많이 사용한다.
T - Type이라는 의미를 표현할 수 있어 많이 사용하는 이름이다.
E - Element라는 의미로 목록의 항목을 가리킬 때 사용한다.
K - Key 객체를 가리킬 때 사용한다.
N - Number의 의미로 숫자 타입을 가리킬때 주로 사용한다.
V - Value의 의미로 값의 타입을 가리킬 때 사용한다.
S , U , V 등 - 한 번에 여러 타입을 가리킬 때 두번째, 세번째, 네번째 이름으로 주로 사용한다.

그러나 이름을 짓는것은 개발자 마음이다. 다만, 다른 개발자와의 원할한 소통을 위하여
가능한 위의 규칙에 따라 이름을 사용하기 바란다.
*/
