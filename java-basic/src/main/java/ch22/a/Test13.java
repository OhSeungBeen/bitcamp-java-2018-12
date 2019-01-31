// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test13 {

  public static void main(String[] args) throws IOException {
    // bin의 하위 폴더와 파일을 모두 삭제해야만 bin 폴더를 삭제할 수 있다.

    File dir = new File("bin");
    delete(dir);
    System.out.println("실행완료!");
  }

  static void delete(File dir) {
    File[] files =dir.listFiles();
    for(int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        files[i].delete();        
      }
      else {
        delete(files[i]);
      }
    }
    dir.delete();
  }
 
  
}
