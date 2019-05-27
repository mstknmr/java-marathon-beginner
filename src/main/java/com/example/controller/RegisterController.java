package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "buy-goods";
	}
	
	@RequestMapping("/total-price")
	public String totalPrice(Integer goods1,Integer goods2,Integer goods3) {
		
		application.setAttribute("outTax", goods1+goods2+goods3);
		application.setAttribute("inTax", (goods1+goods2+goods3)*1.08);
		
		return "total-price";
	}
}
