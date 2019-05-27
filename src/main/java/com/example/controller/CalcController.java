package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("")
	public String index() {
		return "input-value";
	}
	
	@RequestMapping("/calclate")
	public String calc(Integer num1,Integer num2) {
		
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", num1*num2);
		
		return "output-value";
	}
	
	@RequestMapping("/output-value1")
	public String outputValue() {
		return "output-value";
	}

	@RequestMapping("/output-value2")
	public String outputValue2() {
		return "output-value2";
	}	
	
}
