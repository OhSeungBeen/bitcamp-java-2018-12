package algorithm.data_structure.linkedlist;

// Linkedlist 에서 데이터를 담는 그릇이다.
// 
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
