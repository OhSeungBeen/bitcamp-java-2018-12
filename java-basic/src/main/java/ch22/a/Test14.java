// java.io.File 클래스 : 연습 과제 - bin/main 폴더를 뒤져서 모든 클래스 파일의 이름을 출력하라.
package ch22.a;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Test14 {
  static class ClassFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
      if (pathname.isDirectory() || pathname.isFile() && pathname.getName().endsWith(".class"))
        return true;
      else
        return false;
    }
  }
  public static void main(String[] args) throws IOException {
    // 클래스 이름을 출력할 때 패키지 이름을 포함해야 한다.
    // 예 ) ch01.Test01

    File dir = new File("bin/main");
    findClass(dir,"");
    System.out.println("실행완료!");
  }

  static void findClass(File dir , String name) {
    File[] files =dir.listFiles(new ClassFileFilter());
    for(int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
          System.out.print(name);
          System.out.println(files[i].getName().replace(".class",""));
      }
      else {
        findClass(files[i], name+files[i].getName()+".");
      }
    }
  }


}
