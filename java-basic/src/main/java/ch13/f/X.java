package ch13.f;

public class X {
  private int v1 = 100;
  
  public X(int value) {
    super();
    this.v1 = value;
    System.out.println("A.A()");
  }
  public void m1() {
    System.out.println("A.v1 = "+this.v1);
  }
}
