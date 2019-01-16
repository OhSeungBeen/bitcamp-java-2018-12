package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  public Scanner keyboard;  
  int lessonIdx = 0;
  LessonList lessonlist = new LessonList();
  
  public LessonHandler(Scanner keyboard){
    this.keyboard = keyboard;
  }
  
  public void listLesson() {
    Lesson[] lesson = this.lessonlist.toArray();
    
    for (int j = 0; j < lesson.length; j++) {
      if(lesson[j] == null)
        break;
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson[j].getNo(), lesson[j].getTitle(),lesson[j].getStartDate(), 
          lesson[j].getEndDate(), lesson[j].getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(this.keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(this.keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(this.keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(this.keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(this.keyboard.nextLine()));

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    lessonlist.Add(lesson);

    System.out.println("저장하였습니다.");
  }
}
