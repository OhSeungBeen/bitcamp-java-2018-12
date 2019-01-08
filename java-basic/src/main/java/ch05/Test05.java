// 흐름제어문 - switch
package ch05;
public class Test05 {

  public static void main(String[] args) {
    String str = "no";
    
    switch (str) {
      case "ok":
        System.out.println("ok");
        break;
      case "no":
        System.out.println("no");
        break;
      default:
          System.out.println("????");
    }
  }
}
