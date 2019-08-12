package day21;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Stream;

import javax.swing.JFrame;

public class Test06 {

	public static void main(String[] args) {
		new DrawImg();

	}

}

class DrawImg extends Frame{ // 이미지 처리
	Image im;
	
	DrawImg(){
		super.setTitle("DrawImg");
		im = Toolkit.getDefaultToolkit().getImage("c://img/123.png");
		
		String[] fontlist = Toolkit.getDefaultToolkit().getFontList(); // 시스템에서 폰트 뭐쓰는지 확인 
																	   // 선그어진이유는 옛날에는 썼는데 지금은 쓰지말라는 의미
		Stream.of(fontlist).forEach(i -> System.out.println(i));
		
		setSize(500, 500);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				setVisible(false); 
				dispose();
				System.exit(0); 
			}
		});  
		
		repaint(); //paint메소드가 시스템적으로 내부적으로 호출됨
	}
	
	public void paint(Graphics g) { // 이미지를 그린다.
		g.drawImage(im, 20,20,120,120,this); // im를 20,20 xy의 좌표 120,120이미지크기// 이미지를 그려줄지아닐지 감시함 this
	}
	
	
	
}