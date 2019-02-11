package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class CalculatorProcessor {

  Socket socket;
  BufferedReader in;
  PrintStream out;
  
  
  CalculatorProcessor(Socket socket){
    this.socket = socket;
  }
  
  public void execute() {
    try {
      in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());

      sendGreeting(out);

      while(true) {
        String response = in.readLine();
        if(isQuit(response,out))
          break;
        try {
          String values[] = response.split(" ");

          int a = Integer.parseInt(values[0]);
          String op = values[1];
          int b = Integer.parseInt(values[2]);

          int result = 0;

          switch(op) {
            case "+" : result = a+b; break;
            case "-" : result = a-b; break;
            case "*" : result = a*b; break;
            case "%" : result = a%b; break;
            case "/" : result = a/b; break;
            default : 
              out.printf(" %s 연산자를 지원하지 않습니다.\n",op);
              out.flush();
              continue;
          }
          out.printf("계산결과는 %d 입니다.\n",result);
          out.flush();
        }catch(Exception e) {
          try {
            out.println("계산형식이 잘못되었습니다.");
            out.flush();
          } catch(Exception e2) {}
        }
      } // while()

    }catch(Exception e) {
      e.printStackTrace();

    } finally {
      try{ out.close(); }catch(Exception e) {}
      try{ socket.close(); }catch(Exception e) {}
      try{ in.close(); }catch(Exception e) {}
    }
  }
  
  static boolean isQuit(String response, PrintStream out ) {

    if (response.equalsIgnoreCase("quit")) {
      out.println("안녕히 가세요!");
      out.flush();
      return true;
    }else
      return false;
    
  }
  
  static void sendGreeting(PrintStream out) {
    out.println("계산기 서버에 오신걸 환영합니다.");
    out.println("계산식을 입력하세요");
    out.println("예 35 + 2");
    out.println("");
  }
  
}
