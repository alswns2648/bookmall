package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {

		public static void main(String[] args) {
			insertTest();
			selectTest();
//			deleteAllTest();
		}
		
//		private static void deleteAllTest(){
//			new BookDao().delete();
//		}
		
		private static void insertTest() {
			System.out.println("insert test-----------------------");
			
			BookDao dao = new BookDao();
			
			BookVo bookvo = new BookVo();
			bookvo.setTitle("어린왕자");
			bookvo.setPrice((long)40000);
			bookvo.setCategory_no((long)13);
			dao.insert(bookvo);
			System.out.println(bookvo);
			
			BookVo bookvo2 = new BookVo();
			bookvo2.setTitle("개미");
			bookvo2.setPrice((long)40000);
			bookvo2.setCategory_no((long)14);
			dao.insert(bookvo2);
			System.out.println(bookvo2);
			
			BookVo bookvo3 = new BookVo();
			bookvo3.setTitle("책");
			bookvo3.setPrice((long)40000);
			bookvo3.setCategory_no((long)15);
			dao.insert(bookvo3);
			System.out.println(bookvo3);
		}
		
		private static void selectTest() {
			System.out.println("select test-----------------------");

			BookDao dao = new BookDao();

			ArrayList list = dao.getList();
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

	}

