package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inputname")
public class NameReceiveController {
	@RequestMapping("")
	public String index() {
		return "input-name";
	}

	@RequestMapping("/outputname")
	public String outputName(String name, Model model) {
		model.addAttribute("name", name);
		return "output-name";
	}
}
