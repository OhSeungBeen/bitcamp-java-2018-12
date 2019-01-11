package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.domain.Lesson;

public class LessonHandler {
  
  final static int LENGTH = 10;
  public static Scanner keyboard;
  static Lesson[] lessons = new Lesson[LENGTH];
  static int lessonIdx = 0;
  
  public static void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.contents = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    lesson.totalHours = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    lesson.dayHours = Integer.parseInt(keyboard.nextLine());

    lessons[lessonIdx] = lesson;
    lessonIdx++;

    System.out.println("저장하였습니다.");
  }

  public static void listLesson() {
    for (int j = 0; j < lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].no, lessons[j].title, lessons[j].startDate, 
          lessons[j].endDate, lessons[j].totalHours);
      
    }
  }
}
