package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
	@Autowired
	HttpSession session;

	@Autowired
	ServletContext application;

	@RequestMapping("")
	public String index() {
		List<Item> allItems = new LinkedList<>();
		Item item;
		item = new Item("手帳ノート", 1000);
		allItems.add(item);
		item = new Item("文房具セット", 1500);
		allItems.add(item);
		item = new Item("ファイル", 2000);
		allItems.add(item);
		application.setAttribute("allItems", allItems);

		List<Item> itemInCartList = new LinkedList<>();
		session.setAttribute("itemInCartList", itemInCartList);
		session.setAttribute("sumPrice", 0);

		return "item-and-cart";
	}

	@RequestMapping("/add-cart")
	public String addCart(Integer index) {
		System.out.println(index);
		@SuppressWarnings("unchecked")
		List<Item> itemInCartList = (List<Item>) session.getAttribute("itemInCartList");
		@SuppressWarnings("unchecked")
		List<Item> allItems = (List<Item>) application.getAttribute("allItems");
		itemInCartList.add(allItems.get(index - 1));
		System.out.println(itemInCartList.toString());
		session.setAttribute("itemInCartList", itemInCartList);
		int sumPrice = 0;
		for (Item item : itemInCartList) {
			sumPrice += item.getPrice();
		}
		session.setAttribute("sumPrice", sumPrice);
		return "item-and-cart";
	}

	@RequestMapping("/delete-cart")
	public String deleteCart(int index) {
		System.out.println("remove : " + index);
		@SuppressWarnings("unchecked")
		List<Item> itemInCartList = (List<Item>) session.getAttribute("itemInCartList");
		itemInCartList.remove(index - 1);
		int sumPrice = 0;
		for (Item item : itemInCartList) {
			sumPrice += item.getPrice();
		}

		session.setAttribute("itemInCartList", itemInCartList);
		session.setAttribute("sumPrice", sumPrice);
		return "item-and-cart";
	}

}
