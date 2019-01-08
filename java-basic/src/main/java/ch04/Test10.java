// 논리 연산자: &&, ||, ^
package ch04;

public class Test10 {

  public static void main(String[] args) {
    System.out.println(true && true); // true
    System.out.println(true && false); // false
    
    System.out.println(true || true); // true
    System.out.println(true || false); // true
    System.out.println(false || false); // false
    
    System.out.println(true ^ true); // false
    System.out.println(false ^ false); // false
    System.out.println(false ^ true); // true
    
   // System.out.println(1 && 1); // 컴파일 오류!
    
    
    
    
  }
}
