package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test05 {
	public static void main(String[] args) {
//		new UI_5();
		new UI_5().createUI(); // 생성자가 아니라 사용자 정의메소드라서 직접호출해야한다.
	}
}

class UI_5 extends JFrame implements ActionListener{ /*내가 프레임*/ // J붙이면 스윙이다.
	JButton red,blue,exit; // J붙이면 스윙이다.
	TextField msg;
	TextArea output;
	
//	JPanel p1; // J붙이면 스윙이다.
	Panel p1, p2; 
	
//	UI_5(){
	void createUI(){ // 인스턴스 메소드
		super.setTitle("awt UI Test ~~");  // 창이름
		//super("awt UI Test ~~");
		p1 = new Panel(); 
		p1.add(red = new JButton("RED"));
		p1.add(blue = new JButton("BLUE"));
		p1.add(exit = new JButton("종료"));
		add(p1,BorderLayout.SOUTH); 

		p2 = new Panel();
//		p2.setLayout(new GridLayout(1, 2, 20, 20 )); // 1행 2줄 가로20 세로20
//		p2.setLayout(new GridLayout(1, 2)); // 1행 2열 가로20 세로20
		p2.add(new JLabel("메세지창"));
		p2.add(msg = new TextField(20));
		add(p2,BorderLayout.NORTH); // 메세지창 위치 맨위
		
		add(output = new TextArea(15,40));
		output.setFont(new Font(null, 1, 20));
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 위의 코드를 간단하게 짠것 //J프레임에서만 사용가능 extends JFrame
		
		msg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.append(msg.getText()+"\n"); // 
				msg.setText("");
			}
		});
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


