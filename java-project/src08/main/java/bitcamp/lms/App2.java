package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    Member[] mem  = new Member[100];
    int indexCount = 0;
    for(int i = 0; i < mem.length; i++) {
      mem[i] = new Member();
      
      System.out.print("번호? ");
      mem[i].no = Integer.parseInt(sc.nextLine());  
      System.out.print("이름? ");
      mem[i].name = sc.nextLine(); 
      System.out.print("이메일? ");
      mem[i].email = sc.nextLine();
      System.out.print("암호? ");
      mem[i].password = sc.nextLine();
      System.out.print("사진? ");
      mem[i].photo = sc.nextLine();
      System.out.print("전화? ");
      mem[i].tel = sc.nextLine();
      
      indexCount ++;
      
      System.out.print("계속 입력 하시겠습니까?(Y/n)");
      String key = sc.nextLine();
      System.out.println();
      if(!key.equalsIgnoreCase("y") && !key.equals(""))
        break;
    }
    
    for(int i = 0; i < indexCount; i++) {
      
      System.out.printf("%3d, %-4s, %20s ~ %-15s, %s\n", 
          mem[i].no, mem[i].name, mem[i].password, 
          mem[i].photo, mem[i].tel);
    }
    
    
  }
}
