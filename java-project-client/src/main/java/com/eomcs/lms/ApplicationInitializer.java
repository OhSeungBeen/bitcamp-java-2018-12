package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDaoImple;
import com.eomcs.lms.dao.LessonDaoImple;
import com.eomcs.lms.dao.MemberDaoImple;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class ApplicationInitializer implements ApplicationContextListener{

  Connection con;
  @Override
  public void contextinitialized(HashMap<String,Object> context) {
    try {
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");


      Scanner keyboard = (Scanner) context.get("keyboard");
      
      LessonDaoImple lessonDao = new LessonDaoImple(con);
      context.put("/lesson/add", new LessonAddCommand(keyboard, lessonDao));
      context.put("/lesson/list", new LessonListCommand(keyboard, lessonDao));
      context.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonDao));
      context.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonDao));
      context.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonDao));

      MemberDaoImple memberDao = new MemberDaoImple(con);
      context.put("/member/add", new MemberAddCommand(keyboard, memberDao));
      context.put("/member/list", new MemberListCommand(keyboard, memberDao));
      context.put("/member/detail", new MemberDetailCommand(keyboard, memberDao));
      context.put("/member/update", new MemberUpdateCommand(keyboard, memberDao));
      context.put("/member/delete", new MemberDeleteCommand(keyboard, memberDao));

      BoardDaoImple boardDao = new BoardDaoImple(con);
      context.put("/board/add", new BoardAddCommand(keyboard, boardDao));
      context.put("/board/list", new BoardListCommand(keyboard, boardDao));
      context.put("/board/detail", new BoardDetailCommand(keyboard, boardDao));
      context.put("/board/update", new BoardUpdateCommand(keyboard, boardDao));
      context.put("/board/delete", new BoardDeleteCommand(keyboard, boardDao));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed() {
    try {
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



}
