package com.ekart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ekart.model.Cart;
import com.ekart.model.Order;
import com.ekart.model.Payment;
import com.ekart.model.Product;
import com.ekart.model.ProductDB;
import com.ekart.model.Shipping;
import com.ekart.model.User;

public class ProductDaoImpl implements ProductDao {
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ProductDB> selectProduct(Product product) {
		List<ProductDB> productdb = new ArrayList<ProductDB>();
		System.out.println("Fetching the product details  " + product.getProduct_category_id());
		String sql = "select * from product_table where product_category_id= '" + product.getProduct_category_id()
				+ "'";
		System.out.println(sql);
		productdb = jdbcTemplate.query(sql, new ProductMapper());
		System.out.println("productdb   ----    " + productdb.toString());
		return productdb;
	}

	public ProductDB getProductById(String product_id) {

		String sql = "select * from product_table where product_id='" + product_id + "'";
		List<ProductDB> productdb = jdbcTemplate.query(sql, new ProductMapper());
		return productdb.size() > 0 ? productdb.get(0) : null;
	}

	public void addToCart(String product_id, String mailid, int product_cost) {

		List<Cart> cart = new ArrayList<Cart>();
		String productIDs = "";
		int totalAmount = 0;
		String cartDetailSql = "select * from cart_table where email_id='" + mailid + "'";
		cart = jdbcTemplate.query(cartDetailSql, new CartMapper());
		String cartEntrySql = "";
		System.out.println("before adding in cart " + cart.toString());
		if (cart.size() > 0) {
			productIDs = productIDs + cart.get(0).getProduct_ids().replaceAll(" ", "") + ","
					+ product_id.replaceAll(" ", "");
			totalAmount = totalAmount + cart.get(0).getTotal_amount() + product_cost;
			System.out.println(" productIDs  - " + productIDs + " ,  totalAmount  -- " + totalAmount);
			int cardId = cart.get(0).getCart_id();
			cartEntrySql = "update cart_table set product_id= '" + productIDs + "', total_amount=" + totalAmount
					+ " where cart_id='" + cardId + "'";

		} else {
			cartEntrySql = "Insert into cart_table (email_id,product_id,total_amount) values('" + mailid + "','"
					+ product_id + "'," + product_cost + ")";
		}

		cart = null;
		cart = jdbcTemplate.query(cartEntrySql, new CartMapper());
		// cart = jdbcTemplate.query(cartDetailSql, new CartMapper());
		System.out.println("After adding in cart " + cart.toString());

	}

	public Cart viewCart(String mailid) {
		// List<Cart> cart=new ArrayList<Cart>();
		String sql = "select * from cart_table where email_id='" + mailid + "'";
		List<Cart> cart = jdbcTemplate.query(sql, new CartMapper());

		return cart.size() > 0 ? cart.get(0) : null;
	}

	public Cart deleteCartItem(String mailid, String productid, int product_cost) {
		// List<Cart> cart=new ArrayList<Cart>();
		String productIDs = "";
		int totalAmount = 0;
		int cardId = 0;
		String sql = "select * from cart_table where email_id='" + mailid + "'";
		String updateSql = "";
		List<Cart> cart = jdbcTemplate.query(sql, new CartMapper());
		if (cart.size() > 0) {
			String existProductIDs = cart.get(0).getProduct_ids();
			StringTokenizer st = new StringTokenizer(existProductIDs, ",");
			while (st.hasMoreTokens()) {
				String id = st.nextToken();
				if (!id.equalsIgnoreCase(productid)) {
					productIDs = productIDs + id + ",";
				}
			}
			if (productIDs.length() > 0)
			productIDs = productIDs.substring(0, productIDs.length() - 1);
			totalAmount = cart.get(0).getTotal_amount() - product_cost;
			cardId = cart.get(0).getCart_id();
		}

		if (productIDs.isEmpty()) {
			updateSql = "delete from cart_table where cart_id='" + cardId + "'";
		} else {

			updateSql = "update cart_table set product_id= '" + productIDs + "', total_amount=" + totalAmount
					+ " where cart_id='" + cardId + "'";
		}

		cart = null;
		cart = jdbcTemplate.query(updateSql, new CartMapper());
		cart = null;
		cart = jdbcTemplate.query(sql, new CartMapper());
		System.out.println("cart data after delete ---  " + cart);

		return cart.size() > 0 ? cart.get(0) : null;
	}

