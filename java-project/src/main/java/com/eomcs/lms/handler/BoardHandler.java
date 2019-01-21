package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  Scanner keyboard;
  ArrayList<Board> list;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listBoard() {
    Board[] boards = list.toArray(new Board[] {});
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    list.add(board);

    System.out.println("저장하였습니다.");
  }

  public void detailBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    for(int i = 0; i < list.getSize(); i++ ) {
      Board item = list.get(i);
      if(item.getNo() == no) {
        System.out.println(item.getContents());
        System.out.print(item.getCreatedDate()+" , ");
        System.out.println(item.getViewCount());
      }
    }
  }

  public void deleteBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    for(int i = 0; i < list.getSize(); i++ ) {
      Board item = list.get(i);
      if(item.getNo() == no) {
        list.remove(i);
        return;
      }
    }
  }

  public void updateBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    for(int i = 0; i < list.getSize(); i++ ) {
      Board board = list.get(i);
      Board temp = new Board();

      if(board.getNo() == no) {  
        temp.setNo(board.getNo());

        System.out.printf("내용?(%s)",temp.getContents());
        String input = keyboard.nextLine();
        if(input.length() <= 0)
          temp.setContents(temp.getContents());
        else
          temp.setContents(input);
        list.set(i, temp);
      }
    }
  }


}
