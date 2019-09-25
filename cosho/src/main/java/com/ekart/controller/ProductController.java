package com.ekart.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ekart.model.Cart;
import com.ekart.model.Product;
import com.ekart.model.ProductDB;
import com.ekart.service.ProductService;

@Controller
@SessionAttributes("mailid")
public class ProductController {
	@Autowired
	ProductService productservice;
	
	/*@RequestMapping(value = "/product12/{productCategoryId}", method = RequestMethod.GET)*/
	@RequestMapping(value = {"/product12"}, method = {RequestMethod.GET})

	public ModelAndView selectSportsProduct(HttpServletRequest req, HttpServletResponse res, @RequestParam("productCategoryId") String productCategoryId) {
		Product product = new Product();
		ModelAndView mav = null;
		System.out.println("saket I am inside product call");
		product.setProduct_category_id(productCategoryId);
		System.out.println("product  --- " + product);
		List<ProductDB> productdb = productservice.selectProduct(product);

		System.out.println("productdb  --  " + productdb);

		mav = new ModelAndView("product");
		mav.addObject("list", productdb);
		mav.addObject("productCategoryId", productCategoryId);

		return mav;
	}

	/*@RequestMapping(value = "/product", method = RequestMethod.POST, params = "groceries")

	public ModelAndView selectGroceriesProduct(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("product") Product product) {

		ModelAndView mav = null;

		product.setProduct_category_id("");
		List<ProductDB> productdb = productservice.selectProduct(product);

		mav = new ModelAndView("product");
		mav.addObject("list", productdb);

		return mav;
	}*/

	/*@RequestMapping("product12/addToCart/{product_id}")*/
	@RequestMapping({"/addToCart"})
	public ModelAndView addToCart(HttpServletRequest req, HttpServletResponse res, HttpSession session, @RequestParam("product_id") String product_id, Model model) {
		
		ModelAndView mav = null;
		System.out.println("Iam outside getqttribute");
	    if (session.getAttribute("mailid") == null) {
	      System.out.println("Iam inside getqttribute");
	      
	      mav = new ModelAndView("login");
	    } else {
	    	String mailid = (String)session.getAttribute("mailid");
	    	model.addAttribute("mailid", mailid);
	
	    	System.out.println("saket I am inside add to cart call and mailid id - "+mailid);
	
			ProductDB productdb=productservice.getProductById(product_id);
			int product_cost=productdb.getProduct_cost();
			productservice.addToCart(product_id,mailid,product_cost);
			System.out.println("saket I am inside add to cart call");
			mav = new ModelAndView("Msg");
			mav.addObject("msg", "Item added to cart");
	    }
		return mav;
	}
	
	
	/*@RequestMapping("product12/viewItem/addToCart/{product_id}")
	public ModelAndView addToBag(HttpServletRequest req, HttpServletResponse res,@PathVariable(value = "product_id") String product_id, @ModelAttribute("mailid") String mailid) {
		System.out.println("saket I am inside add to cart call and mailid id - "+mailid);
		ModelAndView mav = null;
		ProductDB productdb=productservice.getProductById(product_id);
		int product_cost=productdb.getProduct_cost();
		productservice.addToCart(product_id,mailid,product_cost);
		System.out.println("saket I am inside add to cart call");
		
		 * if(productdb!=null){ mav= new ModelAndView("cart");
		 * mav.addObject("product_description",productdb.getProduct_description(
		 * )); mav.addObject("product_cost",productdb.getProduct_cost());
		 * mav.addObject("item_left_in_stack",productdb.getItem_left_in_stack())
		 * ;
		 * 
		 * }
		 

		mav = new ModelAndView("Success");
		mav.addObject("msg", "Item added to cart");

		return mav;
	}*/
	

	/*@RequestMapping(value = "product12/viewItem/{productid}", method = RequestMethod.GET)*/
	@RequestMapping(value = {"/viewItem"}, method = {RequestMethod.GET})
	/*public ModelAndView getProductById(HttpServletRequest req, HttpServletResponse res,@PathVariable(value = "productid") String productid) {*/
	public ModelAndView getProductById(HttpServletRequest req, HttpServletResponse res, @RequestParam("product_id") String productid){
		
		System.out.println("saket I am inside viewItem call");
		ModelAndView mav = null;
		ProductDB productdb = productservice.getProductById(productid);
		if (productdb != null) {
			mav = new ModelAndView("productdescription");
			mav.addObject("product_description", productdb.getProduct_description());
			mav.addObject("product_cost", productdb.getProduct_cost());
			mav.addObject("item_left_in_stack", productdb.getItem_left_in_stock());
			mav.addObject("product_id", productdb.getProduct_id());
			mav.addObject("product_image_name", productdb.getProduct_image_name());
			mav.addObject("brand_name", productdb.getBrand_name());
		} else {
			mav = new ModelAndView("productdescription");
			mav.addObject("product_description", "no such product");

		}
		return mav;
	}
	
