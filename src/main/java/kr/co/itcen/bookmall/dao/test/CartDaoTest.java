package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
		public static void main(String[] args) {
			insertTest();
			selectTest();
//			deleteAllTest();
		}
		
//		private static void deleteAllTest(){
//			new CartDao().delete();
//		}
		
		private static void insertTest() {
			System.out.println("insert test-----------------------");
			
			CartDao dao = new CartDao();
			
			CartVo vo1 = new CartVo();
			vo1.setBook_no((long)1);
			vo1.setUser_no((long)5);
			vo1.setCart_count((long)3);
			dao.insert(vo1);
			System.out.println(vo1);
			
			CartVo vo2 = new CartVo();
			vo2.setBook_no((long)2);
			vo2.setUser_no((long)6);
			vo2.setCart_count((long)4);
			dao.insert(vo2);
			System.out.println(vo2);
		}
		
		private static void selectTest() {
			System.out.println("select test-----------------------");

			CartDao dao = new CartDao();

			ArrayList list = dao.getList();
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}

}
