package ch21.f;

public class Test03 {
  static class MyResorce1 {

    public void close() {
      System.out.println("MyResource1.close()");
    }
  }

  static class MyResorce2 implements AutoCloseable{ 
    public int divide(int a, int b) {
      return a / b;
    }
    @Override
    public void close() {
      System.out.println("MyResource2.close()");
    }
  }

  public static void main(String[] args) {
    // java.lang.AutoCloseable 을 구현하지 않은 객체는 선언할 수 없다.
    try(
        //String = "Hello"; 컴파일오류!
        //MyResource1 r1 = new MyResource1();  컴파일 오류!
        MyResorce2 r2 = new MyResorce2();
        ){
      System.out.println(r2.divide(10, 2));
      System.out.println(r2.divide(10, 0));
      
      // try 블록을 벗어나기 전에 close()가 자동 호출된다.
    }catch (Exception e) {
      System.out.println("예외 발생!");
    }


  }
}
