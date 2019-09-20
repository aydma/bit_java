package test;

import dao.BookDao;
import vo.Book;

public class Test_BookDao {

	public static void main(String[] args) {
		BookDao dao = new BookDao();
		
		dao.getAllBookRec().forEach(i->System.out.println(i));
		
		Book book = new Book();
		book.setPrice(9000);
		book.setBookid(1);
		int count = dao.updateBook(book);
		System.out.println(count + "= > 갱신");
		
		Book book2 = new Book(3, "java", "김영희", 5000);
		count = dao.insertBook(book2);
		System.out.println(count + "= > 갱신");
		
		Book book1 = new Book("j");
		dao.searchBook(book1).forEach(i->System.out.println(i));
		
		
		count =  dao.deleteBook(book2);
		System.out.println(count + "= > 갱신");
		
		
		
		

	}

}
