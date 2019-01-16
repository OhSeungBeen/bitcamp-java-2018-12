package com.eomcs.lms.handler;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  private Lesson[] lesson;
  int DEFAULT = 10;
  
  public LessonList() {
    lesson = new Lesson[DEFAULT];
  }
  
  public LessonList(int init ) {
    lesson = new Lesson[init];
  }
  
  public Lesson[] toArray() {
    return this.lesson;
  }
  
  public void Add(Lesson lesson) {
    
    for(int i = 0; i < this.lesson.length; i++ ) {
      if(this.lesson[i] == null) {
        this.lesson[i] = lesson;
        break;
      }
    }
    
  }
  
}
