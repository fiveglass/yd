package co.shop.model;

public class CartDTO {
	//cart table
	private int cart_id;
	private String member_id;
	private int product_id;
	private int product_count;
	
	//product 이건 확인해서 조인해야될듯
	private String product_name;
	private int product_price;
	private double product_sale_price;
	
	//밑에 가격 나오게 할것들 (이건 게터 세터 x)
	private int sale_price;
	private int total_price;
	
	
	
	
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	
}
