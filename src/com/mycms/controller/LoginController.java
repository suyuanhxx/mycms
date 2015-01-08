package com.mycms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycms.model.Admin;
import com.mycms.service.AdminService;

@Controller
public class LoginController extends BaseController{

	private AdminService adminService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Admin vo=adminService.selectByUsername(username);
		if(password.equals(vo.getPwd()))
		{
			session.put("admin", vo);
			return "redirect:./admin/index.html";
		}
		else
			return "error";
	}
	
	
}
