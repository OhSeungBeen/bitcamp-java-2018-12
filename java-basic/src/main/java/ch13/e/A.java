package ch13.e;

public class A {
  private int v1 = 100;
  {
   v1 = 110;
   System.out.println("A.{}");
  }
  public A() {
    v1 = 120;
    System.out.println("A.A()");
  }
  public void m1() {
    System.out.println("A.v1 = "+this.v1);
  }
}
