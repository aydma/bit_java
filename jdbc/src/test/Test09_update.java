package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.JDBCUtil;
import vo.Dept;

public class Test09_update {
	public static void main(String[] args) {
		Emp9 emp = new Emp9();
		int count = emp.updateEmp(1000,7777);
		System.out.println(count == 1 ? "7777 변경" : "변경 데이터없음");
		
		Dept d = new Dept();
		d.setDeptno(50);
		d.setDname("기술부");
		d.setLoc("제주도");
		count = emp.updateDept(d);
		System.out.println(count + "= > 갱신");
	}
}

class Emp9 {
	public int updateEmp(int comm,int empno){
		String sql = "update emp set comm= ? where empno= ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, comm);
			ps.setInt(2, empno);
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int updateDept(Dept dept) {
		String sql = "update dept set dname = ?, loc = ? where deptno = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLoc());
			ps.setInt(3, dept.getDeptno());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
}