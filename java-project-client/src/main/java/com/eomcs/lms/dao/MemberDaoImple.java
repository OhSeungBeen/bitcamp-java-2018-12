package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDaoImple implements MemberDao {

  Connection con;


  public MemberDaoImple(Connection con) {
    this.con = con;
  }

  public List<Member> findAll() {

    try(PreparedStatement stmt = con.prepareStatement(
        "select member_id, name, email, pwd, cdt, tel, photo from lms_member"+
        " order by member_id desc")){

      ResultSet rs = stmt.executeQuery();
      List<Member> list = new ArrayList<Member>();
      while(rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));;
        member.setPassword(rs.getString("pwd"));
        member.setRegisteredDate(rs.getDate("cdt"));
        member.setTel(rs.getString("tel"));
        member.setPhoto(rs.getString("photo"));
        list.add(member);
      }
      return list;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Member member) {

    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_member(name, email, pwd,  tel, photo)"+
        " values(?, ?, ?, ?, ?)")){
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getTel());
      stmt.setString(5, member.getPhoto());
      stmt.execute();
      System.out.println("저장 하였습니다.");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Member findByNo(int no) {

    try(PreparedStatement stmt = con.prepareStatement(
        "select member_id, name, email, cdt, tel, photo from lms_member"+
        " where member_id = ?")){
      stmt.setInt(1, no);

      ResultSet rs = stmt.executeQuery();

      if(rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setRegisteredDate(rs.getDate("cdt"));
        member.setTel(rs.getString("tel"));
        member.setPhoto(rs.getString("photo"));

        return member;
      } else {
        return null;
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Member member) {

    try(PreparedStatement stmt = con.prepareStatement(
        "update lms_member set "
            + "name = ?, email = ?, pwd = ?, cdt = ?, tel = ?, photo = ?"
            + " where member_id = ?")){

      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setDate(4, member.getRegisteredDate());
      stmt.setString(5, member.getTel());
      stmt.setString(6, member.getPhoto());
      stmt.setInt(7, member.getNo());

      return stmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {

    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_member where member_id = ?")){
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


}









