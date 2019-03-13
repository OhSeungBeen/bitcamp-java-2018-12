package com.eomcs.lms.handler;
import com.eomcs.lms.dao.BoardDao;

public class HelloCommand extends AbstractCommand {

  
  public HelloCommand(BoardDao boardDao) {
    this.name = "/hello";
  }

  @Override
  public void execute(Response response) {
      response.println("안녕하세요!");
      
  }

}
