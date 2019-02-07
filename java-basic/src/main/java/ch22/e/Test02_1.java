// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Test02_1 {
  public static void main(String[] args) {

    // 다음 세 학생어 성적 정보를 Score.data 파일에 바이너리 형식으로 저장하라!
    // bufferedoutputstream 사용
    // dataoutputstream 사용
    Score[] students = { 
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80),};


    try ( DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("Score.data")))){
      
      out.writeInt(students.length);
      
      for(Score student : students) {
        out.writeUTF(student.getName());
        out.writeInt(student.getKor());
        out.writeInt(student.getMath());
        out.writeInt(student.getEng());
      }

      System.out.println("학생 정보를 Score.data에 저장하였습니다.");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

}
