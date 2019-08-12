package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test02 {
	public static void main(String[] args) {
		new UI_2();
	}
}

class UI_2 extends Frame { // 내가 프레임이다. // is a 관계로 바꿈
//	Frame f1;  // has a관계를
	
	Button red,blue,exit;
	Panel p1;
	
	UI_2(){
//		f1 = new Frame("awt UI Test ~~"); // 프레임에 타이틀 처리하는 생성자
		super("awt UI Test ~~");  // super가 Frame이니까.
		p1 = new Panel(); // p1 객체생성
		p1.add(red = new Button("RED"));
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("EXIT"));
//		f1.add(p1,BorderLayout.SOUTH);              // 내가 프레임이니까 f1을 다 지워줌
		add(p1,BorderLayout.SOUTH); 

		
		setSize(300, 300);
		setVisible(true);
		
		red.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				p1.setBackground(Color.RED);
			}
		}); 
		blue.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				p1.setBackground(Color.BLUE);
			}
		}); 
		exit.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);
			}
		}); 
		
//		f1.addWindowListener(new WindowEventP());  // 윈도우버튼을 감시하는 감시자 addWindowListener
													// f1이라는 컴포넌트에 윈도우리스너가 발생하면 new WindowEventP()너가 할일은 이안에 있고 이클래스 안에 들어가서 해야할일을한다.
		
		addWindowListener(new WindowAdapter() { // 접근방법을 어노미너스클래스로바꿈
			public void windowClosing(WindowEvent e) { // 재활용이 안됨
				setVisible(false); 
				dispose();
					
				System.exit(0); 
			}
		});  
		
	}
}



