package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import util.JDBCUtil;
import vo.Employee;

public class Test07_Insert {

	public static void main(String[] args) {
		Emp7 emp = new Emp7(); // 메소드에 static없어서 객체생성
//		int count = emp.insertDept(50, "교육부", "서울");
//		System.out.println(count +" : insert ");
		
		System.out.println("-------------------------------");
		
		// Employee data = new Employee(7777, "고길동", 3900, 10);
//		int count = emp.insertEmp(data);
//		System.out.println(count +" : insert ");
		Employee data = new Employee();
		data.setEmpno(1111);
		data.setEname("이순신");
		data.setSal(9900);
		data.setDeptno(50);
		
		int count = emp.insertEmp(data);
		System.out.println(count +" : insert ");
		
		System.out.println(" end ");
		
	}
}

class Emp7 {
	public int insertDept(int deptno,String dname,String loc) { // JDBC는 AUTOCOMMIT이 기반이다. 그렇지 않으면 블락되서
		String sql = "insert into dept(deptno,dname,loc) values( ?, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; // insert의 결과값
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, deptno);
			ps.setString(2, dname);
			ps.setString(3, loc);
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null); // rs없어서 반납할필요없음
		}
		return result;
	}
	
	// 
	public int insertEmp(Employee emp) { // emp class를 따로 만들어서 변수담음
		String sql = 
				"insert into emp (empno, ename, hiredate, sal, deptno) "
				+ "values(?, ?, sysdate, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setInt(3, emp.getSal());
			ps.setInt(4, emp.getDeptno());
			
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

