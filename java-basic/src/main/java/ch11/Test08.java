// StringBuffer클래스 사용법 
package ch11;

public class Test08 {
  public static void main(String[] args) {
    StringBuffer b1 = new StringBuffer("Hello");
    
    // StringBuffer는 mutable 객체이다. 내부의 문자열을 변경할 수 있다.
    StringBuffer b2 = b1.replace(2, 4, "xxxxx");
    System.out.println(b1.toString());
    System.out.println(b1); // 파라미터에 넘겨주는 값이 String이 아닐 경우에는

    System.out.println(b1 == b2);
  }
}
