package design_pattern.command.after;

public class Hello implements Command{
  @Override
  public void exectue() {
    System.out.println("안녕하세요!");
  }
}
