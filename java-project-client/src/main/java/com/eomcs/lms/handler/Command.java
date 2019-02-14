package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Command {
  default void execute() {
    // 이 인터페이스를 새로 구현하는 클래스가 
    // 과거의 규칙을 따르지 않아도 되도록 
    // 기존 규칙도 default로 선언한다.
  }
  
}