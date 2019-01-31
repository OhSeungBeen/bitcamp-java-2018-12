// 버퍼 사용 - 사용 전 
//
package ch22.c;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01_1 {
  public static void main(String[] args) {

    try {
      long start = System.currentTimeMillis();

      FileInputStream in = new FileInputStream("jls11.pdf");
      int b;
      
      while ((b = in.read()) != -1) {
      }
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      in.close();

    }catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료!");
  }
}
