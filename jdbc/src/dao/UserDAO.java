package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;
import vo.Users;

public class UserDAO {
	
	// 회원가입
	public int insertUsers(Users vo){
		String sql = "insert into users values (? , ? , ? , ? ) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	// 회원정보수정
	public int updateUsers(Users vo){
		String sql = "update users set password = ? where id= ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getId());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	// 로그인
	public Users loginUsers(Users vo){ // map구조도 사용가능
		String sql = "select * from users where id= ? and password= ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users users = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getId()); 
			ps.setString(2, vo.getPassword()); 
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			
			if (rs.next()) {
				users = new Users();
				users.setId(rs.getString("id"));
				users.setPassword(rs.getString("password"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return users;
	}

}
/*
insert into users values ('admin', '1234', '관리자', 'admin')  // 회원가입
update users set password = '1234' where id='java01'         // 회원정보수정
select * from users where id='java01' and password='java01'  // 로그인
*/