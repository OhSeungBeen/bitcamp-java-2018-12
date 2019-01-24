// 특정 클래스에 의해서만 사용되는 클래스가 있다면 그 클래스 안에 정의하라!
package ch19.f;

// Array 클래스는 LinkedList 클래스에서만 사용하는 클래스다.
// 그래서 패키지 멤버 클래스에서 중첩 클래스로 옮겼다.
// 즉 LinkedList 클래스 안에 Array 클래스를 정의하였다.
// 맨 아래에 Array 클래스를 확인하라!
public class LinkedList {
  public static final int FORWARD = 1;
  public static final int REVERSE = 0;
  protected Node head;
  protected Node tail;
  protected int size;

  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }

  public void add(Object value) {
    tail.value = value;

    Node node = new Node();

    tail.next = node;

    node.pre = tail;

    tail = node;

    size++;
  }

  public int getSize() {
    return size;
  }

  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node cursor = head;

    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }
  /*
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
   */
  public Object[] toArray(int direction) {
    // Array 클래스는 LinkedList 인스턴스에 들어 있는 값을 사용하여,
    // 배열을 만들어 주는 도우미 클래스이다.

    // Array의 도움을 받으려면 다음과 같이 항상 Array 객체에게 LinkedList 객체를 넘겨야 한다.
    Array helper = new Array(this); // <== LinkedList 객체 주소를 넘긴다.

    if (direction == FORWARD) {
      // 그래야만 Array 객체는 생성자에서 넘겨 받은 LinkedList의 데이터를 꺼내
      // 배열로 만든다.
      return helper.copy();
    }else {
      return helper.reverseCopy();
    }

  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
      return null;

    Node cursor = head;

    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    Object old = cursor.value;

    cursor.value = value;

    return old;
  }

  public int insert(int index, Object value) {
    if (index < 0 || index >= size)
      return -1;

    Node node = new Node(value);

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

    size ++;
    return 0;  
  }

  public Object remove(int index) {
    if (index <0 || index >= size)
      return null;
    Node cursor = head;
    for (int i =1; i<= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;

    if(cursor.pre != null) {
      cursor.pre.next = cursor.next;
    } else {
      head = cursor.next;
    }

    cursor.next.pre = cursor.pre;

    cursor.value = null;
    cursor.next = null;
    cursor.pre = null;
    size --;
    return old;
  }

  // 중첩 클래스는 크게 static이냐 non-static이냐로 나눌 수 있는데,
  // 바깥 클래스의 특정 인스턴스를 사용하지 않는다면 static nested class로 선언하라!
  // 그러나 바깥 클래스의 특정 인스턴스를 사용한다면 그인스턴스에 종속되기 때문에
  // non-static nested class로 선언하라!
  // => 다음 Array 클래스는 
  public class Array {
    LinkedList list;

    public Array(LinkedList list) {
      this.list = list;
    }

    // 입력된 순서대로 배열을 만든다.
    public Object[] copy() {
      Object[] arr = new Object[list.getSize()];
      for (int i = 0; i <list.getSize(); i++) {
        arr[i] = list.get(i);
      }
      return arr;
    }

    // 입력된 순서의 반대로 배열을 만든다.
    public Object[] reverseCopy() {
      Object[] arr = new Object[list.getSize()];
      for (int i = list.getSize() -1, j = 0; i >=0; i--, j++) {
        arr[j] = list.get(i);
      }
      return arr;
    }

  }

}