	/*@RequestMapping(value = "/viewCart", method = RequestMethod.GET)*/
	@RequestMapping(value = {"/viewCart"}, method = {RequestMethod.GET})
	/*public ModelAndView cartView(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("mailid") String mailid) {*/
	public ModelAndView cartView(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model model) {
		
		ModelAndView mav = null;
	    System.out.println("Iam outside getqttribute");
	    if (session.getAttribute("mailid") == null) {
	      System.out.println("Iam inside getattribute");
	      
	      mav = new ModelAndView("login");
	    } else {
	    	String mailid = (String)session.getAttribute("mailid");
	    	model.addAttribute("mailid", mailid);
			System.out.println("saket I am inside viewCart call");
			String cartProductIds ="";
			int total_Amount =0;
			int totalAmountAfterDiscount =0;
			List<ProductDB> productdbList = new ArrayList<ProductDB>();
			Cart cart = productservice.viewCart(mailid);
			if (cart != null) {
				cartProductIds = cart.getProduct_ids();
				total_Amount = cart.getTotal_amount();
				StringTokenizer st = new StringTokenizer(cartProductIds, ",");
				while(st.hasMoreTokens())
				{
					String id= st.nextToken();
					ProductDB productdb = productservice.getProductById(id);
					productdbList.add(productdb);
					
				}
				totalAmountAfterDiscount = total_Amount -(215+621);
				mav = new ModelAndView("cart");
				mav.addObject("list", productdbList);
				mav.addObject("total_Amount", total_Amount);
				mav.addObject("totalAmountAfterDiscount", totalAmountAfterDiscount);
			} 
			else{
				mav = new ModelAndView("Msg");
				mav.addObject("msg", "Cart is Empty");
			}
	    }
		return mav;
	}
	
