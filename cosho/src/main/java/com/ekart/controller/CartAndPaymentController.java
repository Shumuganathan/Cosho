package com.ekart.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ekart.model.Cart;
import com.ekart.model.Order;
import com.ekart.model.Payment;
import com.ekart.model.Product;
import com.ekart.model.ProductDB;
import com.ekart.model.Shipping;
import com.ekart.model.User;
import com.ekart.service.ProductService;

@Controller
@SessionAttributes("mailid")
public class CartAndPaymentController {
	
	
	@Autowired
	ProductService productservice;
	public String orderShippingAddress = null;
	
	
	@RequestMapping(value = {"/shipping"}, method= {RequestMethod.GET})
	public ModelAndView showregister(HttpServletRequest req,  HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("shipping");
		mav.addObject("shipping", new User());
		
		return mav;
	}
	/*@RequestMapping(value = "/product12/shipping", method= RequestMethod.GET)
	public ModelAndView showregister2(HttpServletRequest req,  HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("shipping");
		mav.addObject("shipping", new User());
		
		return mav;
	}*/
	
	@RequestMapping(value={"/orderDetails"}, method={RequestMethod.GET})
	  public ModelAndView orderDetails(HttpServletRequest req, HttpServletResponse resp, HttpSession session, Model model)
	  {
	    ModelAndView mav = null;
	    System.out.println("Iam outside getqttribute");
	    if (session.getAttribute("mailid") == null) {
	      System.out.println("Iam inside getqttribute");
	      
	      mav = new ModelAndView("login");
	    } else {
	      String mailid = (String)session.getAttribute("mailid");
	      model.addAttribute("mailid", mailid);
	      
	      List<ProductDB> productdbList = new ArrayList();
	      
	      List<Order> order = productservice.orderDetails(mailid);
	      System.out.println("order details");
	      if (order != null) {
	        Iterator<Order> itr = order.iterator();
	        StringTokenizer st; while( itr.hasNext())
	            


	           
	        {
	          Order orderlists = (Order)itr.next();
	          String product_ids = orderlists.getProduct_id();
	          st = new StringTokenizer(product_ids, ",");
	          while(st.hasMoreTokens())   {  
	          String id = st.nextToken();
	          ProductDB productdb = productservice.getProductById(id);
	          productdb.setOrder_id(orderlists.getOrder_id());
	          productdbList.add(productdb);}
	        }
	        



	        mav = new ModelAndView("orderdetails");
	        mav.addObject("list", productdbList);
	      }
	      else{mav = new ModelAndView("Msg");
	      mav.addObject("msg","No Orders!");
	    	  }
	      }
	    return mav;
	  }
	
	
	@RequestMapping(value={"/shippingAddress"}, method = {RequestMethod.POST})
	/*public ModelAndView shippingDetail(HttpServletRequest req ,HttpServletResponse resp,@ModelAttribute("mailid") String mailid, @ModelAttribute("shipping") Shipping shipping )*/
	public ModelAndView shippingDetail(HttpServletRequest req, HttpServletResponse resp, HttpSession session, Model model, @ModelAttribute("shipping") Shipping shipping)
	{
		ModelAndView mav = null;
	    System.out.println("Iam outside getqttribute");
	    if (session.getAttribute("mailid") == null) {
	      System.out.println("Iam inside getqttribute");
	      
	      mav = new ModelAndView("login");
	    } else {
		    String mailid = (String)session.getAttribute("mailid");
		    model.addAttribute("mailid", mailid);
			Shipping ship = new Shipping();
			ship.setPin_code(shipping.getPin_code());
			ship.setState(shipping.getState());
			ship.setCity(shipping.getCity());
			ship.setName(shipping.getName());
			ship.setAddress(shipping.getAddress());
			ship.setContact_number(shipping.getContact_number());
			ship.setEmail_id(mailid);
			
			System.out.println("shipping mailid is  --  "+ship.getEmail_id());
			
			shipping = productservice.shippingAddress(ship);
			
			orderShippingAddress = orderShippingAddress +shipping.getName() +" ," + shipping.getAddress() +" , "+ shipping.getCity()+" , "+shipping.getState() +" , "+shipping.getPin_code() +" , "+shipping.getContact_number() ;
			
	    }
		return new ModelAndView("payment");
	}
	/*@RequestMapping(value="/product12/shippingAddress", method = RequestMethod.POST)
	public ModelAndView shippingDetail1(HttpServletRequest req ,HttpServletResponse resp,@ModelAttribute("mailid") String mailid, @ModelAttribute("shipping") Shipping shipping )
	{
		Shipping ship = new Shipping();
		ship.setPin_code(shipping.getPin_code());
		ship.setState(shipping.getState());
		ship.setCity(shipping.getCity());
		ship.setName(shipping.getName());
		ship.setAddress(shipping.getAddress());
		ship.setContact_number(shipping.getContact_number());
		ship.setEmail_id(mailid);
		
		System.out.println("shipping mailid is  --  "+ship.getEmail_id());
		
		shipping = productservice.shippingAddress(ship);
		
		orderShippingAddress = orderShippingAddress +shipping.getName() +" ," + shipping.getAddress() +" , "+ shipping.getCity()+" , "+shipping.getState() +" , "+shipping.getPin_code() +" , "+shipping.getContact_number() ;
		
		
		return new ModelAndView("payment");
	}*/
	
	
	
