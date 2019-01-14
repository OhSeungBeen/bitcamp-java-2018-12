// 
package ch08;
class Test99 {
  int j =10;
  
  public void aa() {
    int j = 5;
    for(int i = 0; i < this.j; i++) {
      System.out.println(i);
    }
  }
}
public class Test09 {

  public static void main(String[] args) {
    Test99 t1 = new Test99();
    t1.aa();
  }
 }
  
  
  
  
  




