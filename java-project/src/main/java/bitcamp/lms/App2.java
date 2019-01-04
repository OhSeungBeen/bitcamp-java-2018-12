package bitcamp.lms;

import java.util.Date;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
      Date date = new Date();
      int num;
      String name;
      String email;
      int pw;
      String picture;
      String hp;
      
      Scanner sc = new Scanner(System.in);
       System.out.print("번호? ");
       num = sc.nextInt();
       System.out.print("이름? ");
       sc.nextLine();
       name = sc.nextLine();
       System.out.print("암호? ");
       pw = sc.nextInt();
       System.out.print("사진? ");
       sc.nextLine();
       picture = sc.nextLine();
       System.out.print("전화? ");
       hp = sc.nextLine();
       
       System.out.println("번호: "+num);
       System.out.println("이름: "+name);
       System.out.println("암호: "+pw);
       System.out.println("사진: "+picture);
       System.out.println("전화: "+hp);
       System.out.printf("가입일: %1$tY-%1$tm-%1$td", date);
    }
}
