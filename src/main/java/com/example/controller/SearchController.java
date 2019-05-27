package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.UserRepository;

@Controller
@RequestMapping("search")
public class SearchController {
	@Autowired
	private UserRepository repository;
	
	@RequestMapping("")
	public String index() {
		return "user-info-search";
	}
	
	@RequestMapping("/user-info-view")
	public String search(Model model,Integer id) {
		model.addAttribute("user", repository.load(id));
		return "user-info-view";
	}
}
