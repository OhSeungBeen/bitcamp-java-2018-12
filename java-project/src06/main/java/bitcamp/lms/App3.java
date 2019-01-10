package bitcamp.lms;

import java.util.Date;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      Date date = new Date();
      Scanner sc = new Scanner(System.in);
      int num;
      String str;
      
      System.out.print("번호? ");
      num =sc.nextInt();
      System.out.print("내용? ");
      str =sc.next();
      sc.close();
      System.out.println("번호: "+num);
      System.out.println("내용: "+str);
      System.out.printf("가입일: %1$tY-%1$tm-%1$td\n", date);
      System.out.print("조회수: 0");
    }
}
