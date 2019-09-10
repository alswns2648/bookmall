package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrdersDao;
import kr.co.itcen.bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteAllTest();
	}
	
	private static void deleteAllTest(){
		new OrdersDao().delete();
	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------------");
		
		OrdersDao dao = new OrdersDao();
		
		OrdersVo vo1 = new OrdersVo();
		vo1.setUser_no((long));
		vo1.setPrice((long));
		vo1.setDeli_address("주소지");
		dao.insert(vo1);
		System.out.println(vo1);
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------------");

		OrdersDao dao = new OrdersDao();

		List<OrdersVo> list = dao.getList();
		for(OrdersVo vo:list) {
			System.out.println(vo);
		}
	}
	
	
}