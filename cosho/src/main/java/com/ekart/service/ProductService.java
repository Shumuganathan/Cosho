package com.ekart.service;

import java.util.List;

import com.ekart.model.Cart;
import com.ekart.model.Order;
import com.ekart.model.Payment;
import com.ekart.model.Product;
import com.ekart.model.ProductDB;
import com.ekart.model.Shipping;



public interface ProductService {
	
	
	List<ProductDB> selectProduct(Product product);
	
	ProductDB getProductById(String product_id);
	
	void addToCart(String product_id,String mailid,int product_cost);
	
	Cart viewCart(String mailid);
	
	Cart deleteCartItem(String mailid ,String productid, int product_cost);
	
	Shipping shippingAddress(Shipping shipping);
	
	Payment paymentVerification(Payment payment);
	
	long placeOrder(String mailid);

	List<Order> orderDetails(String mailid);
	
	
}
