package ch13.e;

public class B extends A{
  private int v2 = 200;
  
  {
    v2 = 110;
    System.out.println("B.{}");
   }
   public B() {
     v2 = 120;
     System.out.println("B.B()");
   }
   
  public void m2() {
    System.out.println("B.v1 = "+this.v2);
  }
}
