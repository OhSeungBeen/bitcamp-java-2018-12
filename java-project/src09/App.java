package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Lesson[] les = new Lesson[100];
    int indexCount = 0;
    String command;

    while(true) {

      System.out.print("명령 >");
      command = sc.nextLine();
      if(command.equals("lesson/add")) {
        for(int i = 0; i < les.length; i++) {
          les[i] = new Lesson();

          System.out.print("번호? ");
          les[i].no = Integer.parseInt(sc.nextLine());  
          System.out.print("수업명? ");
          les[i].title = sc.nextLine(); 
          System.out.print("설명? ");
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
      } else if(command.equals("lesson/list")) {
        for(int i = 0; i < indexCount; i++) {
          System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
              les[i].no, les[i].title, les[i].startDate, 
              les[i].endDate, les[i].totalHours);
        }
      } else if(command.equalsIgnoreCase("quit")) {
        System.out.println("안녕");
        break;
      } else
        System.out.println("실행할 수 없는 명령입니다.");

    }
    

  }
}
