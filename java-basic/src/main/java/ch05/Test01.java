package ch05;

public class Test01 {

  public static void main(String[] args) {
    int age = 20;
    
    if (age >= 20) System.out.println("성인입니다.");
    
    // 보통 조건 다음에 오는 문장을 다음 줄에 놓는다.
    if (age >= 20)
      System.out.println("성인입니다.");
    
    //실행할 문장이 여러 개이면 중괄호로 묶어야 한다.
    if (age >= 20) {
      System.out.print("성인");
      System.out.println("입니다.");
    }
    System.out.println("-----------------------------------");
    //주의!
    //중괄호로 묶지 않았을 때 문제점
    if (age >= 20)
      System.out.print("성인");
      System.out.println("입니다."); // 주의! 이문장은 if 문에 종속되지 않는다.
    }

}
