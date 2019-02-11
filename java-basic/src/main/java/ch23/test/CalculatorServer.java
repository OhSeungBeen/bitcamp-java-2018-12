package ch23.test;

import java.net.ServerSocket;

public class CalculatorServer {
  public static void main(String[] args) {

    try(ServerSocket serversocket = new ServerSocket(8888);){
      
      while(true) {
        new CalculatorProcessor(serversocket.accept()).execute();
      }//while()

    } catch(Exception e){
      System.out.println("통신중 오류가 발생하였습니다.");
    }



  }//main()


  


}//class()
