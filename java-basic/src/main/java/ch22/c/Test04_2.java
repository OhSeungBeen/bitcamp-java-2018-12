
package ch22.c;

import java.io.FileInputStream;

public class Test04_2 {
  public static void main(String[] args) {

    try(FileInputStream out = new FileInputStream("data.bin");
        DataInputStream out2 = new DataInputStream(out)) {
      
      // 저장한 순서(파일 포맷)에 맞춰 읽어야 한다.
      int no = out2.readInt();
      String name = out2.readUTF();
      int age = out2.readInt();
      
      System.out.println(no);
      System.out.println(name);
      System.out.println(age);

    }catch (Exception e) {
      e.printStackTrace();
    } 

    System.out.println("출력 완료!");
  }
}
