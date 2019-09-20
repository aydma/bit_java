package test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.UserDAO;
import service.UsersService;
import service.UsersServiceImpl;
import vo.Users;

public class Test12_userService {
	
	UsersService service = null;

	@Before
	public void setUp() {
		System.out.println(" setup() 수행 ");
		
		UserDAO dao = new UserDAO();
		service = new UsersServiceImpl(dao);
	}
	
	@After
	public void tearDown() {
		service = null;
		System.out.println("======= tearDown() 호출 ==========");
	}
	
//	@Test
	public void insert() {
		System.out.println("============ user ============");
		Users vo = new Users();
		vo.setId("abc");
		vo.setPassword("1234");
		vo.setName("홍길동");
		vo.setRole("user");
		
		int num = 0;
		
		num = service.addUsers(vo);
		if(num > 0) System.out.println("등록 성공");
		else {
			System.out.println("등록 실패");
		}
	}
	
//	@Test
	public void update() {
		Users vo = new Users();
		vo.setId("abc");
		vo.setPassword("0000");
		service.usersUpdate(vo);
	}
	
	@Test
	public void login() {
		Users vo = new Users();
		vo.setId("abc");
		vo.setPassword("0000");
		
		System.out.println(service.usersLogin(vo));
		
	}
	
	

}
