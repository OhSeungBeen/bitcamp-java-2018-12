package design_pattern.chain_of_responsibility;

import java.util.Scanner;

public class Test01 {
  
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    TerminalHandler terminalHandler = new TerminalHandler();
    PlusHandler plusHandler = new PlusHandler();
    MinusHandler minusHandler = new MinusHandler();
    MultipleHandler multipleHandler = new MultipleHandler();
    
    plusHandler.setNext(minusHandler);
    minusHandler.setNext(multipleHandler);
    multipleHandler.setNext(terminalHandler);
    
    
    while (true) {
      System.out.print("a? ");
      int a = keyScan.nextInt();
      
      System.out.print("b? ");
      int b = keyScan.nextInt();
      
      System.out.print("operation? ");
      String op = keyScan.next();
      
      
      plusHandler.handle(a, b, op);
    }
    
  }
  
}
