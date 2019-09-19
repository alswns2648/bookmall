package kr.co.itcen.bookmall;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.dao.OrdersDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.Order_BookVo;
import kr.co.itcen.bookmall.vo.OrdersVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("===================user=========================");
		UserDao u_dao = new UserDao();

		List<UserVo> u_list = u_dao.getList();
		for(UserVo vo:u_list) {
			System.out.println(vo);
		}

		System.out.println("================category====================");

		CategoryDao cat_dao = new CategoryDao();

		List<CategoryVo> ct_list = cat_dao.getList();
		for(CategoryVo vo:ct_list) {
			System.out.println(vo);
		}
		System.out.println("=================book========================");	
		BookDao b_dao = new BookDao();

		ArrayList b_list = b_dao.getList();
		for(int i =0;i<b_list.size();i++) {
			System.out.println(b_list.get(i));
		}

		System.out.println("===================cart========================");
		CartDao c_dao = new CartDao();

		ArrayList c_list = c_dao.getList();
		for(int i =0;i<c_list.size();i++) {
			System.out.println(c_list.get(i));
		}

		System.out.println("===================orders=====================");
		OrdersDao o_dao = new OrdersDao();

		ArrayList o_list = o_dao.getList();
		for(int i =0;i<o_list.size();i++) {
			System.out.println(o_list.get(i));
		}

		System.out.println("=================order_book===================");
		Order_BookDao ob_dao = new Order_BookDao();

		ArrayList  ob_list =  ob_dao.getList();
		for(int i =0;i< ob_list.size();i++) {
			System.out.println( ob_list.get(i));
		}
	}
}