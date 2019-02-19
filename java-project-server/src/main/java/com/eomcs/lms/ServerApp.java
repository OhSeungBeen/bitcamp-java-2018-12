// 15단계: 여러 클라이언트 요청을 처리할 때의 문제점과 해결책(멀티 스레드 적용)
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

// 멀티 스레드 적용
// => 클라이언트 요청을 별도의 스레드에서 처리한다.
// => 작업 
// 1) 클라이언트의 요청 작업을 처리하는 코드를 별도의 스레드 클래스로 분리한다.
//    => 예) RequestProcessorThread 클래스 정의
// 2) 클라이언트가 연결되었을 때 스레드에게 실행을 위임한다.
// 
//
public class ServerApp {

  static BoardDaoImpl boardDao; 
  static MemberDaoImpl memberDao;
  static LessonDaoImpl lessonDao;

  static HashMap<String,Service> serviceMap;
  static Set<String> serviceKeySet;

  //스레드 풀
  static ExecutorService executorService = Executors.newCachedThreadPool();

  public static void main(String[] args) {

    try {
      boardDao = new BoardDaoImpl("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDaoImpl("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("회원 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDaoImpl("lesson.bin");
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

        // 독립적으로 실행 해야할 일을 스레드 풀에 맡긴다.
        executorService.submit(new RequestHandler(serverSocket.accept()));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static class RequestHandler implements Runnable {

    static int count;
    String name;

    Socket socket;
    public RequestHandler(Socket socket) {
      this.socket = socket;
      this.name = "핸들러 -"+ count++;

      System.out.printf("[%s : %s] 핸들가 생성됨\n",
          Thread.currentThread().getName(), this.getName());
    }

    public String getName() {
      return this.name;
    }

    @Override
    public void run() {
      try (Socket socket = this.socket;
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

        System.out.printf("[%s : %s] 클라이언트와 연결되었음.\n",Thread.currentThread().getName(),this.getName());

        String request = in.readUTF();
        System.out.printf("[%s : %s] %s\n",Thread.currentThread().getName(),this.getName(), request);

        Service service = getService(request);

        if (service == null) {
          out.writeUTF("FAIL");

        } else {
          service.execute(request, in, out);
        }
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();
      }
      try { Thread.currentThread().sleep(8000);} catch (InterruptedException e) {}


      System.out.printf("[%s : %s] 클라이언트와의 연결을 끊었음.\n",Thread.currentThread().getName(), this.getName());
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
}