	@RequestMapping(value = {"/payment"}, method= {RequestMethod.GET})
	public ModelAndView showpayment(HttpServletRequest req,  HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("payment");
		mav.addObject("payment", new User());
		
		return mav;
	}
	
	
	@RequestMapping(value={"/paymentDetail"}, method = {RequestMethod.POST})
	/*public ModelAndView cardDetail(HttpServletRequest req ,HttpServletResponse resp,@ModelAttribute("mailid") String mailid, @ModelAttribute("payment") Payment payment )*/
	public ModelAndView cardDetail(HttpServletRequest req, HttpServletResponse resp, HttpSession session, Model model, @ModelAttribute("payment") Payment payment)
	{
		ModelAndView mav = null;
	    System.out.println("Iam outside get attribute");
	    if (session.getAttribute("mailid") == null) {
	      System.out.println("Iam inside get attribute");
	      
	      mav = new ModelAndView("login");
	    } else {
		    String mailid = (String)session.getAttribute("mailid");
		    model.addAttribute("mailid", mailid);
			System.out.println("payment  -- "+ payment.toString());
			Payment pay = new Payment();
			pay.setCard_number("1234567891234567");
			pay.setCard_holder_name("saket");
			pay.setExpiry_month(4);
			pay.setExpiry_year(2020);
			pay.setEmail_id(mailid);
			pay.setCvv(542);
			
			System.out.println("payment  -- "+ pay.toString());
			
			System.out.println("shipping mailid is  --  "+pay.getEmail_id());
			
			payment =productservice.paymentVerification(pay);
			
			if(payment!= null)
			{
				System.out.println(payment.toString());
		        long orderid = productservice.placeOrder(mailid);
		        
		        mav = new ModelAndView("Success");
		        mav.addObject("msg", "OrderSuccessfull");
		        mav.addObject("orderid", Long.valueOf(orderid));
			}
			else
			{
				mav = new ModelAndView("payment");
			}
	    }
		return mav;
	}
	
	/*@RequestMapping(value="/product12/paymentDetail", method = RequestMethod.POST)
	public ModelAndView cardDetail2(HttpServletRequest req ,HttpServletResponse resp,@ModelAttribute("mailid") String mailid, @ModelAttribute("payment") Payment payment )
	{
		System.out.println("payment  -- "+ payment.toString());
		ModelAndView mav = null;
		Payment pay = new Payment();
		pay.setCard_number(payment.getCard_number());
		pay.setCard_holder_name(payment.getCard_holder_name());
		pay.setExpiry_month(payment.getExpiry_month());
		pay.setExpiry_year(payment.getExpiry_year());
		pay.setEmail_id(mailid);
		pay.setCvv(payment.getCvv());
		
		System.out.println("payment  -- "+ pay.toString());
		
		System.out.println("shipping mailid is  --  "+pay.getEmail_id());
		
		payment =productservice.paymentVerification(pay);
		
		if(payment!= null)
		{
			mav = new ModelAndView("home");
		}
		else
		{
			mav = new ModelAndView("payment");
		}
		
		return mav;
	}*/
	
	

}
