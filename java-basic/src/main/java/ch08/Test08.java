// 
package ch08;

import java.util.Scanner;

public class Test08 {
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("계산식?(예: 12 * 2) ");
    int a = keyboard.nextInt();
    String op = keyboard.next();
    int b = keyboard.nextInt();
    
    keyboard.close();
    
    int result = 0;
    switch(op) {
      //다른 패키지로 분류한 클래스를 사용한다는 것을 보여주기 위해
      // 일부로 import를 하지 않고 클래스를 사용한다.
      // => 어! 강사님, 헐.. 메서드를 사용할 수 없다 하네요.
      // 이유? 메서드의 접근 허용이 같은 패키지만 가능하다.
      //
      case "+": result = ch08.util.Calculator2.plus(a, b); break;
      case "-": result = ch08.util.Calculator2.minus(a, b); break;
      case "*": result = ch08.util.Calculator2.multiple(a, b); break;
      case "/": result = ch08.util.Calculator2.divide(a, b); break;
      default:
        System.out.println("지원하지 않는 연산자입니다.");
        return; // main() 메서드를 그만 실행하고 나간다. 즉 JVM 종료!
    }
    
    System.out.printf("%d %s %d = %d\n", a, op, b, result);
  }
  
  
  
  
  
}



