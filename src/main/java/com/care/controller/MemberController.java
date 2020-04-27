package com.care.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.service.JdbcConetentServiceImpl;
import com.care.service.JdbcService;

@Controller
public class MemberController {
	private JdbcService jdbc;
	@RequestMapping("content")
	public String content(Model model) {
		jdbc = new JdbcConetentServiceImpl();
		jdbc.execute(model);
		return "content";
	}
}
