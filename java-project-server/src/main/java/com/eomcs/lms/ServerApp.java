// 5단계: 클라이언트가 보낸 add, list, quit 명령을 받아 처리한다..
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  public static void main(String[] args) {

    ArrayList<Member> members= new ArrayList<>();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          System.out.println("클라이언트와 연결되었음.");

          loop: while(true) {
            String request = in.readUTF();
            System.out.println(request);

            switch (request) {
              case "/board/add" :
                members.add((Member)in.readObject());
                break;
              case "/board/list" :
                out.writeObject(members);
                break;
              case "/board/detail" :
                break;
              case "/board/update" :
                break;
              case "/board/delete" :
                int no = in.readInt();

                int index = 0;
                for(Member m : members) {
                  if(no == m.getNo()) {
                    members.remove(index);
                    out.writeUTF("OK");
                    out.flush();
                    break loop;
                  }
                  index ++;
                }
                out.writeUTF("FAIL");
                break;
              case "quit" :   
                out.writeUTF("안녕!");
                out.flush();
                break loop;
              default :
                out.writeUTF("존재하지않는 명령어 입니다.");
                break;
            }
            out.flush();
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
