// 생성자 - 기본 생성자(default constructor)
package ch10;

class Monitor8 {
  
  int bright; // 밝기 (0% ~ 100%)
  int contrast = 50; // 명암 (0% ~ 100%)
  int widthRes; // 해상도 너비
  int heightRes = 1080; // 해상도 높이
  
  // 만약 생성자가 한개라도 있으면 컴파일러는 기본 생성자를 추가하지 않는다.
  //public Monitor7() {} // 공개된 기본 생성자 추가
  
  //
  Monitor8 (int bright, int contrast) {
    this.bright = bright;
    this.contrast = contrast;
  }
  
  public void on() {
    // 모니터를 켜면 bright, contrast, widthRes, heightRes 값에 맞춰서
    // LCD의 불을 밝힌다.
    System.out.println("화면을 출력한다.");
    
  }
}

public class Test10 {
  public static void main(String[] args) {
    // 인스턴스 생성
    
    // 1) 클래스에 기본 생성자가 없다고 해서 다음과 같이 인스턴스를 생성할 수는 없다.
    //new Monitor6; // 컴파일 오류!
    
    //존재하는 생성자를 지정해야 하고, 그 생성자의 파라미터에 맞춰 값을 넘겨야 한다.
    // => Monitor8 설계도에 따라 인스턴스를 생성한 후, int 값 두개를 받는 생성자를 호출하라는 의미이다.
    
    
  }
}
















