// 4단계: 서버 실행 테스트
package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;

public class ServerTest {
  static ObjectOutputStream out= null;
  static ObjectInputStream in = null;
  public static void main(String[] args) {
    
    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      System.out.println("서버와 연결되었음.");
      
      ServerTest.out = out;
      ServerTest.in = in;
      
      add(new Member(1, "홍길동"));
      add(new Member(2, "임꺽정"));
      
      delete(1);
      
      list();
      
      out.writeUTF("okok");
      out.flush();
      System.out.println(in.readUTF());
      
      quit();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }
  private static void delete(int no) throws IOException {
    out.writeUTF("/board/delete");
    out.writeInt(no);
    out.flush();
    if(in.readUTF().equals("OK")) {
      System.out.println("게시판 삭제 되었습니다!");
    }else
      System.out.println("게시판 삭제 실패!");
  }
  
  private static void update(Member member) throws IOException {
    out.writeUTF("/board/update");
    out.flush();
  }
  
  private static void detail(int no) throws IOException {
    out.writeUTF("/board/detail");
    out.flush();
  }
  private static void add(Member member) throws IOException {
    out.writeUTF("/board/add");
    out.writeObject(member);
    out.flush();
  }
  
  @SuppressWarnings("unchecked")
  private static void list() throws IOException, ClassNotFoundException {
    out.writeUTF("/board/list");
    out.flush();
    ArrayList<Member> members = (ArrayList<Member>) in.readObject();
    for(Member m : members) {
      System.out.println(m);
    }
    
  }
  
  private static void quit() throws IOException {
    out.writeUTF("quit");
    out.flush();
    System.out.println(in.readUTF());
  }
  
}
