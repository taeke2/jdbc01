package com.care.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.jdbc_dao.JdbcDAO;
import com.care.jdbc_dto.JdbcDTO;

public class JdbcConetentServiceImpl implements JdbcService{

	@Override
	public void execute(Model model) {
		JdbcDAO dao = new JdbcDAO();
		ArrayList<JdbcDTO> list = dao.list();
		model.addAttribute("list", list);
		//model.addAttribute("list", dao.list);	//한줄로 가능
		model.addAttribute("count", dao.count());
	}
	
}
