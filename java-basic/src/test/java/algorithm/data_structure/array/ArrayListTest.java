package algorithm.data_structure.array;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ArrayListTest {
  
  @Test
  public void testAdd() {
    ArrayList list = new ArrayList(6);
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);

    assertEquals(6, list.getSize());
  }
  
  @Test // 테스트를 수행할 때 이 메서드를 호출하라는 의미이다
  public void testList() {
    ArrayList list = new ArrayList(6);
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertArrayEquals(new Object[] {100,200,300,400,500,600},list.toArray());
  }
  
  @Test // 테스트를 수행할 때 이 메서드를 호출하라는 의미이다
  public void testInsert() {
    ArrayList list = new ArrayList(6);
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.insert(2,55);
    
    assertArrayEquals(new Object[] {100,200,55,300,400,500,600},list.toArray());
  }
  
 
  
  @Test
  public void testGet() {
    ArrayList list = new ArrayList(6);
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.set(2, 55));
    assertEquals(55, list.get(2));
  }
  
  @Test
  public void testRemove() {
    ArrayList list = new ArrayList(6);
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    
    assertEquals(300, list.remove(2));
    assertEquals(4, list.getSize());
    assertArrayEquals(new Object[] {100,200,400,500} , list.toArray());
    
    assertEquals(500, list.remove(3));
    assertEquals(3, list.getSize());
    assertArrayEquals(new Object[] {100,200,400}, list.toArray());
  }
}
