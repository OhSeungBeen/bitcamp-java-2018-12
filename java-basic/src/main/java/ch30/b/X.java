package ch30.b;

import org.springframework.stereotype.Component;

@Component
public class X {
  // m1() 메서드를 실행하기 전에 기능 추가하기
  // => 다음과 같이 직접 해당 기능을 수행하는 코드를 삽입해야 한다.
  
  // 이 고전적인 방ㅇ식의 문제점?
  // 1) 원래 코드에 손을 대야 하기 때문에 유지보수에 좋지 않다.
  //    변경하면 또 기존 코드에 손대야 한다.
  // 2) 추가하는 클래스와 관계를 맺기 때문에 종속이 발생한다.
  // 3) 유사한 일을 하는 메서드에 같은 기능을 삽입할 때 여러 곳을 편집해야 하기 때문에 유지보수가 힘들다.
  // 4) 추가한 기능을 걷어 낼 때 매우 번거롭다.
  //
  // 예) DAO 객체의 메서드들을 실행하는데 걸리는 시간을 측정하기
  // 예) 특정 메서드가 실행될 때 로그를 남기기
  // 예) 모든 메서드의 리턴 값을 특정 타입으로 변환하기
  
  public void m1() {
    MyAdvice myAdvice = new MyAdvice();
    myAdvice.advice1();
    
    System.out.println("X.m1()");
  }
  
}