	public Shipping shippingAddress(Shipping shipping) {

		String sql = "select * from shipping_address_table where email_id= '" + shipping.getEmail_id() + "'";
		String updateSql = "";

		List<Shipping> shippinglist = jdbcTemplate.query(sql, new ShippingAddressMapper());
		if (shippinglist.size() > 0) {
			Shipping newShippingAddress = shippinglist.get(0);
			updateSql = "update shipping_address_table set pin_code= '" + newShippingAddress.getPin_code() + "', state='"
					+ newShippingAddress.getState() + "', city='" + newShippingAddress.getCity() + "', name='"
					+ newShippingAddress.getName() + "', address='" + newShippingAddress.getAddress()
					+ "', contact_number='" + newShippingAddress.getContact_number() + "', email_id='"
					+ newShippingAddress.getEmail_id() + "' where ship_id=" + newShippingAddress.getShipping_id() ;

			shippinglist = null;
			shippinglist = jdbcTemplate.query(updateSql, new ShippingAddressMapper());
		} else {

			String inserSql = "insert into shipping_address_table (pin_code,state,city,name,address,contact_number,email_id) values(?,?,?,?,?,?,?)";
			jdbcTemplate.update(inserSql,
					new Object[] { shipping.getPin_code(), shipping.getState(), shipping.getCity(), shipping.getName(),
							shipping.getAddress(), shipping.getContact_number(), shipping.getEmail_id() });

		}

		shippinglist = null;
		shippinglist = jdbcTemplate.query(sql, new ShippingAddressMapper());

		return shippinglist.size() > 0 ? shippinglist.get(0) : null;
	}

	public Payment paymentVerification(Payment payment) {

		String sql = "select * from card_table where card_number ='" + payment.getCard_number()
				+ "' and card_holder_name = '" + payment.getCard_holder_name()
				+ "' and expiry_month ="+payment.getExpiry_month()+" and expiry_year="+payment.getExpiry_year()+" and cvv="+payment.getCvv();
		
		List<Payment> paymentDetail = jdbcTemplate.query(sql, new PaymentVerificationMapper());
		System.out.println("hi saket I am inside payment -"  + sql);
		if (paymentDetail.size() > 0) {
			System.out.println("paymentDetail.get(0)   --  "+paymentDetail.get(0).toString());

		}
		System.out.println("hi saket I am inside payment 2 ----");
		

		return paymentDetail.size() > 0 ? paymentDetail.get(0) : null;
	}
	
	public long placeOrder(String mailid)
	  {
	    String product_id = "";
	    int total_amount = 0;
	    String shipping_address = "aa";
	    String sql1 = "select * from shipping_address_table  where email_id='" + mailid + "'";
	    String sql = "select * from cart_table where email_id='" + mailid + "'";
	    List<Shipping> shipping = jdbcTemplate.query(sql1, new ShippingAddressMapper());
	    if (shipping.size() > 0)
	    {
	      String pincode = ((Shipping)shipping.get(0)).getPin_code();
	      String state = ((Shipping)shipping.get(0)).getState();
	      String city = ((Shipping)shipping.get(0)).getCity();
	      String address = ((Shipping)shipping.get(0)).getAddress();
	      shipping_address = pincode + "," + state + "," + city + "," + address + ".";
	    }
	    List<Cart> cart = jdbcTemplate.query(sql, new CartMapper());
	    if (cart.size() > 0)
	    {
	      product_id = ((Cart)cart.get(0)).getProduct_ids();
	      total_amount = ((Cart)cart.get(0)).getTotal_amount();
	    }
	    total_amount -= 836;
	    String inserSql = "insert into order_table (email_id,product_id,total_amount,shipping_address) values(?,?,?,?)";
	    jdbcTemplate.update(inserSql, 
	      new Object[] { mailid, product_id, Integer.valueOf(total_amount), shipping_address });
	    
	    String cartsql = "Delete  from cart_table where email_id='" + mailid + "'";
	    jdbcTemplate.update(cartsql);
	    
	//  Stock Update Code  
	   /* StringTokenizer st = new StringTokenizer(product_id, ",");
	    while (st.hasMoreTokens()) {
	      String prod_id = st.nextToken();
	      

	      String itemSql = "update product_table set stock= stock-1 where product_id='" + prod_id + "'";
	      List localList = jdbcTemplate.query(itemSql, new ProductMapper());
	    }*/
	    
	    String sql2 = "select*from order_table where email_id='" + mailid + "'";
	    

	    List<Order> order = jdbcTemplate.query(sql2, new OrderMapper());
	    Long orderid = ((Order)order.get(order.size() - 1)).getOrder_id();
	    System.out.println(orderid);
	    return orderid.longValue();
	  }
	
