package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Prob {

	private static void show(int DEPARTMENT_ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int deptno = DEPARTMENT_ID;
		
		String sql = "select round(avg(sal)) as 부서별급여,deptno from emp where deptno=? group by deptno";
		
		try {
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, deptno);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.printf("부서번호  %s \t", rs.getInt("deptno"));
				System.out.printf("부서급여  %s \n", rs.getInt("부서별급여"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("사원의 평균 급여정보");
		
		show(10);
		System.out.println("======================================");
		show(50);

	}

}
