package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
		public static void main(String[] args) {
			insertTest();
			selectTest();
			deleteAllTest();
		}
		
		private static void deleteAllTest(){
			new CartDao().delete();
		}
		
		private static void insertTest() {
			System.out.println("insert test-----------------------");
			
			CartDao dao = new CartDao();
			
			CartVo vo1 = new CartVo();
			vo1.setBook_no((long)30);
			vo1.setUser_no((long)14);
			vo1.setCart_count((long)50);
			System.out.println(vo1);
			
			CartVo vo2 = new CartVo();
			vo2.setBook_no((long)50);
			vo2.setUser_no((long)15);
			vo2.setCart_count((long)50);
			System.out.println(vo2);
		}
		
		private static void selectTest() {
			System.out.println("select test-----------------------");

			CartDao dao = new CartDao();

			List<CartVo> list = dao.getList();
			for(CartVo vo:list) {
				System.out.println(vo);
			}
		}

}
