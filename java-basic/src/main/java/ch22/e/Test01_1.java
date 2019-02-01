// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Test01_1 {
  public static void main(String[] args) {

    // 다음 세 학생어 성적 정보를 Score.data 파일에 바이너리 형식으로 저장하라!
    // bufferedoutputstream 사용
    // dataoutputstream 사용

    Score s1 = new Score("홍길동", 100, 100, 100);
    Score s2 = new Score("임꺽정", 90, 90, 90);
    Score s3 = new Score("유관순", 80, 80, 80);
    
    

    try (FileOutputStream out = new FileOutputStream("Score.data");
        BufferedOutputStream out2 = new BufferedOutputStream(out);
        DataOutputStream out3 = new DataOutputStream(out2)){
      
      out3.writeUTF(s1.getName());
      out3.writeInt(s1.getKor());
      out3.writeInt(s1.getMath());
      out3.writeInt(s1.getEng());
      
      out3.writeUTF(s2.getName());
      out3.writeInt(s2.getKor());
      out3.writeInt(s2.getMath());
      out3.writeInt(s2.getEng());
      
      out3.writeUTF(s3.getName());
      out3.writeInt(s3.getKor());
      out3.writeInt(s3.getMath());
      out3.writeInt(s3.getEng());
     
      System.out.println("학생 정보를 Score.data에 저장하였습니다.");
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

}
