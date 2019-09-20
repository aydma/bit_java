package service;

import vo.Users;

public interface UsersService {
	
//	Users user();
	int addUsers(Users vo); // 회원가입
	int usersUpdate(Users vo);
	Users usersLogin(Users vo);
	

}
