package day08;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		BookMgr mgr = new BookMgr(5); // 파라미터에 따라 호출하는 생성자함수가 다름

		
		mgr.addBook(new Book("Java Program", 10000)); 
		mgr.addBook(new Book("JSP Program", 12000)); 
		mgr.addBook(new Book("SQL Fundamentals", 19000)); 
		mgr.addBook(new Book("JDBC Program", 14000)); 
		mgr.addBook(new Book("EJB Program", 17000)); 
		mgr.addBook(new Book("Spring", 42000)); 
		
//		System.out.println(Arrays.toString(mgr.getBookList()));
//		for(Book data : mgr.getBookList()) {
//			System.out.println(data);
//		}
		
//		Book[] b = mgr.getBookList();
//		for(int i=0; i<b.length; i++) {
//			b[i].print();
//		}
		
		mgr.bookListPrint();
		System.out.println("총합계: "+mgr.bookTotalPrice());
	}

}
