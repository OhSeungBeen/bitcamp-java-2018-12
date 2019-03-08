package com.eomcs.lms.handler;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand extends AbstractCommand {

  BoardDao boardDao;

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = response.requestInt("번호? ");
    Board board = boardDao.findByNo(no);

    if (board == null) {
      response.println("해당 번호의 게시물이 없습니다.");
      return;
    }
    Board temp = new Board();
    temp.setNo(no);
    
    temp.setContents(response.requestString(
        String.format("내용?(%s)", board.getContents())));

    if(temp.getContents().length() == 0) {
      response.println("변경이 취소되었습니다.");
      return;
    }

    boardDao.update(temp);
    response.println("변경했습니다.");
  }
}
