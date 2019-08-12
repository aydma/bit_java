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

// 메뉴바는 프레임에 하나이고 set명령어로 붙인다.
public class Test01 {
	public static void main(String[] args) {
		new UI_1();
	}
}

class UI_1 /* extends Frame */{ /*내가 프레임*/
	Frame f1; //has a관계      //f1을 가장 손쉽게 접근려고 이너클래스로 넣는다.WindowEventP을 
	Button red,blue,exit;
	Panel p1;
	
	UI_1(){
		f1 = new Frame("awt UI Test ~~");
		p1 = new Panel(); // p1 객체생성
		p1.add(red = new Button("RED"));
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("EXIT"));
		f1.add(p1,BorderLayout.SOUTH); // 버튼의 위치를 아래로 함
//		f1.add(p1); // 프레임은 팬널을 가지고 팬널에는 버튼 3개있음
		
		f1.setSize(300, 300);
		f1.setVisible(true);
		
		red.addActionListener(new ActionListener() { // 액션이벤트를감시하는 감시자 addActionListener 
			@Override
			public void actionPerformed(ActionEvent e) { // ActionListener는 추상메소드 1개라서 액션어댑터없음
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
		
		f1.addWindowListener(new WindowAdapter() { // 접근방법을 어노미너스클래스로바꿈
			public void windowClosing(WindowEvent e) { // 재활용이 안됨
				f1.setVisible(false); 
				f1.dispose();
					
				System.exit(0); 
			}
		});  
		
	}
	
//	class WindowEventP extends WindowAdapter {  // 재활용이 됨
//			@Override
//		public void windowClosing(WindowEvent e) { // 창의 x버튼으로 종료하는 메소드
//			// 이것만필요하지만 모든거 다 오버라이딩해야한다.
//			f1.setVisible(false); // f1.쓰는건 이너클래스라서 사용가능함 // 안보이게하고
//			f1.dispose();									 // 파괴시킴
//				
//			System.exit(0); 
//		}
//	}
}//---------------------------------------UI_1클래스


class WindowEventP extends WindowAdapter /* implements WindowListener */{ // WindowListener은 윈도우 이벤트하고 맞물리는 리스너
	// WindowAdapter => WindowListener를 이미 implements한것. 그래서 모든거를 오버라이딩 안하고 원하는 것만 오버라이딩한다.
	// 어댑터의 역할 ex)220V전기를 110V로 바꿔주는 것 // 중간의 완충작업을 함
	
	
	/* @Override public void windowOpened(WindowEvent e) { } */
		@Override
	public void windowClosing(WindowEvent e) { // 창의 x버튼으로 종료하는 메소드
		// 이것만필요하지만 모든거 다 오버라이딩해야한다.
		
			
		System.exit(0); 
	}
	/* @Override public void windowClosed(WindowEvent e) { }
	   @Override public void windowIconified(WindowEvent e) { }
	   @Override public void windowDeiconified(WindowEvent e) { }
	   @Override public void windowActivated(WindowEvent e) { } 
	   @Override public void windowDeactivated(WindowEvent e) { } */
	
	
}




