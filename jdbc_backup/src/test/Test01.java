package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class Test01 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.OracleDriver";
		// oracle.jdbc.OracleDriver a; // 드라이버이름을 줬을때 오류가 나지 않아야 옳은 것이다.
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
		String user ="SCOTT";  // madang, hr
		String pw="TIGER";     // madang, hr
		
		String sql="select * from emp ";
		System.out.println("****************JDBC TEST****************");
		
		Connection con = null; // db연동할때는  Connection필요 db연결객체
		Statement st = null;   // sql 구문 객체 Statement
		ResultSet rs = null;   // ResultSet은  위의 sql구문 select의 결과값을 받을 객체
		int result = 0; // dml의 결과 값
		
		try {
			// 1. JDBC Driver 설치 : ojdbc6.jar을 classpath에추가해야함 classpath인식을 할 수 있도록 지정하는것 (ojdbc6을 빌드패쓰 라이브러리에 집어넣기)
			// 2. 드라이버 로딩 : 드라이버를 메모리에 올리는 작업			
			// new oracle.jdbc.OracleDriver()	// 메모리에 올라갈 컴파일 타입이 결정이 됨 , new를 쓰는 것은 오라클하고만 연동이 된다.			
			Class.forName(driver); // 드라이버가 런타임에 결정이 된다. 
			
			// 3. DB로 연결 Connection 생성
			con = DriverManager.getConnection(url, user, pw); //db연결객체가 정보받음
			//System.out.println(con); // 연결됐는지 확인
			
			// 4. SQL 구문을 관리해 주는 관리 객체 (Statement) 생성
			st = con.createStatement();
			
			// 5. SQL 실행
			rs = st.executeQuery(sql);
			//System.out.println(rs.getMetaData().getColumnCount());  // 컬럼갯수
			
			// 6. 결과값 핸들링
			while(rs.next()) { // 커서 내려감
				System.out.print(rs.getInt("empno")+"\t");
//				System.out.print(rs.getInt(1)+"\t");             // 인덱스 번호도 사용가능 1은 empno
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getString("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getString("sal")+"\t");
				System.out.print(rs.getString("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver확인 필요");  // 드라이버인식못하거나 이름틀리면 오류남
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 7. 자원 반납 
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("**************** END ****************");
	}
}
