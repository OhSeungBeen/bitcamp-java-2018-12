package ch13.f;

public class Y extends X{
  private int v2 = 200;
  
   public Y() {
     //super(); //컴파일 오류! X클래스는 기본 생성자가 없다.
     super(500); // 이런 경우 개발자가 호출할 수퍼 클래스의 생성자를 명시해야 한다.
     
     System.out.println("B.B()");
   }
   
  public void m2() {
    System.out.println("B.v1 = "+this.v2);
  }
}
