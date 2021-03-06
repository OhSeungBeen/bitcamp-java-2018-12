//오버로딩 규칙
package ch14.d;

public class A {
  
  public void m1() {}
  // 메서드를 찾을 때 이름과 파라미터 타입, 개수로 구분하기 때문에
  // 리턴 타입이 다른 것은 구분할 수 없다.
  
  // public int m1() { // 컴파일 오류!
  //   return 0;
  // }
  // => 리턴 타입이 일치해야 오버로딩으로 간주한다.
  public void m1(int a) {}
  
  // => 파라미터 이름으로는 메서드를 구분할 수 없다.
  //public void m1(int b) { // 컴파일 오류!
  //}
  
  // => 파라미터 타입이 달라야 한다.
  public void m1(float a) {}
  
  public void m1(byte a) {}
  
  public void m1(short a) {}
  
  public void m1(long a) {}
  
  // => 파라미터 개수가 달라야 한다.
  public void m1(float a, float b) {} // ok
  public void m1(String a, String b) {} // ok
  
  // => 접근 범위는 상관없다.
  void m1(float a, int b) {}
  private void m1(float a, int b, int c) {}
  protected void m1(float a, int b, int c, String d) {}
  
  
  
}
