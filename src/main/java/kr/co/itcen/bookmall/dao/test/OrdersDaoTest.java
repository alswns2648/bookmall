package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import kr.co.itcen.bookmall.dao.OrdersDao;
import kr.co.itcen.bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
	}
	
//	private static void deleteAllTest(){
//		new OrdersDao().delete();
//	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------------");
		
		OrdersDao dao = new OrdersDao();
		
		OrdersVo vo1 = new OrdersVo();
		vo1.setUser_no((long)5);
		vo1.setPrice((long)40000);
		vo1.setDeli_address("둘리집");
		dao.insert(vo1);
		System.out.println(vo1);
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------------");

		OrdersDao dao = new OrdersDao();

		ArrayList list = dao.getList();
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	
}