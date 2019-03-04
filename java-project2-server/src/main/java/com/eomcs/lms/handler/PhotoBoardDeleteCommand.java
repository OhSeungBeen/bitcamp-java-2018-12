package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

public class PhotoBoardDeleteCommand extends AbstractCommand {
  
  PhotoBoardDao photoboardDao;
  PhotoFileDao photoFileDao;
  
  public PhotoBoardDeleteCommand(PhotoBoardDao photoboardDao, PhotoFileDao photoFileDao) {
    this.photoboardDao = photoboardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = response.requestInt("번호?");
    // 데이터를 지울 때는 자식 테이블의 데이터부터 지워야 한다.
    photoFileDao.deleteByPhotoBoardNo(no);

    if (photoboardDao.delete(no) == 0) {
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }
   
    response.println("삭제했습니다.");
  }
}
