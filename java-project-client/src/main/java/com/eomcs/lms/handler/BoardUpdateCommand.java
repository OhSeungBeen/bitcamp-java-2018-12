package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  
  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    Board board = new Board();
    
    System.out.print("수정할 번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    board.setNo(no);
    System.out.println("수정할 내용?");
    String contents = keyboard.nextLine();
    board.setContents(contents);
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    
    try {
    out.writeUTF("/board/update");
    out.flush();
    if (!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    
    out.writeObject(board);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK")) {
      throw new Exception("서버에서 게시글 수정 하기 실패!");

    }
    } catch(Exception e) {
      System.out.printf("게시글 상세 정보 출력 오류! : %s\n", e.getMessage());
    }   
}
}
