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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test04 {
	public static void main(String[] args) {
		new UI_4();
	}
}

class UI_4 extends JFrame implements ActionListener{ /*내가 프레임*/ // J붙이면 스윙이다.
	JButton red,blue,exit; // J붙이면 스윙이다.
	JPanel p1; // J붙이면 스윙이다.
	
	UI_4(){
		super("awt UI Test ~~");
		p1 = new JPanel(); 
		p1.add(red = new JButton("RED"));
		p1.add(blue = new JButton("BLUE"));
		p1.add(exit = new JButton("종료"));
		add(p1,BorderLayout.SOUTH); 

		
		setSize(300, 300);
		setVisible(true);
		
		red.addActionListener(this);  
		blue.addActionListener(this);
		exit.addActionListener(this);
		
		//	f1.addWindowListener(new WindowEventP());
		
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) { 
//				setVisible(false); 
//				dispose();
//				System.exit(0); 
//			}
//		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 위의 코드를 간단하게 짠것
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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


