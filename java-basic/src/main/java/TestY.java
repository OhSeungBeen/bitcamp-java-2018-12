
public class TestY {
  public static void main(String[] args) {
    int count = 0;

    for(int i = 1; i < 110; i++) {
      if(i % 4 == 0) 
        count ++;
    }
    System.out.println(count);
  }
}
