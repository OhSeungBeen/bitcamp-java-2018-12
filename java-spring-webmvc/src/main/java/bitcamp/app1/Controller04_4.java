package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_4")
public class Controller04_4 {
  //클라이언트가 보낸 요청 파라미터 값(String 타입)을
  // request handler 아규먼트 타입(String, int, boolean 등)의 값으로 바꿀 때
  // primitive type에 대해서는 자동으로 변환해 준다.
  // 그 외의 타입에 대해서는 프로퍼티 에디터(타입 변환기)가 없으면 예외를 발생시킨다.

  // => 요청 핸들러의 아규먼트가 값 객체라면,
  //    프론트 컨트롤러는 메서드를 호출할 때 값 객체의 인스턴스를 생성한 후
  //    요청 파라미터와 일치하는 프로퍼티에 대해 값을 저장한다.
  //    그리고 호출할 때 넘겨준다.
  //
  //
  // 테스트:
  // http://.../app1/c04_4/h1?model=sonata&createdDate=2019-04-13&capacity=5&auto=true
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      String model,
      int capacity, // String ===> int (Integer.parseInt(String)
      //boolean auto, // String ===> boolean Boolean.parseBoolean(String)
      Date createdDate // 프로퍼티 에디터를 설정하지 않으면 변환 오류 발생
      ) {

    out.printf("model=%s\n", model);
    out.printf("capacity=%s\n", capacity);
    //out.printf("auto=%s\n", auto);
    out.printf("createdDate=%s\n", createdDate);
  }

  //테스트:
  // http://.../app1/c04_4/h2?car=sonata,5,true,2019-4-19
  @GetMapping("h2")
  @ResponseBody
  public void handler2(
      PrintWriter out,
      // 콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      // => String ===> Car 프로퍼티 에디터를 등록하면 된다.
      @RequestParam("car") Car car
      ) {

    out.println(car);
  }

  //테스트:
  // http://.../app1/c04_4/h3?engine=bitengine,3500,16
  @GetMapping("h3")
  @ResponseBody
  public void handler3(
      PrintWriter out,
      // 콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      // => String ===> Car 프로퍼티 에디터를 등록하면 된다.
      @RequestParam("engine") Engine engine
      ) {

    out.println(engine);
  }

  // PropertyEditor 만들기
  // => 문자열을 특정 타입의 프로퍼티의 값으로 변환시킬 때 사용하는 에디터이다.
  // => java.beans.PropertyEditor 인터페이스를 구현해야 한다.
  // => PropertyEditor를 직접 구현하면 너무 많은 메서드를 오버라이딩 해야 하기 때문에
  //      자바에서는 도우미 클래스인 PropertyEditorSupport 클래스를 제공한다.
  //      이 클래스가 PropertyEditor를 미리 구현하였다.
  //      따라서 이 클래스를 상속 받은 것이 더 낫다.


  // 프로퍼티 에디터를 프론트 컨트롤러에게 적용하기
  // => 프론트 컨트롤러는 request handler를 호출하기 전에
  //    넘겨줄 아규먼트 값을 준비 해야 한다.
  //    각 아규먼트 값을 준비할 때 @InitBinder가 표시된 메서드를 호출하여
  //    프로퍼티 에디터(변환기)를 준비시킨다.
  //    그리고 이 준비된 값 변환기(프로퍼티 에디터)를 이용하여 파라미터 값을
  //   request handler의 아규먼트가 원하는 타입의 값을 바꾼다.
  //    따라서 request handler의 아규먼트 개수 만큼 이메서드를 호출한다.
  // => 따라서 프로퍼티 에디터를 적용하기에
  //  @InitBinder가 표시된 메서드가 적절한 지점이다.
  //   즉 이 메서드에 프로퍼티 에디터를 등록하는 코드를 둔다.
  @InitBinder
  public void initBinder(WebDataBinder binder) throws Exception {
    //System.out.println("Controller04_4.initBinder()"); 
    // 프로퍼티 에디터를 등록하려면 그 일을 수행할 객체가 필요하다.
    // request handler 처럼 아규먼트를 선언하여
    // 프론트 컨트롤러에게 달라고 요청하라.

    // String ===> Date 프로퍼티 에디터 준비
    DatePropertyEditor propeEditor = new DatePropertyEditor();
    CarPropertyEditor propeEditor2 = new CarPropertyEditor();
    EnginePropertyEditor propeEditor3 = new EnginePropertyEditor();
    // WebDataBinder에 등록하기
    binder.registerCustomEditor(
        java.util.Date.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다. 
        propeEditor); // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    binder.registerCustomEditor(
        bitcamp.app1.Car.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다. 
        propeEditor2);
    binder.registerCustomEditor(
        bitcamp.app1.Engine.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다. 
        propeEditor3);

  }

  class DatePropertyEditor extends PropertyEditorSupport {

    // yyyy-MM-dd 형태의 문자열을 java.util.Date 객체로 만들어주는 클래스를 준비한다.

    SimpleDateFormat format;

    public DatePropertyEditor() throws Exception {
      // 프로퍼티 에디터를 사용하는 측에서 어떤 형식의 문자열을 Date 객체로 만들 것인지
      // 설정하지 않았다면 기본으로 yyyy-MM-dd 형식의 문자열을 Date 객체로 만들도록 준비한다.
      format = new SimpleDateFormat("yyyy-MM-dd");
    }

    public DatePropertyEditor(SimpleDateFormat format) throws Exception {
      // 물론 프로퍼티 에디터를 사용하는 측에서 날짜에 대한 문자열 형식을 지정할 수도 있다.
      this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      // 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서
      // 문자열을 Date 객체로 바꾸기 위해 이 메서드를 호출할 것이다.
      // 그러면 이 메서드에서 문자열을 프로퍼티가 원하는 타입으로 변환한 후 저장 하면 된다.
      try {
        Date date = format.parse(text); // String ===> java.util.date
        setValue(date); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }

    @Override
    public Object getValue() {
      System.out.println("DatePropertyEditor.getValue()");
      // 이 메서드는 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서
      // 변환된 값을 꺼낼 때 호출된다.
      // 이 메서드를 오버라이딩 하는 이유는 이 메서드가 호출된 것을 
      // 확인하기 위함이다. 원래는 오버 라이딩 해야 할 이유가 없다.
      return super.getValue();
    }

  }

  class CarPropertyEditor extends PropertyEditorSupport {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      // 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서
      // 문자열을 Date 객체로 바꾸기 위해 이 메서드를 호출할 것이다.
      // 그러면 이 메서드에서 문자열을 프로퍼티가 원하는 타입으로 변환한 후 저장 하면 된다.
      try {
        Car car = new Car();
        String value[] = text.split(",");
        car.setMaker(value[0]);
        car.setCapacity(Integer.parseInt(value[1]));
        car.setAuto(Boolean.parseBoolean(value[2]));
        car.setCreatedDate(format.parse(value[3]));
        setValue(car); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }
  
  class EnginePropertyEditor extends PropertyEditorSupport {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      // 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서
      // 문자열을 Date 객체로 바꾸기 위해 이 메서드를 호출할 것이다.
      // 그러면 이 메서드에서 문자열을 프로퍼티가 원하는 타입으로 변환한 후 저장 하면 된다.
        Engine engine = new Engine();
        String value[] = text.split(",");
        engine.setModel(value[0]);
        engine.setCc(Integer.parseInt(value[1]));
        engine.setValve(Integer.parseInt(value[2]));
        setValue(engine);
    }
  }

}
