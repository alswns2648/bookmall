package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
//		deleteAllTest();
	}
	
//	private static void deleteAllTest(){
//		new UserDao().delete();
//	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------------");
		
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		vo1.setName("둘리");
		vo1.setEmail("dooli");
		vo1.setPhone_num("010-1234-1234");
		vo1.setPasswd("dooli");
		dao.insert(vo1);
		System.out.println(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setName("또치");
		vo2.setEmail("ddochi");
		vo2.setPhone_num("010-5678-5678");
		vo2.setPasswd("ddochi");
		dao.insert(vo2);
		System.out.println(vo2);
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------------");

		UserDao dao = new UserDao();

		List<UserVo> list = dao.getList();
		for(UserVo vo:list) {
			System.out.println(vo);
		}
	}
	
	
}

