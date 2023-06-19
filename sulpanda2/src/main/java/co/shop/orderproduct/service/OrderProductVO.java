package co.shop.orderproduct.service;

public class OrderProductVO {
	private int orderProductId;
	private String orderId;
	private String productName;
	private int productCount;
	private int productFee;
	
	
	public int getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public int getProductFee() {
		return productFee;
	}
	public void setProductFee(int productFee) {
		this.productFee = productFee;
	}
	
	
}
