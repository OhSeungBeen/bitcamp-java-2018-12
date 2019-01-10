// 패키지 멤버 클래스와 중첩 클래스(nested class)
package ch07;

//패키지 멤버 클래스
class Score1 { 
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
}

public class Test10 {
  
  //스태틱 클래스
  static class Score2 { 
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
   //논 스태틱 클래스
  class Score3 { 
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {
    //로컬 클래스
    class Score4 { 
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }
    
    //익명 클래스
    Object obj = new Object() {
      String name;
      int age;
    };
    
  }
  static void m1() {
    Score1 s1 = new Score1();
    
    Score2 s2 = new Score2();
    
    //Score3 s3 = new Score3(); // 컴파일오류!
    
    //Score4 s4 = new Score4(); // 컴파일오류!
  }
  
  void m2() {
    Score1 s1 = new Score1();
    
    Score2 s2 = new Score2();
    
    Score3 s3 = new Score3(); 
    
    //Score4 s4 = new Score4(); // 컴파일오류!
  }
  
  
}
