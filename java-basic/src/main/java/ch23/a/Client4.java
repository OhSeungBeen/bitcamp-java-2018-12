// 타임아웃 시간 설정하기
package ch23.a;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client4 {

  public static void main(String[] args) throws Exception{
    Scanner keyboard = new Scanner(System.in);

    Socket socket = new Socket();
    System.out.println("소켓 생성됨.");

    SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8888);
    
    System.out.println("서버와 연결중...");
    socket.connect(socketAddress, 20000);
    System.out.println("서버와 연결되었음!");
    keyboard.nextLine(); 

    socket.close();
    System.out.println("서버와의 연결을 끊었음.");
    // 대기열의 크기에 따라 연결되는 클라이언트 수의 제한을 확인하기 위해
    // 여러 개의 클라이언트를 실행하라!

    keyboard.close();
  }

}
