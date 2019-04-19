package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
// @ControllerAdvce
// => 이름에 이미 역할에 대한 정보가 담겨있다.
// => 페이지 컨트롤러를 실행할 때 충고하는 역할을 수행한다.
//    즉 프론트 컨트롤러가 페이지 컨트롤러의 request handler를 호출하기 전에
//    이 애노테이션이 붙은 클래스를 참고하여 적절한 메서드를 호출한다.
@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void initBinder(WebDataBinder binder) throws Exception {
    DatePropertyEditor propeEditor = new DatePropertyEditor();
    CarPropertyEditor propeEditor2 = new CarPropertyEditor();
    EnginePropertyEditor propeEditor3 = new EnginePropertyEditor();
    
    binder.registerCustomEditor(
        java.util.Date.class,
        propeEditor); 
    binder.registerCustomEditor(
        bitcamp.app1.Car.class,
        propeEditor2);
    binder.registerCustomEditor(
        bitcamp.app1.Engine.class, 
        propeEditor3);

  }

  class DatePropertyEditor extends PropertyEditorSupport {

    SimpleDateFormat format;

    public DatePropertyEditor() throws Exception {
      format = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      try {
        Date date = format.parse(text); 
        setValue(date); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }

  class CarPropertyEditor extends PropertyEditorSupport {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      try {
        Car car = new Car();
        String value[] = text.split(",");
        car.setMaker(value[0]);
        car.setCapacity(Integer.parseInt(value[1]));
        car.setAuto(Boolean.parseBoolean(value[2]));
        car.setCreatedDate(format.parse(value[3]));
        setValue(car); 
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
        Engine engine = new Engine();
        String value[] = text.split(",");
        engine.setModel(value[0]);
        engine.setCc(Integer.parseInt(value[1]));
        engine.setValve(Integer.parseInt(value[2]));
        setValue(engine);
    }
  }
}
