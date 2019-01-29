package design_pattern.command.after;

public class BoardDeleteCommand implements Command{
  //Command 규칙에 따라 동작하는 클래스를 정의한다.
  // 각 명령어를 처리하는 메서드를 클래스로분리한다.

  public void exectue() {
    System.out.println("게시물 삭제 처리");
  }

}
