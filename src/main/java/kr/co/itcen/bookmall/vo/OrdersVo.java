package kr.co.itcen.bookmall.vo;

public class OrdersVo {
	private Long no;
	private Long user_no;
	private Long price;
	private String deli_address;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getDeli_address() {
		return deli_address;
	}
	public void setDeli_address(String deli_address) {
		this.deli_address = deli_address;
	}
	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", user_no=" + user_no + ", price=" + price + ", deli_address=" + deli_address
				+ "]";
	}
	
	
}