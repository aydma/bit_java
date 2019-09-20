package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

public class BookDAO_MySQL extends BookDAO_t {
	
	public List<BookVO> getBookRec(){ // map구조도 사용가능
		System.out.println("Book_MYSQL getBookRec ");
		List<BookVO> list = new ArrayList<BookVO>();
		
		return list;
	}
	
	
	public int insertBook(BookVO vo){
		System.out.println("Book_MYSQL insertBook ");
		
		return 0;
	}
	
	public int deleteBook(int bookid){
		System.out.println("Book_MYSQL deleteBook ");
		
		return 0;
	}
	
	public int updateBook(BookVO vo){
		System.out.println("Book_MYSQL updateBook ");
		
		return 0;
	}
	
	
	
	
	/*
	  INSERT INTO Book(bookid, bookname, publisher, price)
      VALUES(?, ?, ?, ?);
      
      delete from book where bookid = ?
      
      UPDATE Book SET price =? where bookid = ?
      
      select * from (
	    select rownum row#,bookid,bookname,publisher,price
	    from (select * from Book order by bookid)
	) where row# between ? and ?
	
		select * from Book order by bookid
		
		select count(*) from book

	 */

}
