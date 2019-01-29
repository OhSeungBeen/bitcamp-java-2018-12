package ch21.c;

import java.util.ArrayList;

public class Test07 {

  public static void main(String[] args) throws RuntimeException{
    // RuntimeException 예외는 굳이 메서드 선언부에 지정할 필요가 없다.
    // 지정하지 않아도 예가 발생하면 호출자에게 던진다.(보고한다)
    // 다문 그럼에도 메서드 선언부에 지정하는 이유는
    // 이메서드를 호출하는 개발자에게 이메서드에서 어떤 예외가 발생하는지 알려주기 위함이다.
    // 물론 이번 예제에서 main()에 붙이는 것은 아무 의미가 없다.
    ArrayList<String> list = new ArrayList<>();
    
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    
    // get() 메서드
    // => 목록에서 인덱스 지정한 위치의 값을 꺼내준다.
    // => 만약 인덱스가 무효하다면 IndexOutBoundsException 예외가 발생한다.
    // => IndexOutBoundsException은 RuntimeExcption 계열의 예외 클래스이다.
    //
    
    // RuntimeException 계열의 예외 처리하기
    // 1) try ~ catch를 사용하지 않으면 자동으로 호출자에게 보고된다.
    // 2) try ~ catch를 사용할 수 있다.
    // 3) throws 문장을 선언할 수 있다.
    // 
    // '방법3' 적용
    // => 그냥 두기!
      System.out.println(list.get(0));
      System.out.println(list.get(1));
      System.out.println(list.get(2));
      System.out.println(list.get(3));// 메서드에 선언된 대로 상위 호출자에게 보고한다.

      System.out.println("실행 중 오류 발생");
    // JVM은 예외를 보고 받으면 즉시 실행을 종료한다.
    // 따라서 다음 코드는 실행되지 않는다.
    System.out.println("종료");
  }
}
