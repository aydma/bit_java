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

import dao.UserDAO;
import service.UsersService;
import service.UsersServiceImpl;
import vo.Users;

public class UsersApp {
	public static void main(String[] args) {
		new UsersGui();
	}

}

class UsersGui extends JFrame {
	JButton join,login,update,exit;
	TextField id,password,name,role;
	TextArea output;
	
	UserDAO dao = new UserDAO();
	UsersService service = new UsersServiceImpl(dao);
	
	UsersGui(){
		
		Panel p1 = new Panel();
    	p1.add(join = new JButton("가입"));
    	p1.add(login = new JButton("로그인"));
    	p1.add(update = new JButton("수정"));
    	add(p1,BorderLayout.SOUTH);
    	
    	Panel p2 = new Panel();
    	p2.setLayout(new GridLayout(4,2));
    	p2.add(new JLabel("   i d   "));
    	p2.add(id = new TextField(20));
    	p2.add(new JLabel("  password "));
    	p2.add(password = new TextField(20));
    	p2.add(new JLabel("  이 름  "));
    	p2.add(name = new TextField(20));
    	p2.add(new JLabel("  user/admin "));
    	p2.add(role = new TextField(20));
    	add(p2,BorderLayout.NORTH);
    	
    	add(output= new TextArea(15, 40));
    	output.setFont(new Font(null,1,20));
    	
    	pack();
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	join.addActionListener(e -> {
    		Users vo = new Users();
    		vo.setId(id.getText());
    		vo.setPassword(password.getText());
    		vo.setName(name.getText());
    		vo.setRole(role.getText());
    		
    		service.addUsers(vo);
    		
    		id.setText("");
    		password.setText("");
    		name.setText("");
    		role.setText("");
    		output.setText("");
    	});
    	
    	login.addActionListener(e-> {
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	});
    	
    	exit.addActionListener(e-> {
    		System.exit(0);
    	});
    	
    	
		
		
	}
}
