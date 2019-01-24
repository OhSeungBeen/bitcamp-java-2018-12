// Object 클래스 - getClass() 와 배열의 항목이름
package ch15;


public class Test14 {
  public static void main(String[] args) {
    String obj1 = new String();
    Class classInfo = obj1.getClass();
    System.out.println(classInfo.getName());
    
    Class compTypeInfo = classInfo.getComponentType();
    System.out.println(compTypeInfo.getName());
    
    System.out.println(obj1.getClass().getComponentType().getName());
  }
}

