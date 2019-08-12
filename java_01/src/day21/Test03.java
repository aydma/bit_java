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

public class Test03 {
	public static void main(String[] args) {
		new UI_3();
	}
}

class UI_3 extends Frame implements ActionListener{ /*내가 프레임*/
	Button red,blue,exit;
	Panel p1;
	
	UI_3(){
		super("awt UI Test ~~");
		p1 = new Panel(); 
		p1.add(red = new Button("RED"));
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("종료"));  // 한글 안깨지게 하려면 VM아규먼츠에 -Dfile.encoding=MS949 해준다.
		add(p1,BorderLayout.SOUTH); 
//		f1.add(p1); // 프레임은 팬널을 가지고 팬널에는 버튼 3개있음
		
		setSize(300, 300);
		setVisible(true);
		
//		red.addActionListener(new ActionListener() { // 액션이벤트를감시하는 감시자 addActionListener 
//			@Override
//			public void actionPerformed(ActionEvent e) { // ActionListener는 추상메소드 1개라서 액션어댑터없음
//				p1.setBackground(Color.RED);
//			}
//		}); 
//		blue.addActionListener(new ActionListener() { 
//			@Override
//			public void actionPerformed(ActionEvent e) { 
//				p1.setBackground(Color.BLUE);
//			}
//		}); 
//		exit.addActionListener(new ActionListener() { 
//			@Override
//			public void actionPerformed(ActionEvent e) { 
//				System.exit(0);
//			}
//		}); 
		
		red.addActionListener(this);  // 위에거를 바꿈
		blue.addActionListener(this);
		exit.addActionListener(this);

		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				setVisible(false); 
				dispose();
				System.exit(0); 
			}
		});  
	}// --------------------------- UI_3()생성자
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ActionEvent 발생 ");
//		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()) {
			case "RED":
				p1.setBackground(Color.RED);
				break;
			case "BLUE":
				p1.setBackground(Color.BLUE);
				break;
			case "종료":
				System.exit(0);
				break;
			default:
				break;
		}
	}
}


