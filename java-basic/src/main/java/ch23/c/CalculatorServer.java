// 계산기 서버 만들기
package ch23.c;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(8888)){
      while(true) {
        try (
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())) {

          out.println("계산기 서버에 오신 걸 환영합니다!");
          out.println("계산식을 입력하세요!");
          out.println("예) 23 + 7");
          out.flush();


          String num1 = in.nextLine();
          String operator = in.nextLine();
          String num2 = in.nextLine();
          

          int result = 0;
          if(operator.equals("+")) {
            result = plus(Integer.parseInt(num1),Integer.parseInt(num2));
          }else if(operator.equals("-")) {
            result = minus(Integer.parseInt(num1),Integer.parseInt(num2));

          }else if(operator.equals("/")) {
            result = divide(Integer.parseInt(num1),Integer.parseInt(num2));

          }else if(operator.equals("*")) {
            result = multiple(Integer.parseInt(num1),Integer.parseInt(num2));

          }else if(operator.equals("%")){
            result = remainder(Integer.parseInt(num1),Integer.parseInt(num2));

          }else { System.out.println("");}
          
          String result2 = String.valueOf(result);
          System.out.println(result2);
          out.println(result2);
          out.flush();
        }

      }
    } catch(Exception e) {
      System.out.println("서버 종류!");
    }

  }



  public static int plus(int a, int b) {
    return a + b;
  }

  public static int minus(int a, int b) {
    return a - b;
  }

  public static int multiple(int a, int b) {
    return a * b;
  }

  public static int divide(int a, int b) {
    return a / b;
  }

  public static int remainder (int a, int b) {
    return a % b;
  }

}
