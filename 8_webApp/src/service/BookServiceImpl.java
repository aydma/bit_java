package service;

import java.util.List;

import dao.BookDAO_t;
import vo.BookVO;

public class BookServiceImpl implements BookService{ // 북서비스를 구현한 클래스 // 북서비스의 추상메소드 오버라이딩하기

	BookDAO_t dao; // bookdao를 강력하게 연결하지않음
	
	public BookServiceImpl() {}
	public BookServiceImpl(BookDAO_t dao) {
		this.dao = dao;
	}
	
	public BookDAO_t getDao() {
		return dao;
	}
	public void setDao(BookDAO_t dao) {
		this.dao = dao;
	}
	
	
	@Override
	public List<BookVO> bookList() {
		return dao.getBookRec();
	}

	@Override
	public int addBook(BookVO vo) throws Exception{
		return dao.insertBook(vo);
	}

	@Override
	public int deleteBook(int bookid) {
		return dao.deleteBook(bookid);
	}

	@Override
	public int updateBook(BookVO vo) {
		return dao.updateBook(vo);
	} 
	

}
