package ch13.f;

public class A {
  private int v1 = 100;
  
  public A() {
    super();
    v1 = 120;
    System.out.println("A.A()");
  }
  public void m1() {
    System.out.println("A.v1 = "+this.v1);
  }
}
