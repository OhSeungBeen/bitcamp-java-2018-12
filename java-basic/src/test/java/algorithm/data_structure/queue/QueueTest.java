package algorithm.data_structure.queue;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

  @Test
  public void testOffer() {
    Queue q = new Queue();
      q.offer(100);
      q.offer(200);
      q.offer(300);
      
      assertEquals(100, q.poll());
      assertEquals(2, q.getSize());
      assertEquals(200, q.poll());
      assertEquals(1, q.getSize());
      assertEquals(300, q.poll());
      assertEquals(0, q.getSize());
      assertEquals(null, q.poll());
    
  }

  @Test
  public void testPoll() {
    Queue q = new Queue();
    q.offer(100);
    q.offer(200);
    q.offer(300);
    
    assertEquals(100, q.poll());
    assertEquals(2, q.getSize());
    assertEquals(200, q.poll());
    assertEquals(1, q.getSize());
    assertEquals(300, q.poll());
    assertEquals(0, q.getSize());
    assertEquals(null, q.poll());
  }

  @Test
  public void testEmpty() {
    Queue q = new Queue();
    q.offer(100);
    q.offer(200);
    q.offer(300);
    
    assertEquals(100, q.poll());
    assertFalse(q.empty());
    
    assertEquals(200, q.poll());
    assertFalse(q.empty());
    
    assertEquals(300, q.poll());
    assertFalse(q.empty());
    
  }

}
