package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.Dept;

public class DeptDao {
	
	// Dept 테이블의 모든 레코드 정보 
	public List<Dept> getDeptRec() {
		String sql = "select * from dept order by deptno ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			//System.out.println( "***** con 할당 ***** ");
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 없어서 ?세팅 안함 
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), 
					     		  rs.getString("dname"), 
					     		  rs.getString("loc")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
			//System.out.println( "***** con 반납 ***** ");
		}
		return list;
	}
	// 페이징 처리
	public List<Dept> getDeptRec(int page, int n) { //n은 한페이지에 몇건을 출력할건지의 정보
		String sql = 		
		"select * from ( "+
			    "select rownum row#,deptno,dname,loc "+
			    "from (select * from dept order by deptno) "+
			") where row# between ? and ? ";

		int start = n*(page-1)+1;
		int end = start+(n-1);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			//System.out.println( "***** con 할당 ***** ");
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), 
					     		  rs.getString("dname"), 
					     		  rs.getString("loc")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
			//System.out.println( "***** con 반납 ***** ");
		}
		return list;
	}
	
	

	public int insertDept(Dept dept) { // JDBC는 AUTOCOMMIT이 기반이다. 그렇지 않으면 블락되서
		String sql = "insert into dept(deptno,dname,loc) values( ?, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; // insert의 결과값

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());

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
