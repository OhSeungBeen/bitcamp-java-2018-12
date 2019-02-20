// Statement 와 SQL 삽입공격
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
        Scanner keyboard = new Scanner(System.in)){
      System.out.println("DBMS에 연결됨!");
      
      System.out.print("번호? ");
      int board_id = Integer.parseInt(keyboard.nextLine());
      System.out.print("제목? ");
      String title = keyboard.nextLine();

      System.out.print("내용? ");
      String contents = keyboard.nextLine();

      //SQL 삽입 공격
      // => 입력 문자열에 SQL 명령을 삽입하여 프로그램의 의도와 다르게 데이터를 조작하는 행위.
      // => 사용자가 입력한 값을 가지고 SQL 문장을 만들 때 이런 문제가 발생한다.
      // => 예를 들어 이 예제를 실행할 때 다음과 같이 입력해 보라!
      //번호? 4
      //제목? okok
      //내용? test',view_count =300, created_date = '2019-3-3 
      try (Statement stmt = con.createStatement()){
        int count = stmt.executeUpdate("update x_board set title='"+title+"',contents='"+contents+"'"+
            " where board_id="+board_id);
        
        // 위에서 사용자가 입력한 값을 가지고 SQL 문장을 만들면 다음과 같다.
        // update
        // update x_board set title='okok',contents=',view_count =300, created_date = '2019-3-3'
        // where board_id=4
        if(count == 0) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        } else {
          System.out.println("변경하였습니다.");
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
