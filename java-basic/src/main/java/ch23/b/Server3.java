// 데이터 주고 받기 -파일 받는 서버 만들기
package ch23.b;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import ch22.c.BufferedOutputStream;


public class Server3 {

  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (
          Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          DataInputStream in = new DataInputStream(
              new BufferedInputStream(socket.getInputStream()))){
        System.out.println("클라이언트가 연결되었음.");

        long fileLen = in.readLong();
        System.out.printf("보내는 파일의 크기: %s\n", fileLen);
        System.out.println();
        String filename = in.readUTF();
        System.out.printf("보내는 파일의 이름: %s\n", filename);

        File file = new File("temp/download/"+filename);

        // 클라이언트가 보낸 데이터를 읽어서 출력한다.
        try(BufferedOutputStream fileOut = new BufferedOutputStream(
            new FileOutputStream(file))){

          System.out.println("파일일 받는 중...");
          for (long i = 0; i < fileLen; i++) {
            fileOut.write(in.read());
          }
          fileOut.flush();

          out.println("success");
          fileOut.flush();


        }catch (Exception e) {
          out.println("fail");
          out.flush();
        }
      }
      
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("서버 종료!");
    }
    System.out.println("클라이언트와의 연결을 끊었음.");
  }
}

