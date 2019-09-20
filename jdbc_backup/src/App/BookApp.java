package App;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.BookDAO_t;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

public class BookApp {

	public static void main(String[] args) {
		// DAO는 DB연동 코드를 직접 가지고 있어서 DAO를 직접 안씀
		// ~service(인터페이스)를 통해서  서비스받음
		// BookDAO <-서비스해줌(service레이어=비지니스레이어)서비스받음<-BOOKAPP
		
//		BookService service = null; // gui에 적절한 이벤트 핸들링하면서 작업가능
		
		// service.addBook(vo);
		
//		service.bookList().forEach(i->System.out.println(i)); // 이결과값을 gui어딘가에 붙이면서 작업가능
		
		new Gui();
		
		

	}

}

class Gui extends JFrame{
	static int num=0;
    JButton add,list,delete,search,exit;
    TextField title,price,isbn,publisher;
    TextArea output;
    
    BookDAO_t dao = new BookDAO_t();
    BookService service = new BookServiceImpl(dao);
	
    Gui(){
    	
    	Panel p1 = new Panel();
    	p1.add(add = new JButton("ADD"));
    	p1.add(list = new JButton("List"));
    	p1.add(delete = new JButton("삭제"));
    	p1.add(search = new JButton("검색"));
    	p1.add(exit = new JButton("종료"));
    	add(p1,BorderLayout.SOUTH);
    	
    	Panel p2 = new Panel();
    	p2.setLayout(new GridLayout(4,2));
    	p2.add(new JLabel("   ISBN   "));
    	p2.add(isbn = new TextField(20));
    	p2.add(new JLabel("  제      목   "));
    	p2.add(title = new TextField(20));
    	p2.add(new JLabel("  가      격  "));
    	p2.add(price = new TextField(20));
    	p2.add(new JLabel("  출 판 사   "));
    	p2.add(publisher = new TextField(20));
    	add(p2,BorderLayout.NORTH);
    	
    	add(output= new TextArea(15, 40));
    	output.setFont(new Font(null,1,20));
    	
    	pack();
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	add.addActionListener(e -> {
    		BookVO vo = new BookVO();
    		vo.setBookid(Integer.parseInt(isbn.getText())); // vo의 setBookid에 사용자가 isbn창에 입력한 문자를 정수형으로 바꿔서 넘겨준다.
    		vo.setBookname(title.getText());
    		vo.setPrice(Integer.parseInt(price.getText()));
    		vo.setPublisher(publisher.getText());
    		
    		service.addBook(vo);
    		
    		title.setText("");
    		isbn.setText("");
    		price.setText("");
    		publisher.setText("");
    		output.setText("");
    	});
    	
    	exit.addActionListener(e-> {
//    	    mgr.save();
    		System.exit(0);
    	});
    	
    	list.addActionListener(e -> {
    		output.setText(" BookList  \n");
//    		mgr.getBookList().forEach(i -> {
//    			output.append(i+"\n"); 
//    		} );
    		
    		service.bookList().forEach(i -> output.append(i+"\n"));
    	});
    	
    	delete.addActionListener(e -> {
    		int i = service.deleteBook(Integer.parseInt(isbn.getText()));
    		output.setText(i+" 개의 도서 삭제 \n");
    	});
    	
    	
    	
    	
    }
	
}

