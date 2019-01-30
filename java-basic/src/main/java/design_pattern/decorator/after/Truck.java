package design_pattern.decorator.after;

public class Truck extends Car {
  int weight;
  
  
  @Override
  void run() {
    System.out.println("덜컹덜컹 달린다!");
  }
  
  
}
