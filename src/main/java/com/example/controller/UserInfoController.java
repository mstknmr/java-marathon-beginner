package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;

@Controller
@RequestMapping("/inputuserinfo")
public class UserInfoController {
	@RequestMapping("")
	public String index() {
		return "input-user-info";
	}

	@RequestMapping("/outputuserinfo")
	public String OutputInfo(Model model, String name, Integer age, String address) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setAddress(address);
		model.addAttribute("user", user);
		return "output-user-info";
	}
}
