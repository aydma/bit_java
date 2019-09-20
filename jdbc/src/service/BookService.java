package service;

import java.util.List;

import vo.BookVO;

public interface BookService  {
	
	List<BookVO> bookList();
	int addBook(BookVO vo);
	int deleteBook(int bookid);
	int updateBook(BookVO vo);

}
