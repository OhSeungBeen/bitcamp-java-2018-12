package algorithm.data_structure.stack;

public class Node {
  public Object value;
  public Node pre;
  public Node next;
  
  public Node() {
    
  }
  
  public Node(Object value) {
    this.value = value;
  }
  
  public Node(Object value, Node pre, Node next) {
    this(value);
    this.pre = pre;
    this.next = next;
  }
}
