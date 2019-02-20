// java.sql.ResultSet 객체 - 서버에서 select의 결과를 가져오기
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test07 {
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
      System.out.println("DBMS에 연결됨!");

      try (Statement stmt = con.createStatement()){

        // Statement 구현체를 이용하여 SQL문을 서버에 전달한다.
        // executeUpdate() : insert, update delete 등 DDL,DML 문법을 전달한다.
        // executeQuery() : select 문법을 전달한다.
        // execute() : 모든 SQL문을 전달한다.
        // executeBatch() 여러 개의 SQL을 전달한다.

        // ExecuteQuery()의 리턴 값은 ResultSet 구현체 이다.
        // ResultSet 객체?
        // => 서버의 select 실행 결과를 가져온다.
        // => 단 한개씩 가져온다. 한번에 모두 가져오는 것이 아니다.
        // => 레코드에서 컬럼값을 꺼낼 때 컬럼의 번호는 1부터 시작한다.
        //
        try(ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc")){

          // next()
          // - 서버에서 한 개의 row(record)를 가져온다.
          // - 만약 가져올 레코드가 없으면 false를 리턴한다.
          // - select 문자에서 컬럼의 이름을 지정한 대신에 *를 사용한다면,
          //   컬럼의 순서는 테이블을 생성할 때 지정한 컬럼 순서와 같다.
          while(rs.next()) {
            // 서버에서 받아 온 레코드에서 컬럼 값 꺼내기
            // => getXxx(컴럼명) 또는 getXxx(컬럼 번호)
            // => 정수값 컬럼 : getInt(), varchar/char/text 문자열 컬럼: getString()
            System.out.printf("%d, %s, %s, %s, %d\n",
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDate(4),
                rs.getInt(5));
          }
        }

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
