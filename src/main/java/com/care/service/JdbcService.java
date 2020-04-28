package com.care.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface JdbcService {
	public void execute(Model model);
}
