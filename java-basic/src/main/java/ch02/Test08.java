// 문자 리터럴
package ch02;

public class Test08 {
  public static void main(String[] args){
    System.out.println(true);
    System.out.println(false);
    
    //System.out.println((boolean)1); 자바는 정수값을 ture/false로 형변환할 수 없다.
    
    if('가'==0xac00) {
      System.out.println("맞다!");
    }else {
        System.out.println("아니다!");
      }
    /*
    if(10-10) {
      
    }
    */
  }
 }

