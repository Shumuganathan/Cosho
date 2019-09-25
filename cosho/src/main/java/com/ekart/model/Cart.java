package com.ekart.model;

public class Cart {
	
	private int cart_id;
	private String mailID;
	private String product_ids;
	private int total_amount;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public String getProduct_ids() {
		return product_ids;
	}
	public void setProduct_ids(String product_ids) {
		this.product_ids = product_ids;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", mailID=" + mailID + ", product_ids=" + product_ids + ", total_amount="
				+ total_amount + "]";
	}
	
	


}
