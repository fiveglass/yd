package co.shop.product.service;

import java.sql.Date;


public class ProductVO {
	private String productId;
    private String productName;
    private String productKind;
    private String productImg;
    private String productImgPath;
    private int productPrice;
    private Date productDate;
    private String productTaste;
    private String productSparkling;
    private int productABV;
    private String productSale;
    private String productSalePercent;
    private int productSalePrice;
    
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductKind() {
		return productKind;
	}
	public void setProductKind(String productKind) {
		this.productKind = productKind;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductImgPath() {
		return productImgPath;
	}
	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	public String getProductTaste() {
		return productTaste;
	}
	public void setProductTaste(String productTaste) {
		this.productTaste = productTaste;
	}
	public String getProductSparkling() {
		return productSparkling;
	}
	public void setProductSparkling(String productSparkling) {
		this.productSparkling = productSparkling;
	}
	public int getProductABV() {
		return productABV;
	}
	public void setProductABV(int productABV) {
		this.productABV = productABV;
	}
	public String getProductSale() {
		return productSale;
	}
	public void setProductSale(String productSale) {
		this.productSale = productSale;
	}
	public String getProductSalePercent() {
		return productSalePercent;
	}
	public void setProductSalePercent(String productSalePercent) {
		this.productSalePercent = productSalePercent;
	}
	public int getProductSalePrice() {
		return productSalePrice;
	}
	public void setProductSalePrice(int productSalePrice) {
		this.productSalePrice = productSalePrice;
	}
    
    
    
}
