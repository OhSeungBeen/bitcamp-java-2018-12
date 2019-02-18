// 14단계: DAO에 프록시 패턴 적용하기
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDaoImple;
import com.eomcs.lms.dao.LessonDaoImple;
import com.eomcs.lms.dao.MemberDaoImple;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

// DAO 프록시 패턴 적용
// => 클라이언트에서 서버쪽에 DAO를 마치 직접 사용하는 것처럼 만들기
// => 작업
// 1) DAO 클래스에서 인터페이스를 추출하여 정의한다.
//     => 예) BoardDao 인터페이스 정의
// 2) 기존 클래스를 인터페이스를 구현하도록 변경한다.
//     => 예) BoardDaoImpl 클래스로 변경
// 3) BoardDaoImpl 객체를 서버쪽에서 대행할 클래스를 만든다.
//     => 예) BoardService의 이름을 BoardSkel로 변경한다.
// 4) 클라이언트쪽 BoardDaoImpl 객체를 대행할 프록시 클래스를 만든다.
//    => 예) BoardAgent 클래스를 BoardDaoProxy클래스로 변경한다.
//        BoardDaoProxy 클래스는 BoardDaoImple 클래스와 마찬가지로 BoardDao 인터페이스를 구현한다.
//          패키지명도 agent 대신 proxy로 변경한다.
public class ServerApp {

  static BoardDaoImple boardDao; 
  static MemberDaoImple memberDao;
  static LessonDaoImple lessonDao;

  static HashMap<String,Service> serviceMap;
  static Set<String> serviceKeySet;

  public static void main(String[] args) {

    try {
      boardDao = new BoardDaoImple("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDaoImple("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("회원 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDaoImple("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("수업 데이터 로딩 중 오류 발생!");
    }

    serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardDaoSkel(boardDao));
    serviceMap.put("/member/", new MemberDaoSkel(memberDao));
    serviceMap.put("/lesson/", new LessonDaoSkel(lessonDao));

    serviceKeySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      while (true) {
        new RequestProcessorThread(serverSocket.accept()).start();
      }

    }catch (Exception e) {
      e.printStackTrace();
    }
  }


  static class RequestProcessorThread extends Thread{

    Socket socket;

    public RequestProcessorThread(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      try (Socket socket = this.socket;
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

        System.out.println("클라이언트와 연결되었음.");

        String request = in.readUTF();
        System.out.println(request);


        Service service = getService(request);

        if(service == null) {
          out.writeUTF("FAIL");
        } else {
          service.execute(request, in, out);
        }
        out.flush();

        System.out.println("클라이언트와의 연결을 끊었음.");
      }catch (Exception e) {
        e.printStackTrace();
      }

    }
  }


  static Service getService(String request) {

    for (String key : serviceKeySet) {
      if (request.startsWith(key)) {
        return serviceMap.get(key);
      }
    }
    return null;
  }
}









