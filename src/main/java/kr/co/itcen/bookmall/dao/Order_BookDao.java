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
		Connection connection =null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs =null;
		Boolean result = false;

		try {
			connection = getConnection();
			String sql= "insert into order_book values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo1.getBook_no());
			pstmt.setLong(3, vo1.getOrder_no());
			pstmt.setLong(3, vo1.getCount());


			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo1.setNo(no);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
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

			String sql = "select order_book.book_no, book.title, order_book.count"
					+ " from order_book, book "
					+ " where order_book.book_no = book.no and book.no = order_book.book_no  "
					+ " order by order_book.no asc ";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long book_no = rs.getLong(1);
				String book_title=rs.getString(2);
				Long count=rs.getLong(3);

				ArrayList temp = new ArrayList();
				temp.add("orderbook_no = " + book_no);
				temp.add("orderbook_title = " + book_title);
				temp.add("orderbook_count = " + count);

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