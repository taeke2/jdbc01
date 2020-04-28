package com.care.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.service.JdbcConetentServiceImpl;
import com.care.service.JdbcDeleteServiceImpl;
import com.care.service.JdbcModifySaveServiceImpl;
import com.care.service.JdbcModifyServiceImpl;
import com.care.service.JdbcSaveServiceImpl;
import com.care.service.JdbcService;
import com.care.template.Constant;

@Controller
public class MemberController {
	private JdbcService jdbc;

	public MemberController(){
		System.out.println("자동으로 실행됩니다.");
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	
	@RequestMapping("content")
	public String content(Model model) {
		jdbc = new JdbcConetentServiceImpl();
		jdbc.execute(model);
		return "content";
	}

	@RequestMapping("save_view")
	public String save_view() {
		return "save_view";
	}

	@RequestMapping("save")
	public String save(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new JdbcSaveServiceImpl();
		jdbc.execute(model);
		return "redirect:content";
	}

	@RequestMapping("modify")
	public String modify(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new JdbcModifyServiceImpl();
		jdbc.execute(model);
		return "modify";
	}

	@RequestMapping("modifySave")
	public String modifySave(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new JdbcModifySaveServiceImpl();
		jdbc.execute(model);
		return "redirect:content";
	}

	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new JdbcDeleteServiceImpl();
		jdbc.execute(model);
		return "redirect:content";
	}
}
