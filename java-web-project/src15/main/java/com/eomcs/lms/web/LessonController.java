package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Controller
@RequestMapping("/lesson")
public class LessonController {
  
  @Autowired LessonService lessonService;

  @GetMapping("form")
  public void form() {
  }
  
  @PostMapping("add")
  public String add(Lesson lesson) throws Exception {
    lessonService.add(lesson);
    return "redirect:.";
  }
  
  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {

    if (lessonService.delete(no) == 0) 
      throw new Exception("해당 번호의 수업이 없습니다.");
      
    return "redirect:../";
  }
  
  @GetMapping("{no}")
  public String detail(
      @PathVariable int no,
      Map<String,Object> map) throws Exception {

    Lesson lesson = lessonService.get(no);
    map.put("lesson", lesson);
    
    return "lesson/detail";
  }

  @GetMapping
  public String list(Map<String,Object> map) throws Exception {
    List<Lesson> lessons = lessonService.list();
    map.put("list", lessons);
    
    return "lesson/list";
  }
  
  @PostMapping("update")
  public String update(Lesson lesson) throws Exception {
    if (lessonService.update(lesson) == 0)
      throw new Exception("해당 번호의 수업이 없습니다.");
    
    return "redirect:.";
  }
}
