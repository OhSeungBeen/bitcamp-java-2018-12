// 인스턴스 읽기 - 배열 활용
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02_2 {
  public static void main(String[] args) {
    // Score.data 파일에서 세학생의 데이터를 읽어 Score 인스턴스로 생성하라.

    Score[] students = null;

    try (
        DataInputStream in = new DataInputStream(
            new BufferedInputStream(
                new FileInputStream("Score.data")))){

      int len = in.readInt();
      students = new Score[len];

      for (int i = 0 ; i < students.length; i++) {
        Score s = new Score();
        s.setName(in.readUTF());
        s.setKor(in.readInt());
        s.setEng(in.readInt());
        s.setMath(in.readInt());
        students[i] = s;
      }

      for (Score s : students) {
        System.out.println(s);

      }


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }



    // 그리 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // = > 홍길동, 100, 100, 100 ,300 , 100
  }
}
