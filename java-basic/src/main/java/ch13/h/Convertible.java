// 상속 : generalization(일반화) 수행 전
package ch13.h;


public class Convertible{
  String model;
  int cc;
  boolean open;
  
  public void run() {
    System.out.println("달린다");
  }
  public void stop() {
    System.out.println("멈춘다.");
  }
  
  public void openRoof() {
    open = true;
  }
  
  public void closeRoof() {
    open = false;
  }
  
}
