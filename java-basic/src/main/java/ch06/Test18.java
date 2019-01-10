// JVM 아규먼트 응용 II
package ch06;

import java.util.Properties;
import java.util.Set;

public class Test18 {

  public static void main(String[] args) {
    // JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력하라!
    //
    
    Properties props = System.getProperties();
    
    Set keySet = props.keySet();
    
    for(Object key : keySet) {
      String value = System.getProperty((String)key);
      System.out.printf("%s=%s\n", key, value);
    }
  }
}










