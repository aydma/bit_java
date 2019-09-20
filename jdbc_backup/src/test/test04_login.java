package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.JDBCUtil;

public class test04_login {

	public static void main(String[] args) {
		System.out.println("   로그인 처리   ");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select * from users where id='java01' and password='1234'";
		
		try {
			
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) { // while안쓴거는 로그인 1개만있어서
				System.out.println(rs.getString("id")+" 님 로그인 되었습니다.");
				System.out.printf("%s / %s", rs.getString("id"),rs.getString("name"));
			}else {
				System.out.println("로그인 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, st, rs);
		}
		
		

	}

}
