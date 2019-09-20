package vo;

public class Book {
//	 bookid      NUMBER(2) PRIMARY KEY,
//	  bookname    VARCHAR2(40),
//	  publisher   VARCHAR2(40),
//	  price       NUMBER(8) 
	
	int bookid;
	String bookname;
	String publisher;
	int price;
	public Book() {}
	
	public Book(String bookname) {
		this.bookname = bookname;
	}
	
	public Book(int bookid, int price) {
		this.bookid = bookid;
		this.price = price;
	}

	public Book(int bookid, String bookname, String publisher, int price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price
				+ "]";
	}
	public Book(int bookid, String bookname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
	}
	
	
	

}
