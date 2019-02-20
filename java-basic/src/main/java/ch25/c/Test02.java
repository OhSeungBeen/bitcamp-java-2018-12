// PreparedStatement를 이용하여 SQL 삽입 공격 차단하기
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    System.out.print("제목? ");
    String title = keyboard.nextLine();
    
    System.out.print("내용? ");
    String contents = keyboard.nextLine();
    
    keyboard.close();
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
      System.out.println("DBMS에 연결됨!");

      try (PreparedStatement stmt = con.prepareStatement(
          "update x_board set title = ?, contents = ? where board_id = ?")){

        stmt.setString(1, title);
        stmt.setString(2, contents);
        stmt.setLong(3, no);
        
        int count = stmt.executeUpdate();
        
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
