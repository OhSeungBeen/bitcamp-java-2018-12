// 로컬변수와 인스턴스 필드[변수] 초기화
package ch07;
public class Test07 {
  
  static class Score { 
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  public static void main(String[] args) {
    
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    // 다음과 같이 초기화시키지 않은 로컬 변수를 사용하려고 하면 컴파일 오류가 발생한다!
   //System.out.println(name); //컴파일 오류!
    
    
    Score s = new Score();
    System.out.println(s.name);
    System.out.println(s.kor);
    System.out.println(s.aver);
  }
  
}
