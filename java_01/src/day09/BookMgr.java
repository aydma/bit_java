package day09;

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
	
	
	public void addBook(Book book) {//Book 객체를 booklist에 등록하는 addBook(Book book) 메서드
		if(count == bookList.length) {//배열이 꽉차서 리사이징을 해줘야한다.
			Book[] copy = new Book[bookList.length*2];//new를 사용해 복사할 배열길이설정
			System.arraycopy(bookList, 0, copy, 0, bookList.length); //System.arraycopy를 이용해 배열을 복사한다
			// 배열 새로 지정하면 데이터 없으니까 원본데이터 카피함
			bookList = copy;
		}
		bookList[count] = book;
		count++;
	}
	
	public void bookListPrint() {
		System.out.println("=========Book List=========");
		// 배열의 크기와 데이터의 갯수차이가 많이날때는 갯수만큼만 돌려줌
		for(int i=0; i<count; i++) {
			bookList[i].print();
		}
		System.out.println("총 "+count+" 권");
		System.out.println("===========================");
	}
	
//	public int bookTotalPrice() {
//		int sum = 0;
//		for(int i=0; i<count; i++) {
//			sum += bookList[i].getPrice();
//		}
//		return sum;
//	}
	
	// 책삭제메소드
	public void deleteBook(String title) {
		for(int i=0; i<count; i++) {
			if(bookList[i].getTitle().equals(title)) {
				System.arraycopy(bookList, i+1, bookList, i, count-i-1);
				count--;
				System.out.println(title+"삭제되었습니다.");
				return;
			}
		}
		System.out.println("삭제할 도서가 없습니다.");
	}
	
	// 책검색메소드
	public void serchTitleBook(String title) {
		System.out.println(title+"검색");
		for(int i=0; i<count; i++) {
			if(bookList[i].getTitle().toUpperCase().contains(title.toUpperCase())) { //contains 내가 입력한것의 일부가 있는지 확인
				bookList[i].print();
			}
		}
		System.out.println("----------------------------------");
	}
	
}
