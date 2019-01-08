// 비트 연산자 : & , |, ^, ~
// => 용도 : 이미지 프로세싱 분야에서 사용됨
package ch04;

public class Test13 {

  public static void main(String[] args) {
    int a = 0xca;
    int b = 0x66;
    System.out.println(a & b); // 0x42
    System.out.println(a | b); // 0xee
    
    System.out.println(a ^ b); // 0xac
    System.out.println(~a);
    
    // & 활용: 특정 값을 차단하고 특정 값만 통과시킬 때
    int data = 0b1111_1001_0111_1111;
    System.out.println(Integer.toBinaryString(data & 0b0000_1111_1100_0000));
    
    // 예) 그림의 한 픽셀에서 빨강 색을 제거하고 싶다.
    int pixel = 0x003f4478; // 각바이트 값이 '00RRGGBB' 이라 가정하자.
    System.out.println(pixel & 0x0000ffff);
    
    //위에 픽셀에서 파란색의 값을 강화시키고 싶다.
    System.out.println(pixel | 0x00000057);
  }
}
