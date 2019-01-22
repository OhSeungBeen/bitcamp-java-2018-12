package algorithm.data_structure.array;

public class ArrayList {
  static final int DEFAULT_SIZE = 5;
  Object[] arr;
  int size=0;
  public ArrayList() {
    this(0);
  }

  public ArrayList(int capacity) { 
    if(capacity >DEFAULT_SIZE)
      arr = new Object[capacity];
    else
      arr = new Object[DEFAULT_SIZE];
  }

  public Object[] toArray() {
    if(size==0)
      return null;
    else {
      Object[] obj = new Object[size];
      for(int i = 0; i < size; i++) {
        obj[i] = arr[i];
      }
      return obj;
    }
  }

  public void add(Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    if(size == arr.length) 
      increase();
    arr[size++] = value;

  }

  public int insert(int index, Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    // 유효 인덱스가 아니면 저장하지 말라.
    // 삽입할 위치의 항목부터 이후의 항목을 뒤로 밀어라.
    if(size == arr.length) 
      increase();

    if(index < 0 || index >= size)
      return -1;

    for(int i = size -1; i >= index; i--) {
      arr[i+1] = arr[i];
    }
    arr[index] =value;
    size++;

    return 0;
  }

  public Object get(int index) {
    // 유효 인덱스가 아니면 null을 리턴하라.
    if(index < 0 || index >= size)
      return null;
    else
      return arr[index];
  }

  public Object set(int index, Object value) {
    // 유효 인덱스가 아니면 변경하지 말라. 리턴 값은 null이다.
    if(index < 0 || index >= size)
      return null;

    Object obj = arr[index];
    arr[index] = value;
    return obj;
  }

  public Object remove(int index) {
    // 유효 인덱스가 아니면 삭제하지 말라.
    // 삭제한 후 다음 항목을 앞으로 당긴다.
    if(index < 0 || index >= size)
      return null;

    Object obj = arr[index];
    for(int i = index; i < size - 1; i++) 
      arr[i] = arr[i+1];
    
    size--;
    return obj;
  }


  public int getSize() {
    return this.size;
  }

  private void increase() {

    Object[] obj = new Object[size + (size >> 1)];
    for(int i = 0; i < arr.length; i++) {// 유효 인덱스가 아니면 삭제하지 말라.
      // 삭제한 후 다음 항목을 앞으로 당긴다.
      obj[i] = arr[i];
    }
    arr = obj;
  }



}

