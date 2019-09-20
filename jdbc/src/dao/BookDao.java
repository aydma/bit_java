package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.Book;

public class BookDao {
	
	public List<Book> getAllBookRec(){
		String sql = "select * from book";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Book(rs.getInt("bookid"),
									rs.getString("bookname"),
									rs.getString("publisher"), 
									rs.getInt("price")));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public int insertBook(Book book) {
		
		String sql = "insert into book values(?,?,?,?) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, book.getBookid());
			ps.setString(2, book.getBookname());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
		
	}
	
	public int updateBook(Book book) {
		String sql = "update book set price = ? where bookid = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, book.getPrice());
			ps.setInt(2, book.getBookid());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int deleteBook(Book book) {
		String sql = "delete from book where lower(bookname) like lower( '%'||?||'%' ) ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, book.getBookname());

			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public List<Book> searchBook(Book book) {
		String sql = "select * from book where lower(bookname) like lower( '%'||?||'%' ) ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, book.getBookname());
			
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Book(rs.getInt("bookid"),
									rs.getString("bookname"),
									rs.getString("publisher"), 
									rs.getInt("price")));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	

}
