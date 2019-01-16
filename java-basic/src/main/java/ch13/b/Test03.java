// 기능 확장 - 방법2) 상속 기능을 활용하기
package ch13.b;

public class Test03 {

  public static void main(String[] args) {
    // Score3를 이용하여 수퍼 클래스의 기능을 호출할 수 있따.
    // => Score2나 다를 바가 없다. 다만 Score3 compute()를 오버라이딩 했다.
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
