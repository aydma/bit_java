package day16;

import day17.PriceException;

public class Book {
	private String title;
	private int price;
	
	public Book() {	}

	public Book(String title, int price) throws PriceException {
		this.title = title;
		setPrice(price); //RuntimeException이면 throws Exception안해도 에러안남
		
//		try {
//			setPrice(price); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) throws PriceException { //무슨오류가 나는지 이름만 보고 알수있게함 -> 사용자정의예외 > PriceException클래스를 만들어줌
		if (price < 0)
			throw new PriceException(/* "음수는 안돼" */); // 여기서 메세지 안넘기고 생성자에 설정해줌
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
