// 계산기 클라이언트 만들기 : 최소 +, -, *, /, % 연산자는 지원한다. 
package ch23.c;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
실행 예:
- 클라이언트가 계산기 서버에 접속한 후 

계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
계산식을 입력하세요! <== 서버의 응답
예) 23 + 7 <== 서버의 응답
> 23 + 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
결과는 30 입니다. <== 서버의 응답
> 23 ^ 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
^ 연산자를 지원하지 않습니다. <== 서버의 응답
> ok + yes <== 사용자의 입력
식의 형식이 잘못되었습니다. <== 서버의 응답
> quit <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
안녕히 가세요! <== 서버의 응답

 */
public class CalculatorClient {
  
  public static void main(String[] args) {
    try(Socket socket = new Socket("127.0.0.1",8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        Scanner keyboard = new Scanner(System.in)){
      System.out.println("서버와 연결되었습니다.");
      
      String response = in.nextLine();
      String response2 = in.nextLine();
      String response3 = in.nextLine();
      System.out.println(response);
      System.out.println(response2);
      System.out.println(response3);
      
      System.out.print("> ");
      String num1 = keyboard.next();
      String operator = keyboard.next();
      String num2 = keyboard.next();
      
      out.println(num1);
      out.println(operator);
      out.println(num2);
      out.flush();
      
      String result = in.nextLine();
      System.out.println(result);
      
      
    } catch(Exception e) {
      System.out.println("서버와 연결 되지 않았습니다.");
    }
    
  }
}
