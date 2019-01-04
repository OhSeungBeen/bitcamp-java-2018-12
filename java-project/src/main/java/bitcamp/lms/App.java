package bitcamp.lms;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
      int num;
      String name;
      String subject;
      String start;
      String finish;
      int time;
      int hour;
      
      Scanner sc = new Scanner(System.in);
       System.out.print("번호? ");
       num = sc.nextInt();
       System.out.print("수업? ");
       sc.nextLine();
       name = sc.nextLine();
       System.out.print("수업내용? ");
       subject = sc.nextLine();
       System.out.print("시작일? ");
       start = sc.nextLine();
       System.out.print("종료일? ");
       finish = sc.nextLine();
       System.out.print("총수업시간? ");
       time = sc.nextInt();
       System.out.print("일수업시간? ");
       hour = sc.nextInt();
       
       System.out.println("번호: "+num);
       System.out.println("수업명: "+name);
       System.out.println("수업내용: "+subject);
       System.out.println("시작일: "+start);
       System.out.println("종료일: "+finish);
       System.out.println("총수업시간: "+time);
       System.out.println("일수업시간: "+hour);
       
       
    }
}
