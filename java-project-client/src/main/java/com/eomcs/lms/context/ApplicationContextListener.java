package com.eomcs.lms.context;

import java.util.HashMap;

public interface ApplicationContextListener {
  
  void contextinitialized(HashMap<String,Object> context);
  void contextDestroyed();
}
