package com.eomcs.lms.handler;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

public class LessonDeleteCommand extends AbstractCommand {

  LessonDao lessonDao;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  
  public LessonDeleteCommand(LessonDao lessonDao,
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao) {
    this.lessonDao = lessonDao;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }
  

  @Override
  public void execute(Response response) throws Exception {
      int no = response.requestInt("번호?");
      
      List<PhotoBoard> boards =photoBoardDao.findAll(params)
      
      if (lessonDao.delete(no) == 0) {
        response.println("해당 번호의 수업이 없습니다.");
        return;
      }
      response.println("삭제했습니다.");
  }
}
