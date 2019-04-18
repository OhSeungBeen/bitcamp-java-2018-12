// 페이지 컨트롤러 만드는 방법 - 기본 URL과 상세 URL을 설정하는 방법
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 이 애노테이션을 붙인다.
@RequestMapping("/c01_3")
public class Controller01_3 {
  
  @RequestMapping("h1") // 기본 URL에 뒤에 붙는 URL. 예) /c01_3/h1
  @ResponseBody
  public String handler() {
    return "h1";
  }
  
  @RequestMapping("/h2") // 앞에 /를 붙여도 되고 생략해도 된다. 예) /c01_3/h2
  @ResponseBody
  public String handler2() {
    return "h2";
  }
  
  @RequestMapping("h3") // URL을 지정할 때 디렉토리 형식으로 지정할 수 있다.
  @ResponseBody
  public String handler3() {
    return "h3";
  }
  
  @RequestMapping("h4") 
  @ResponseBody
  public String handler4() {
    return "h4";
  }
  
}
