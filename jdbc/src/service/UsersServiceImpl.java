package service;

import dao.UserDAO;
import vo.Users;

public class UsersServiceImpl implements UsersService{
	
	UserDAO dao;
	
	public UsersServiceImpl() {}
	public UsersServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
	}
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int addUsers(Users vo) {
		return dao.insertUsers(vo);
	}

	@Override
	public int usersUpdate(Users vo) {
		return dao.updateUsers(vo);
	}
	@Override
	public Users usersLogin(Users vo) {
		return dao.loginUsers(vo);
		
	}
	

}
