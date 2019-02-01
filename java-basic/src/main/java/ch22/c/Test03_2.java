
//바이트 데이터를 읽어 primitive data type으로 바꾸기
package ch22.c;

import java.io.FileInputStream;

public class Test03_2 {
  public static void main(String[] args) {

    try(FileInputStream in = new FileInputStream("data.bin")) {

      // 파일에서 4바이트를 읽어 int 변수에 저장하라!

      int value = 0;

      // 위의 4바이트 value 값을 출력하시오!

      System.out.println("데이터 쓰는 중...");

      value = value | in.read() <<24;
      value = value | in.read() <<16;
      value = value | in.read() <<8;
      value = value | in.read();

      System.out.println(Integer.toHexString(value));

    }catch (Exception e) {
      e.printStackTrace();
    } 

    System.out.println("출력 완료!");
  }
}

