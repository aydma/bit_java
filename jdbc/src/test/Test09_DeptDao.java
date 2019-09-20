package test;

import dao.DeptDao;

public class Test09_DeptDao {

	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		
		dao.getDeptRec().forEach(i->System.out.println(i));
		System.out.println("------------------------------------------");
		dao.getDeptRec(2,3).forEach(i->System.out.println(i)); // 2페이지에 3건 출력
		

	}

}
