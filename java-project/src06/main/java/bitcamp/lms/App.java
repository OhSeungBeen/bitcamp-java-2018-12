package bitcamp.lms;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int [] num = new int[100];
      String [] className = new String[100];
      String [] classSubject = new String[100];
      String [] startDate = new String[100];
      String [] finishDate = new String[100];
      int [] totalTime = new int[100];
      int [] dayTime = new int[100];
      int i=0;
      int j=0;
      
      while (i <=99) {
        System.out.print("번호? ");
        num[i] = sc.nextInt();
        System.out.print("수업명? ");
        sc.nextLine();
        className[i] = sc.nextLine();
        System.out.print("수업내용? ");
        classSubject[i] = sc.nextLine();
        System.out.print("시작일? ");
        startDate[i] = sc.nextLine();
        System.out.print("종류일? ");
        finishDate[i] = sc.nextLine();
        System.out.print("총수업시간? ");
        totalTime[i] = sc.nextInt();
        System.out.print("일수업시간? ");
        dayTime[i] = sc.nextInt();
        i++;
        System.out.print("계속 입력하시겠습니까?(Y/n)");
        String str = sc.next();
        if (!str.equalsIgnoreCase("y"))
          break;
          
        }
        
      while(j < i) {
        System.out.println(className[j]+", "+
        startDate[j]+" ~ "+ finishDate[j] +", "+totalTime[j]);
        j++;
      }
      
      
      
      
      
    }
}
