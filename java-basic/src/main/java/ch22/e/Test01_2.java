// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01_2 {
  public static void main(String[] args) {
    // Score.data 파일에서 세학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    
    try (FileInputStream out = new FileInputStream("Score.data");
        BufferedInputStream out2 = new BufferedInputStream(out);
        DataInputStream out3 = new DataInputStream(out2)){
      
      Score s1 = new Score(out3.readUTF(),out3.readInt(),out3.readInt(),out3.readInt());
      Score s2 = new Score(out3.readUTF(),out3.readInt(),out3.readInt(),out3.readInt());
      Score s3 = new Score(out3.readUTF(),out3.readInt(),out3.readInt(),out3.readInt());
      
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
    
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    
    
    
    // 그리 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // = > 홍길동, 100, 100, 100 ,300 , 100
  }
}
