package ch13;

public class Score {
  
  private String name;
  private int kor;
  private int eng;
  private int math;
  
  
  // 서브 클래스에서 사용할 필드는 protected로 접근을 풀어 준다.
  // => 접근 범위를 넓히는 것은 기존 코드에 영향을 미치지 않는다.
  // => 접근 범위를 좁히게 되면 기존 코드에서 직접 접근하던 코드가 동작이 안될 수 있다.
  //    접근 범위를 좁히게 되면 기존 코드에 영향을 준다.
  protected int sum;
  protected float aver;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getKor() {
    return this.kor;
  }
  
  public void setKor(int kor) {
    if (kor >=0 && kor <= 100) {  //
      this.kor = kor;
      this.compute(); 
    }
  }
  
  public int getEng() {
    return this.eng;
  }
  
  public void setEng(int eng) {  
    if (eng >=0 && eng <= 100) {
      this.eng = eng;
      this.compute();
    }
  }
  
  public int getMath() {
    return this.math;
  }
  
  public void setMath(int math) {
    if (math >=0 && math <= 100) { // 유효한 점수인 경우에만 저장한다. 
      this.math = math;
      this.compute();
    }
  }
  
  
  // 대신 결과 값을 꺼낼 수 있는 메서드를(getter) 제공해야 한다.
  public int getSum() {
    return this.sum;
  }
  
  public float getAver() {
    return this.aver;
  }

  // 서브 클래스에서 사용할 수 있도록 범위를 넓힌다.
  protected void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
