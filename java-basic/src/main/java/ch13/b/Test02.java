// 기능 확장 - 방법2) 상속 기능을 활용하기
package ch13.b;

public class Test02 {

  public static void main(String[] args) {
    
    Score2 s = new Score2();
    s.setName("홍길동");
    s.setKor(100);
    s.setEng(100);
    s.setMath(100);
    s.setMusic(100);
    s.setArt(100);
    System.out.printf("%s: %d,%f",s.getName(),s.getSum(),s.getAver());
  }

}
