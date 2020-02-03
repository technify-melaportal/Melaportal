package com.beerrun.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MasterController {
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("login-page");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
}
