// 추상 메서드 상속
package ch17.a;

// => 추상 메서드가 없더라도 추상 클래스를 선언할 수 있다.
abstract class B {
    public void m1() {
      System.out.println("Hello");
    }
}

public class Test03 {

  public static void main(String[] args) {
    // c추상 클래스는 절대로 인스턴스를 생성할 수 업다.
    // Bob = new B();
    
    // 추상 클래스의 목적
    // => 추상 메서드가 있든 없든 상관없이 추상 클래스를 만들 수 있다.
    // => 서브 클래스에게 공통 필드나 메서드를 상속해주는 것이 목적이다.
    // => 여러 클래스를 같은 타입으로 묶기 위함이다.
    // => 상속에서 genralization을 통해 수퍼 클래스를 정의하는 경우에 주로 추상 클래스로 만든다.
    
    
  }
  

}
