package ch22.f;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test3_2 {

  public static void main(String[] args) {
    try(ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("Score3.data"))){
      Score3 score = (Score3) in.readObject();
      score.compute();
      System.out.println(score);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }


  }

}
