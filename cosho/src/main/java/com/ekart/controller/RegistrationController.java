package com.ekart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ekart.model.User;
import com.ekart.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/signUp", method= RequestMethod.GET)
	public ModelAndView showregister(HttpServletRequest req,  HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("signUp");
		mav.addObject("user", new User());
		
		return mav;
	}
	
	@RequestMapping(value="/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req ,HttpServletResponse resp, @ModelAttribute("user") User user )
	{
		userService.register(user);
		
		/*return new ModelAndView("welcome","firstname", user.getUserName());*/
		
		return new ModelAndView("login");
	}

}
