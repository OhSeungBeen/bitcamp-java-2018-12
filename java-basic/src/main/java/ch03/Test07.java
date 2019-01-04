// 키보드로 입력한 값을 받기
package ch03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test07 {

  public static void main(String[] args) throws IOException {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    //사용자에게 입력하라고 간단히 출력하자.
    System.out.println("이름을 입력하세요.");
    java.lang.String name = keyboard.nextLine();
    
    System.out.println("나이를 입력하세요.");
    java.lang.String age = keyboard.nextLine();
    
    System.out.printf("%s(%s)\n", name,age);
    
  }

}
