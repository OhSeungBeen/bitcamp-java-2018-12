
package ch22.c;

import java.io.FileInputStream;

public class Test04_3 {
  public static void main(String[] args) {

      // 데코레이터 디자인 패턴의 장점은 
    // => 기능을 선택적으로 붙이고 뗄수 있다. 
    //
    try(FileInputStream in = new FileInputStream("data.bin");
        // 버퍼 데코레이터 붙인다. =>읽기 속도 빨라진다.
        BufferedInputStream in1 = new BufferedInputStream(in);
        // primitive type 변환 데코레이터를 붙인다 => 코딩이 간결해 진다..
        DataInputStream in2 = new DataInputStream(in1)) {
      
      // 저장한 순서(파일 포맷)에 맞춰 읽어야 한다.
      int no = in2.readInt();
      String name = in2.readUTF();
      int age = in2.readInt();
      
      System.out.println(no);
      System.out.println(name);
      System.out.println(age);

    }catch (Exception e) {
      e.printStackTrace();
    } 

    System.out.println("출력 완료!");
  }
}
