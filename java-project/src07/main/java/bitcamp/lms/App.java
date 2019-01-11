package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    Lesson[] les = new Lesson[100];
    int indexCount = 0;
    for(int i = 0; i < les.length; i++) {
      les[i] = new Lesson();
      
      System.out.print("번호? ");
      les[i].no = Integer.parseInt(sc.nextLine());  
      System.out.print("수업명? ");
      les[i].contents = sc.nextLine(); 
      System.out.print("시작일? ");
      les[i].startDate = Date.valueOf(sc.nextLine());
      System.out.print("종료일? ");
      les[i].endDate = Date.valueOf(sc.nextLine());
      System.out.print("총수업시간? ");
      les[i].totalHours = Integer.parseInt(sc.nextLine());
      System.out.print("일수업시간? ");
      les[i].dayHours = Integer.parseInt(sc.nextLine());
      
      indexCount ++;
      
      System.out.print("계속 입력 하시겠습니까?(Y/n)");
      String key = sc.nextLine();
      System.out.println();
      if(!key.equalsIgnoreCase("y") && !key.equals(""))
        break;
    }
    
    for(int i = 0; i < indexCount; i++) {
      
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          les[i].no, les[i].title, les[i].startDate, 
          les[i].endDate, les[i].totalHours);
    }
    
    
  }
}
