package ch21.b;

import java.util.Scanner;

public class DivideCommand implements Command{
  Scanner keyboard;

  public DivideCommand (Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    System.out.println("값1? ");
    int a = Integer.parseInt(keyboard.nextLine());
    System.out.println("값2? ");
    int b = Integer.parseInt(keyboard.nextLine());

    System.out.printf("%d / %d = %d", a, b, (a / b));
  }
}
