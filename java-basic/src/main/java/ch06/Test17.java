// JVM 아규먼트 응용
package ch06;
public class Test17 {

  public static void main(String[] args) {
    //JVM 아규먼트로 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // $ java -cp ./bin/main -Dname=홍길동 -Dkor=100 -Deng=100 -Dmath=90 ch06.Test17
    String name = System.getProperty("name");
    int kor = Integer.parseInt(System.getProperty("kor"));
    int eng = Integer.parseInt(System.getProperty("eng"));
    int math = Integer.parseInt(System.getProperty("math"));
    
    int sum = kor + eng + math;
    
    System.out.printf("이름: %s\n", name);
    System.out.printf("합계: %d\n", sum);
    System.out.printf("평균: %.1f\n",sum / 3f);
  }
}










