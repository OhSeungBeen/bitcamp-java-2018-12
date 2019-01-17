package com.eomcs.lms.handler;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int MIN_VALUE = 3;
  Lesson[] list;
  int size = 0;
  
  public LessonList() {
    list = new Lesson[MIN_VALUE];
  }

  public LessonList(int initValue) {
    if (initValue <= 10)
      list = new Lesson[10];
    else
      list = new Lesson[initValue];
  }

  public Lesson[] toArray() {
    Lesson[] lessons = new Lesson[size];
    for(int i = 0; i < size; i++) {
      lessons[i] = list[i];
    }
    list = lessons;
    return list;
  }
  
  public void add(Lesson lesson) {
    System.out.println(list.length);
    if(size >= this.list.length) {
      Lesson[] lessons = new Lesson[list.length + (list.length >> 1)];
      for(int i =0; i < list.length; i++) {
        lessons[i] = list[i];
      }
      list = lessons;
    }
    this.list[size++] = lesson;
  }
}
