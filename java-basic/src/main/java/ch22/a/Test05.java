// java.io.File 클래스 : 디렉토리 생성
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test05 {

  public static void main(String[] args) throws IOException {
    
    File dir = new File("temp");
    if (dir.delete()) {
      System.out.println("디렉토리 삭제됨.");
    }else {
      System.out.println("디렉토리 삭제 못함.");
    }
    
    // 디렉토리 안에 하위 디렉토리나 파일이 있다면 삭제할 수 없다.
    dir = new File("temp2");
    if (dir.delete()) {
      System.out.println("디렉토리 삭제됨.");
    }else {
      System.out.println("디렉토리 삭제 못함.");
    }
    
    
  }
}
