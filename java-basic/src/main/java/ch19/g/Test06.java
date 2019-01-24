//파일 필터 클래스를 익명 클래스로 만든다. 그자리에!
package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test06 {

  public static void main(String[] args) {
    
    File dir = new File("./"); 
    //list()를 호출할 때 필터 객체를 딱 한번만 만들어 사용할 것이기 때문에
    // 굳이 로컬 클래스로 단정하게 정의할 필요가 없다.
    // 익명 클래스를 사용하자 !
    
    String[] names = dir.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt"))
          return true;
        else
          return false;
      }
    });
    // 조금 더 가까이!
    // list()를 호출하는 코드를 보는 즉시 무엇을 필터링하는지 알 수 있다면
    //   소스 코드를 더 잘 읽을 수 있을 텐데 ...
    for (String name : names) {
      System.out.println(name);
    }
  }
}
