package com.ekart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ekart.model.Login;
import com.ekart.model.User;
import com.ekart.service.UserService;

@Controller
@SessionAttributes({"mailid","user_name"})
public class loginController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/logout"}, method={RequestMethod.GET})
	  public ModelAndView userlogout(HttpServletRequest req, HttpServletResponse res, HttpSession session)
	  {
	    ModelAndView mav = null;
	    String mailid = null;
	    String user_name=(String) req.getAttribute("user_name");
	    session.removeAttribute("mailid");System.out.println("session attribute removed");
	    session.removeAttribute("user_name");
	    session.invalidate();
	    
	    mav = new ModelAndView("home");
	    mav.addObject("mailid", mailid);
	    mav.addObject("user_name", user_name);
	    return mav;
	  }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userlogin(HttpServletRequest req , HttpServletResponse res,@ModelAttribute("login") Login login)
	{
		
		ModelAndView mav = null;
		
		User user = userService.validateUser(login);
		
		if(user != null)
		{
			mav = new ModelAndView("home");
			mav.addObject("mailid",user.getMailID());
			mav.addObject("user_name", user.getUserName());
		}
		else
		{
			mav = new ModelAndView("login");
			mav.addObject("message", "Wrong Credentials !");
		}
		
		
		return mav;
	}
	
	
	
	
	
}
