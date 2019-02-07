package ch22.f;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2_2 {

  public static void main(String[] args) {
    try(ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("Score2.data"))){
      Score2 score = (Score2) in.readObject();
      score.compute();
      System.out.println(score);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }


  }

}
