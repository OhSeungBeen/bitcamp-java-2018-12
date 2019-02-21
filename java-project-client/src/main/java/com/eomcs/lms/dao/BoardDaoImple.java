package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;

// 서버쪽에 있는 BoardDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class BoardDaoImple implements BoardDao {
  Connection con;

  public BoardDaoImple(Connection con) {
    this.con = con;
  }

  public List<Board> findAll() {

    try(PreparedStatement stmt = con.prepareStatement(
        "select board_id, conts, cdt, vw_cnt from lms_board"+
        " order by board_id desc")){

      ResultSet rs = stmt.executeQuery();
      List<Board> list = new ArrayList<Board>();
      while(rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setContents(rs.getString("conts"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));
        list.add(board);
      }
      return list;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } 
  }

  public void insert(Board board) {

    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_board(conts) values(?)")){
      stmt.setString(1, board.getContents());
      stmt.execute();
    }catch (SQLException e) {
      throw new RuntimeException(e);
    } 
  }

  public Board findByNo(int no) {

    try(PreparedStatement stmt = con.prepareStatement(
        "select board_id, conts, cdt, vw_cnt from lms_board"+
        " where board_id = ?")){
      stmt.setInt(1, no);

      ResultSet rs = stmt.executeQuery();

      if(rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setContents(rs.getString("conts"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        return board;
      } else {
        return null;
      }

    }catch (SQLException e) {
      throw new RuntimeException(e);
    } 
  }

  public int update(Board board) {

    try(PreparedStatement stmt = con.prepareStatement(
        "update lms_board set conts = ? where board_id = ?")){
      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getNo());
      return stmt.executeUpdate();

    }catch (SQLException e) {
      throw new RuntimeException(e);

    } 
  }

  public int delete(int no) {

    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_board where board_id = ?")){
      stmt.setInt(1, no);
      return stmt.executeUpdate();

    }catch (SQLException e) {
      throw new RuntimeException(e);
    } 
  }


}









