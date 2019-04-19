package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_6")
public class Controller04_6 {
  // 클라이언트의 HTTP 요청 헤더를 받고 싶으면
  // request handler의 아규먼트 앞에 @RequestHeader(헤더명) 애노테이션을 붙여라!

  // 테스트:
  // http://.../app1/c04_6/h1
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      @RequestHeader("Accept") String accept,
      @RequestHeader("User-Agent") String userAgent
      ) {

    out.printf("Aceept=%s\n", accept);
    out.printf("User-Agent=%s\n", userAgent);
    if(userAgent.matches(".*Chrome.*")) {
      out.println("크롬 브라우저 입니다.");
    } else if (userAgent.matches(".*Safari.*")) {
      out.println("사파리 브라우저 입니다.");
    }else if (userAgent.matches(".*Firefox.*")) {
      out.println("파이어 폭스브라우저 입니다.");
    }else {
      out.println("etc");
    }
  }
}