	public List<Order> orderDetails(String mailid)
	  {
	    String sql = "select * from order_table where email_id='" + mailid + "'";
	    List<Order> order = jdbcTemplate.query(sql, new OrderMapper());
	    return order.size() > 0 ? order : null;
	  }
	

}




class ProductMapper implements RowMapper<ProductDB> {
	public ProductDB mapRow(ResultSet rs, int arg1) throws SQLException {
		ProductDB productdb = new ProductDB();

		productdb.setProduct_id(rs.getString("product_id"));
		productdb.setProduct_name(rs.getString("product_name"));
		productdb.setBrand_name(rs.getString("brand_name"));
		productdb.setProduct_category_id(rs.getString("product_category_id"));
		productdb.setProduct_image_name(rs.getString("product_img_name"));
		productdb.setProduct_description(rs.getString("product_description"));
		productdb.setItem_left_in_stock(rs.getInt("stock"));
		productdb.setProduct_cost(rs.getInt("product_cost"));
		return productdb;
	}
}

class CartMapper implements RowMapper<Cart> {
	public Cart mapRow(ResultSet rs, int arg1) throws SQLException {
		Cart cart = new Cart();
		cart.setCart_id(rs.getInt("cart_id"));
		cart.setMailID(rs.getString("email_id"));
		cart.setProduct_ids(rs.getString("product_id"));
		cart.setTotal_amount(rs.getInt("total_amount"));

		return cart;
	}
}

class ShippingAddressMapper implements RowMapper<Shipping> {
	public Shipping mapRow(ResultSet rs, int arg1) throws SQLException {
		Shipping shipping = new Shipping();
		shipping.setShipping_id(rs.getInt("ship_id"));
		shipping.setPin_code(rs.getString("pin_code"));
		shipping.setState(rs.getString("state"));
		shipping.setCity(rs.getString("city"));
		shipping.setName(rs.getString("name"));
		shipping.setAddress(rs.getString("address"));
		shipping.setContact_number(rs.getString("contact_number"));
		shipping.setEmail_id(rs.getString("email_id"));

		return shipping;
	}
}

class PaymentVerificationMapper implements RowMapper<Payment> {
	public Payment mapRow(ResultSet rs, int arg1) throws SQLException {
		Payment payment = new Payment();
		payment.setCardId(rs.getInt("card_id"));
		payment.setCard_number(rs.getString("card_number"));
		payment.setCard_holder_name(rs.getString("card_holder_name"));
		payment.setExpiry_month(rs.getInt("expiry_month"));
		payment.setExpiry_year(rs.getInt("expiry_year"));
		payment.setCvv(rs.getInt("cvv"));

		return payment;
	}
}

class OrderMapper implements RowMapper<Order>
{
	OrderMapper() {}
	
	public Order mapRow(ResultSet rs, int arg1) throws SQLException {
		  Order order = new Order();
		  order.setOrder_id(rs.getLong("order_id"));
		  order.setEmail_id(rs.getString("email_id"));
		  order.setTotal_amount(rs.getInt("total_amount"));
		  order.setProduct_id(rs.getString("product_id"));
		  
		  return order;
	}
}

