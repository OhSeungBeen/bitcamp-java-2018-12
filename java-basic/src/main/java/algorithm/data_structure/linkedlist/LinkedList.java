package algorithm.data_structure.linkedlist;

public class LinkedList {
  protected Node head;
  protected Node tail;
  protected int size;
  
  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }
  
  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
  // ArrayList 처럼 한 번에 큰 메모리를 준비할 필요가 없다.
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다.
  public void add(Object value) {
    tail.value = value;
    
    // 새 노드를 준비한다.
    Node node = new Node();
    
    // 마지막 노드의 다음으로 새노드를 가리키게 한다.
    tail.next = node;
    
    // 새 노드의 이전으로 마지막 노드를 가리키게 한다.
    node.pre = tail;
    
    // tail이 새로 추가된 노드를 가리키게 한다.
    tail = node;
    
    // 항목 개수를 증가시킨다.
    size++;
  }
  
  public int getSize() {
    return size;
  }
  
  //ArrayList와 달리 해당 인덱스를 찾아 가려면 링크를 따라가야 하기 때문에
  // 조회 속도가 느리다.
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = head;
    
    // 해당 인덱스로 이동한다.
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    //cursor가 가리키는 노드를 주소를 리턴?
    // => 노드의 값을 리턴
    return cursor.value;
  }
  
  public Object[] toArray() {
    Object arr[] = new Object[getSize()];
    
    Node cursor = head;
    int i = 0;
    while (cursor != tail) {
      arr[i++] =cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = head;
    
    // 교체할 값이 들어 있는 노드로 이동한다.
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    // 변경 전에 이전 값을 보관한다.
    Object old = cursor.value;
    
    // 값을 변경한다.
    cursor.value = value;
    
    // 이전 값을 리턴한다. 쓰든 안쓰든 호출하는 사람이 알아서 할 일이다.
    // 다만 변경 전 값을 활용할 경우에 대비해 
    return old;
  }
  
  // 값을 삽입하는 경우에는 AraayList 방식 보다 효율적이다.
  // 삽입 위치에 있는 노드를 찾은 후에 새 노드를 앞 ,뒤 노드에 연결하면 된다.
  public int insert(int index, Object value) {
    if (index < 0 || index >= size)
      return -1;
    
    // 새 노드를 만드어 값을 담는다.
    Node node = new Node(value);
    
    //
    Node cursor = head; 
    for(int i = 1; i <=index; i++) {
      cursor = cursor.next;
    }
    node.next = cursor;
    
    node.pre = cursor.pre;
    
    cursor.pre = node;
   
    if(node.pre !=null) {
    node.pre.next = node;
   } else {
     head = node;
   }
    
    // 크기를 늘린니다.
    size ++;
    return 0;  
  }
  
  public Object remove(int index) {
    if (index <0 || index >= size)
      return null;
    // index 위치에 있는 노드를 찾는다.
    Node cursor = head;
    for (int i =1; i<= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    
    // 찾은 노드의 이전 노드가 다음 노드를 가리키게 한다.
    if(cursor.pre != null) {
      cursor.pre.next = cursor.next;
    } else {
      head = cursor.next;
    }
    
    // 찾은 노드의 다음 노드가 이전 노드를 가리키게 한다.
    cursor.next.pre = cursor.pre;
    
    // JVM이 가비지를 효과적으로 계산할 수 있도록
    // 가비지가 된 객체는 다른 객체를 가리키지 않도록 한다.
    cursor.value = null;
    cursor.next = null;
    cursor.pre = null;
    size --;
    return old;
  }
  
  
}