	/*@RequestMapping(value = "/product12/viewCart", method = RequestMethod.GET)
	public ModelAndView cartView2(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("mailid") String mailid) {
		
		System.out.println("saket I am inside viewCart call");
		String cartProductIds ="";
		int total_Amount =0;
		int totalAmountAfterDiscount =0;
		ModelAndView mav = null;
		if(mailid==null)
		{
			mav = new ModelAndView("login");
		}
		else
		{
			
		
			List<ProductDB> productdbList = new ArrayList<ProductDB>();
			Cart cart = productservice.viewCart(mailid);
			if (cart != null) {
				cartProductIds = cart.getProduct_ids();
				total_Amount = cart.getTotal_amount();
				StringTokenizer st = new StringTokenizer(cartProductIds, ",");
				while(st.hasMoreTokens())
				{
					String id= st.nextToken();
					ProductDB productdb = productservice.getProductById(id);
					productdbList.add(productdb);
					
				}
				totalAmountAfterDiscount = total_Amount -(215+621);
				mav = new ModelAndView("cart");
				mav.addObject("list", productdbList);
				mav.addObject("total_Amount", total_Amount);
				mav.addObject("totalAmountAfterDiscount", totalAmountAfterDiscount);
			} 
			else{
				mav = new ModelAndView("cart");
				mav.addObject("list", "Cart is Empty");
			}
		}
		return mav;
	}*/
	
	 
	/*@RequestMapping(value = "/product12/viewItem/viewCart", method = RequestMethod.GET)
	public ModelAndView cartView3(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("mailid") String mailid) {
		
		System.out.println("saket I am inside viewCart call");
		System.out.println("saket I am inside viewCart call3 and mail id is - " +mailid);
		String cartProductIds ="";
		int total_Amount =0;
		int totalAmountAfterDiscount =0;
		
		ModelAndView mav = null;
		if( mailid==null)
		{
			System.out.println("saket I am inside if");
			mav = new ModelAndView("login");
		}
		else
		{
			List<ProductDB> productdbList = new ArrayList<ProductDB>();
			Cart cart = productservice.viewCart(mailid);
			if (cart != null) {
				cartProductIds = cart.getProduct_ids();
				total_Amount = cart.getTotal_amount();
				StringTokenizer st = new StringTokenizer(cartProductIds, ",");
				while(st.hasMoreTokens())
				{
					String id= st.nextToken();
					ProductDB productdb = productservice.getProductById(id);
					productdbList.add(productdb);
					
				}
				totalAmountAfterDiscount = total_Amount -(215+621);
				mav = new ModelAndView("cart");
				mav.addObject("list", productdbList);
				mav.addObject("total_Amount", total_Amount);
				mav.addObject("totalAmountAfterDiscount", totalAmountAfterDiscount);
			} 
			else{
				mav = new ModelAndView("cart");
				mav.addObject("list", "Cart is Empty");
			}
		}
		return mav;
	}*/
	
	
	/*@RequestMapping(value = "/deleteItemFromCart/{productid}", method = RequestMethod.GET)*/
	@RequestMapping(value = {"/deleteItemFromCart"}, method = {RequestMethod.GET})
	/*public ModelAndView deleteItemFromCart(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("mailid") String mailid,@PathVariable(value = "productid") String productid) {*/
	public ModelAndView deleteItemFromCart(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model model, @RequestParam("product_id") String productid){
		
		 ModelAndView mav = null;
		 System.out.println("Iam outside getqttribute");
		 if (session.getAttribute("mailid") == null) {
		     System.out.println("Iam inside getattribute");
		      
		     mav = new ModelAndView("login");
		 } else {
			String mailid = (String)session.getAttribute("mailid");
		    model.addAttribute("mailid", mailid);
			System.out.println("saket I am inside delete Item from cart");
			String cartProductIds ="";
			int total_Amount =0;
			int totalAmountAfterDiscount =0;
			String itemStatus="delete";
			ProductDB productdb=productservice.getProductById(productid);
			List<ProductDB> productdbList = new ArrayList<ProductDB>();
			int product_cost=productdb.getProduct_cost();
			Cart cart = productservice.deleteCartItem(mailid,productid,product_cost);
			if (cart != null) {
				cartProductIds = cart.getProduct_ids();
				total_Amount = cart.getTotal_amount();
				StringTokenizer st = new StringTokenizer(cartProductIds, ",");
				while(st.hasMoreTokens())
				{
					String id= st.nextToken();
					ProductDB productdb2 = productservice.getProductById(id);
					System.out.println("After delete - "+productdb2.toString());
					productdbList.add(productdb2);
					
				}
				totalAmountAfterDiscount = total_Amount -(215+621);
				mav = new ModelAndView("cart");
				mav.addObject("list", productdbList);
				mav.addObject("total_Amount", total_Amount);
				mav.addObject("totalAmountAfterDiscount", totalAmountAfterDiscount);
			} 
			else{
				mav = new ModelAndView("Msg");
				mav.addObject("msg", "Cart is Empty");
			}
		 }
		return mav;
	}
	
	
	
	/*@RequestMapping(value = "deleteItemFromCart/deleteItemFromCart/{productid}", method = RequestMethod.GET)
	public ModelAndView deleteMultipleItemFromCart(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("mailid") String mailid,@PathVariable(value = "productid") String productid) {
		
		System.out.println("saket I am inside delete Item from cart");
		String cartProductIds ="";
		int total_Amount =0;
		int totalAmountAfterDiscount =0;
		ModelAndView mav = null;
		String itemStatus="delete";
		ProductDB productdb=productservice.getProductById(productid);
		List<ProductDB> productdbList = new ArrayList<ProductDB>();
		int product_cost=productdb.getProduct_cost();
		Cart cart = productservice.deleteCartItem(mailid,productid,product_cost);
		if (cart != null) {
			cartProductIds = cart.getProduct_ids();
			total_Amount = cart.getTotal_amount();
			StringTokenizer st = new StringTokenizer(cartProductIds, ",");
			while(st.hasMoreTokens())
			{
				String id= st.nextToken();
				ProductDB productdb2 = productservice.getProductById(id);
				productdbList.add(productdb2);
				
			}
			totalAmountAfterDiscount = total_Amount -(215+621);
			mav = new ModelAndView("cart");
			mav.addObject("list", productdbList);
			mav.addObject("total_Amount", total_Amount);
			mav.addObject("totalAmountAfterDiscount", totalAmountAfterDiscount);
		} 
		else{
			mav = new ModelAndView("cart");
			mav.addObject("list", "Cart is Empty");
		}
		return mav;
	}*/
	
	
	
	
}
