// 타임아웃 시간 설정하기
package ch23.a;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client3 {

  public static void main(String[] args) throws Exception{
    // 실행을 잠시 중단시키기 위해 사용
    Scanner keyboard = new Scanner(System.in);

    // 1) 소켓을 먼저 생성한 후 서버와의 연결을 시도한다.
    Socket socket = new Socket();
    System.out.println("소켓 생성됨.");

    // 2) 연결할 서버의 주소를 준비한다.
    SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8888);
    
    // 3) 서버와의 연결을 시도한다.
    System.out.println("서버와 연결중...");
    socket.connect(socketAddress, 5000);
    System.out.println("서버와 연결되었음!");
    keyboard.nextLine(); // 사용자가 엔터를 칠 때까지 다음 코드로 이동하지 않는다.

    socket.close();
    System.out.println("서버와의 연결을 끊었음.");
    // 대기열의 크기에 따라 연결되는 클라이언트 수의 제한을 확인하기 위해
    // 여러 개의 클라이언트를 실행하라!

    keyboard.close();
  }

}
