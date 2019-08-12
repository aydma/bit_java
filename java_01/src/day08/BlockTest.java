package day08;

public class BlockTest {

	public static void main(String[] args) {
		Block b1 = new Block();
		b1.print();
		Block b4 = new Block(55);
		b4.print();
	}
}

class Block {
	int i;
	int j;
	static String name;
	static { // static 자원들만 초기화
		//System.out.println("static {  }"); // 한 번만 실행됨
		name="~~~";
	}
	{
		//System.out.println("{  }"); // 생성자함수보다 먼저 실행되는 초기화 블럭
		this.j=99;
	}
	public Block() {
		//this.j=99;
		//System.out.println("생성자");
	}
	public Block(int i) {
		//this.j=99;
		this.i=i;
		//System.out.println("생성자");
	}
	public void print() {
		System.out.printf("i=%s, j=%s, name=%s %n",i,j,name);
	}
	
}