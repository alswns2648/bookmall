package kr.co.itcen.bookmall.vo;

public class Order_BookVo {
	private Long no ;
	private Long order_no;
	private Long book_no;
	private Long count;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Book_OrdersVo [no=" + no + ", order_no=" + order_no + ", book_no=" + book_no + ", count=" + count + "]";
	}
	

}
