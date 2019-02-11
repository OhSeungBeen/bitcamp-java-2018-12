package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

  public static void main(String[] args) {
    try(Socket socket = new Socket("localhost",8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner keyboard = new Scanner(System.in);
        ){
        while(true) {
          String input = in.readLine();
          System.out.println(input);
          if(input.length() <= 0)
            break;
        }
      while(true) {
        System.out.print("> ");
        String request = keyboard.nextLine();
        out.println(request);
        out.flush();
        
        String response = in.readLine();
        System.out.println(response);
        if(request.equalsIgnoreCase("quit"))
          break;
        
      } // while()
    } catch(Exception e) {

    }


  }
}
