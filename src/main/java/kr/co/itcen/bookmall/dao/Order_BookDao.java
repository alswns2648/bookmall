package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import kr.co.itcen.bookmall.vo.Order_BookVo;

public class Order_BookDao {
	
	public Boolean insert(Order_BookVo vo1) {
		Boolean result = false;
		Connection connection =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		

		try {
			connection = getConnection();
			String sql= "insert into order_book values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo1.getBook_no());
			pstmt.setLong(2, vo1.getOrder_no());
			pstmt.setLong(3, vo1.getCount());

			int count = pstmt.executeUpdate();
			result = (count == 1);
			


		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	

	}
	public ArrayList getList() {
		ArrayList result = new ArrayList();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select order_book.no, book.no, book.title, order_book.count"
					+ " from order_book, book, orders"
					+ " where order_book.order_no = orders.no"
					+ " and book.no = order_book.book_no"
					+ " order by order_book.no asc ";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long order_no = rs.getLong(1);
				Long book_no = rs.getLong(2);
				String title = rs.getString(3);
				Long count = rs.getLong(4);

				ArrayList temp = new ArrayList();
				temp.add("order_no : " + order_no);
				temp.add("book_no = " + book_no);
				temp.add("title = " + title);
				temp.add("count = " + count);

				result.add(temp);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	private Connection getConnection() throws SQLException {
		Connection connection  =null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.1.119:3306/bookmall?characterEncoding=utf8";
			connection= DriverManager.getConnection(url, "bookmall", "bookmall");


		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver : "+ e);
		}
		return connection;

	}
}