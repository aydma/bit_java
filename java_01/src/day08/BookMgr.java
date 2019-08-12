package day08;

public class BookMgr {
	
	private Book[] bookList;
	int count=0; // 북개체가 몇개인지 알기위해 관리하려고 만든 변수
	
	public BookMgr() {
		this(10);
		//bookList = new Book[10];
	}
	public BookMgr(int size) { // 생성자에서 배열변수 초기화
		bookList = new Book[size];
	}
//	public Book[] getBookList() {
//		return bookList;
//	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
	
	// 북개체를 등록하려는 매소드
	public void addBook(Book book) {
		if(count == bookList.length) {
			Book[] copy = new Book[bookList.length*2];
			System.arraycopy(bookList, 0, copy, 0, bookList.length); 
			// 배열 새로 지정하면 데이터 없으니까 원본데이터 카피함
			bookList = copy;
		}
		bookList[count] = book;
		count++;
	}
	
	public void bookListPrint() {
		// 배열의 크기와 데이터의 갯수차이가 많이날때는 갯수만큼만 돌려줌
		for(int i=0; i<count; i++) {
			bookList[i].print();
		}
		System.out.println("총 "+count+" 권 ");
		System.out.println("=============================");
	}
	
	public int bookTotalPrice() {
		int sum = 0;
		for(int i=0; i<count; i++) {
			sum += bookList[i].getPrice();
		}
		return sum;
	}
	
}
