package ch02;

public class Test02 {
      public static void main(String[] args){
        /*
        # 4바이트 정수 리터럴
        # 8바이트 정수 리터럴
        정수 뒤에 접미사 L또는 l을 붙인다.
        100L(주로사용)
        100l
        */
        
        // 20 억을 4바이트 리터럴로 출력하라.
        System.out.println(2000000000);
        // 20 억을 8바이트 리터럴로 출력하라.
        System.out.println(2000000000L);
        // 30 억을 8바이트 리터럴로 출력하라.
        System.out.println(3000000000L);
        // 30 억을 4바이트 리터럴로 출력하라.
        System.out.println(3000000000);  //컴파일에러
      }
}
  

  
    