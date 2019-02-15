// 1단계 - 데스크톱 용 계산기 애플리케이션 만들기
// => 개발자는 Calculator 클래스를 직접 사용한다.
package design_pattern.proxy.before1;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    Calculator calc = new Calculator();
    
    
    System.out.println(calc.plus(100, 200));
    System.out.println(calc.minus(100, 200));
    
  }

}
