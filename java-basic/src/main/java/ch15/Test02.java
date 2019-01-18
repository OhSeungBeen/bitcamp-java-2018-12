//클래스를 정의할때 수퍼 클래스를 지정하지 않으면
//컴파일러는 자동으로 objcet를 상속 받는다.
package ch15;

import ch12.c.My;

class My2{
  
}
public class Test02 {

  public static void main(String[] args) {
    My1 obj = new My1();
    
    //Object에서 상속 받은 메서드
    // 1) toString()
    //       - 클래스 정보를 간단히 출력한다.
    //       - 패키지명.클래스명@16진수해시값
    //       - 예) ch15.My@1e81f4dc
    System.out.println(obj.toString());
    // 해시값?
    // - 인스턴스 마다 고유된 고유의 식별자이다.class My2 {
    
    // - 주의! 주소 아니다!
    // - 인스턴스가 같은지 검사할 때 사용할 수 있다.
    // - toString()을 재정의하지 않고 원래 메서드를 그대로 사용하면
    // - 무조건 인스턴스마다 새 해시값이 부여된다.
    
    My2 obj2 = new My2();
    My2 obj3 = new My2();
    
    
  }
}

