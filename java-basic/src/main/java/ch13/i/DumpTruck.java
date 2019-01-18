//상속 : generalization (일반화) 수행 후
package ch13.i;

public class DumpTruck extends Car{
  int weight;
  
  public void dump() {
    System.out.println("짐을 내린다.");
  }
}
