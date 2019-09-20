package test;

import java.sql.CallableStatement;
import java.sql.Connection;

import util.JDBCUtil;

public class Test10_procedure { // 프로시저 -> 리턴타입이 없고 동작만 하는 것, 트리거 -> 자동호출  
	public static void main(String[] args) {
		// execute InsertBook(1,'java ~~~','한빛',27000);
		
		String sql = "{call InsertBook(?,?,?,?) }";  // 프로시저를 호출하는 sql구문
		Connection con = null;
		CallableStatement ps = null; // CallableStatement 프로시저를 호출하는 sql구문,  Statement 정적인 sql구문, prepareStatement ?를 해결하는 sql구문
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareCall(sql);
			// ?세팅
			ps.setInt(1, 1);
			ps.setString(2, "자바");
			ps.setString(3, "홍길동");
			ps.setString(4, "33000");
			
			// 실행 및 결과값 핸들링
			ps.execute();
			System.out.println(" call InsertBook 수행 ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
	}
}
