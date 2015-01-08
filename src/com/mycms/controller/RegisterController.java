package com.mycms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycms.model.User;
import com.mycms.service.UserService;


@Controller
public class RegisterController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/register")
	public String register(HttpServletRequest request, HttpServletResponse response){
		User vo=new User();
		vo.setUsername(request.getParameter("username"));
		vo.setPwd(request.getParameter("password"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setUseremail(request.getParameter("email"));
		if(userService.insertUser(vo)){
			return "index.html";
		}
		else
			return "error";
	}

}
