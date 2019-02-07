// 인스턴스 읽기 - 배열 활용
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test04_2 {
  public static void main(String[] args) {
    // Score.data 파일에서 세학생의 데이터를 읽어 Score 인스턴스로 생성하라.

    ArrayList<Score> students = new ArrayList<>();
    
    try (
        ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("Score.data")))){

      int len = in.readInt();

      for (int i = 0 ; i < len; i++) {
        Score score =((Score) in.readObject());
        students.add(score);
      }

      for (Score s : students) {
        System.out.println(s);

      }


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }



    // 그리 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // = > 홍길동, 100, 100, 100 ,300 , 100
  }
}
