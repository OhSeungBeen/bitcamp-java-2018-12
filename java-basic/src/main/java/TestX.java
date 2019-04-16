class SuperClass {
  
  public void print() {
    System.out.println("Super Object");
  }
  
  public void draw() {
    print();
  }
}

class SubClass extends SuperClass{
  
  public void print() {
    System.out.println("Sub Object");
  }
  
  public void draw() {
    print();
    super.draw();
  }
}

public class TestX {
  public static void main(String[] args) {
    SuperClass subObj = new SubClass();
    subObj.draw();
    
    SuperClass superObj = new SuperClass();
  superObj.draw();
  }
}
