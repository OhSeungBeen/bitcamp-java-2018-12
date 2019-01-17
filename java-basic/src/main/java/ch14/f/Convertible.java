package ch14.f;

public class Convertible extends Sedan{
  boolean Open; // 승차인원
  
  @Override
  public void run() {
    System.out.println("쌩~~ 달린다!.");
  }

}

