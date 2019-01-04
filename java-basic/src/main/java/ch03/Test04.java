// l-value와 r-value 용어
package ch03;

public class Test04 {

  public static void main(String[] args) {
    int a = 100;
    int b = a;
    System.out.printf("%d, %d\n",a,b);
    
    a = 200;
    System.out.printf("%d",a);
    
    //100 = 20; //컴파일 오류. l-value 는 반드시 메모리여야 한다.
    //100 = a; // 컴파일 오류.
    
    a =300; // OK. r-value는 리터럴일 수 있다.
    a = b; //OK. R-value는
  }

}
