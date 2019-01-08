// 연산자 우선 수위
package ch04;

public class Test05 {

  public static void main(String[] args) {
    float r = 3.2f + 5 / 2;
    System.out.println(r); //5.2
    // => 연산자 우선 순위에 따라 *,/,% 연산자가 +,- 연산자 보다 먼저 계산된다.
    
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2);  //4.1
    // 연산자 우선 순위에서 괄호는 모든 연산자 보다 우선으로 취급된다.
    
    int a = 2;
    int r3 = a++ + (a++ * a++);
    System.out.println(r3);
    System.out.println(a);
    System.out.println(!true);
    a++;
  }
}
