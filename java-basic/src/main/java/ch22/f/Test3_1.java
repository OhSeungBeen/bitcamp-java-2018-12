package ch22.f;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test3_1 {

  public static void main(String[] args) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("Score3.data"))){

      out.writeObject(new Score3("홍길동", 100, 100, 100));
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }

}
