package com.ekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ekart.dao.ProductDao;
import com.ekart.model.Cart;
import com.ekart.model.Order;
import com.ekart.model.Payment;
import com.ekart.model.Product;
import com.ekart.model.ProductDB;
import com.ekart.model.Shipping;



public class ProductServiceImpl implements ProductService {
		@Autowired
		ProductDao productdao;
	
		
		public List<ProductDB> selectProduct(Product product) {
			
			// TODO Auto-generated method stub
			 return productdao.selectProduct(product);
		}
	
		public ProductDB getProductById(String product_id) {
			// TODO Auto-generated method stub
			return productdao.getProductById( product_id);
		}
	
		public void addToCart(String product_id,String mailid,int product_cost) {
			// TODO Auto-generated method stub
			 productdao.addToCart(product_id,mailid,product_cost);
			 System.out.println("Item added to cart");
		}
		public Cart viewCart(String mailid)
		{
			return productdao.viewCart(mailid);
		}
		public Cart deleteCartItem(String mailid ,String productid, int product_cost)
		{
			return productdao.deleteCartItem(mailid, productid, product_cost);
		}
		public Shipping shippingAddress(Shipping shipping)
		{
			return productdao.shippingAddress(shipping);
		}
		public Payment paymentVerification(Payment payment)
		{
			return productdao.paymentVerification(payment);
		}
		public long placeOrder(String mailid)
		  {
		    return productdao.placeOrder(mailid);
		  }
		  

		  public List<Order> orderDetails(String mailid)
		  {
		    return productdao.orderDetails(mailid);
		  }
		
		
	
		
	}

