package mycms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycms.model.Admin;
import mycms.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private AdminService adminService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		Admin vo=adminService.selectByUsername(username);
		if(password.equals(vo.getPwd()))
		{
			map.put("admin", vo);
			return "index";
		}
		else
			return "error";
	}
	
	
}
