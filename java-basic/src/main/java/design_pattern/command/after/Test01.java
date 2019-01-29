package design_pattern.command.after;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    // Command 패턴
    
    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("/board/add", new BoardAddCommand());
    commandMap.put("/board/detail", new BoardDetailCommand());
    commandMap.put("/board/update", new BoardUpdateCommand());
    commandMap.put("/board/delete", new BoardDeleteCommand());
    commandMap.put("/board/list", new BoardListCommand());
    
    commandMap.put("/member/add", new MemberAddCommand());
    commandMap.put("/member/detail", new MemberDetailCommand());
    commandMap.put("/member/update", new MemberUpdateCommand());
    commandMap.put("/member/delete", new MemberDeleteCommand());
    commandMap.put("/member/list", new MemberListCommand());
    commandMap.put("hello", new Hello());
    
    while(true) {
      System.out.print("명령> ");
      String input = keyboard.nextLine();
      Command command = commandMap.get(input);
      
      if(command != null) {
       //명령어 사용규칙에 따라 메서드를 호출한다.
        command.exectue();
        
      } else if ("quit".equals(input)) {
        break;
      } else {
        System.out.println("처리할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboard.close();
  }

}
