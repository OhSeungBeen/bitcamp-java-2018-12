package design_pattern.decorator.after;

public class Convertible extends Decorator{
  boolean openRoof;

  public Convertible(Car car) {
    super(car);
  }

  @Override
  void run() {
    
    // 생성자에서 받은 원래의 자동차를 실행한다.
    this.car.run();
    
    if(this.openRoof) {
      System.out.println("지붕을 연다!");
    }else
      System.out.println("지붕을 닫는다.");
    
  }

  public void openRoof(boolean openRoof) {
    this.openRoof = openRoof;
  }




}
