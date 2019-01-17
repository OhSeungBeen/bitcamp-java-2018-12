package ch13.f;

public class B extends A{
  private int v2 = 200;
  
   public B() {
     super(); 
     v2 = 120;
     System.out.println("B.B()");
   }
   
  public void m2() {
    System.out.println("B.v1 = "+this.v2);
  }
}
