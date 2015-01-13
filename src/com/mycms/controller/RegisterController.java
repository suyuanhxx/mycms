package com.mycms.controller;

import java.io.PrintWriter;

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
	
	@RequestMapping(value="/checkusername")
	public boolean checkusername(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean result = false;
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<message>");

			String old = request.getParameter("username");
			if (old != null) {
				User userd= userService.selectByUsername(old);
				if (userd==null) {
					out.println("<usernamemes>"
							+ "用户名已存在"
							+ "</usernamemes>");
					result = true;
				} else {
					out.println("<usernamemes>"
							+ "username not exist,you can use it"
							+ "</usernamemes>");
					result = false;
				}
			} else {
				out.println("<usernamemes>" + "username is required"
						+ "</usernamemes>");
				result = false;
			}
			out.println("</message>");
			out.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
