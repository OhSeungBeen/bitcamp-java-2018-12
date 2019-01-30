package design_pattern.decorator.before;

public class HybridConvertiable extends Hybrid {

  // Hybird 상속 받았기 때문에
  // Hybird 기능은 그래도 사용한다.
  // 문제는 Convertible 기능을 갖기 위해
  // Convertible 클래스에 있는 코드를 그대로 복사해야 한다.
//
  boolean openRoof;

  public void open(boolean open) {
    this.openRoof = open;
  }

  public void run2() {
    if (openRoof) {
      System.out.println("뚜껑연다.");
    } else {
      System.out.println("뚜껑 닫는다.");
    }
    this.run();
  }
}
