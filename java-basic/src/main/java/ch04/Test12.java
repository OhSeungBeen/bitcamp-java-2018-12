// 논리 연산자: &&, || vs &, |
package ch04;

public class Test12 {

  public static void main(String[] args) {
    int a = 5;
    int r = 10 / (a = 2);
    System.out.printf("%d, %d\n", a, r);
    
    // && 와 &의 차이점
    boolean b1 = true;
    boolean b2 = false && (b1 = false);
    System.out.printf("b1=%b, b2=%b\n", b1, b2);
    // && 연산자는 l-value의 값으로 결과를 유추할 수 있다면, r-value를 실행하지 않는다.
    b1 = true;
    b2 = false & (b1 = false);
    System.out.printf("b1=%b, b2=%b\n", b1, b2);
    // & 연산자는 l-value의 값으로 결과가 결정되었따 하더라도 r-value를 끝까지 실행한다.
    
    b1 = true;
    b2 = true || (b1 = false);
    System.out.printf("b1=%b, b2=%b\n", b1, b2);
    
    b1 = true;
    b2 = true | (b1 = false);
    System.out.printf("b1=%b, b2=%b\n", b1, b2);
    
  }
}
