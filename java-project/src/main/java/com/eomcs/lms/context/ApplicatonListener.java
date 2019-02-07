package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicatonListener {
  
  void startApplication(Map<String,Object> context);
  void endApplication(Map<String,Object> context);
  
}
