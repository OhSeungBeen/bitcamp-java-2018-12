package ch18.e;

public class MultiPen extends Zebra implements Pen  {
  @Override
  public void write(String text) {
    if (!this.use ==true)
      return;
    System.out.println("제브라>>" + text);
  }
}
