package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BookDAO_t;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

public class Test11_bookService { // 단위테스트(메소드)
	
	BookService service = null;
	
	@Before // 비포에서 셋업작업해줌
	public void setUp() {
		System.out.println(" setup() 수행 ");
		
		BookDAO_t dao = new BookDAO_t();
		service = new BookServiceImpl(dao); // service에 주소부여 //어떤 DAO로 동작할건지 
	}
	
	@After // 비포후에 에프터동작한후 테스트동작함
	public void tearDown() {
		service = null;
		System.out.println("======= tearDown() 호출 ==========");
	}
	
//	@Test // 테스트 수행전에 비포가 동작함 
	public void list() { // 어플리케이션으로 돌리는게아니라(main메소드X) 잠깐 테스트하고싶어서 만든것 JUnit
		System.out.println("============ Book List ============");
		service.bookList().forEach(i -> System.out.println(i)); // 에러발생 ->기본값이 null이라서 
		System.out.println("===================================");
	}
	
	// @Test // 메인아니라도 수행하게 하고싶으면 @Test하기
	public void insert() {
		BookVO vo = new BookVO();
		vo.setBookid(6);
		vo.setBookname("~~~~");
		vo.setPrice(900);
		vo.setPublisher("영진출판사");
		int num = 0;
		
		num = service.addBook(vo);
		if(num > 0) System.out.println("등록 성공");
		else {
			System.out.println("등록 실패");
		}
	}
	
	//@Test
	public void update() {
		BookVO vo = new BookVO();
		vo.setBookid(6);
		vo.setPrice(9900);
		service.updateBook(vo);
	}
	//@Test
	public void delete() {
		service.deleteBook(6);
	}

}
