package com.mycms.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.mycms.model.Admin;
import com.mycms.model.User;
import com.mycms.service.AdminService;
import com.mycms.service.UserService;

@Controller
@SessionAttributes("user_session")
public class LoginController extends BaseController{

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Admin vo=adminService.selectByUsername(username);
		ModelAndView mav =null;
		if(vo!=null)
		{
			if(password.equals(vo.getPwd()))
			{
				mav = new ModelAndView(new RedirectView("./admin/admin.jsp"));
				mav.addObject("user_session",vo);
				logininfo.put("user_session", vo);
			}
			else
			{
				mav = new ModelAndView("login.jsp");
				mav.addObject("loginmsg","密码错误");
			}
		}
		else
		{
			User user = us.selectByUsername(username);
			if( user!=null && password.equals( user.getPwd() ) )
			{
				mav = new ModelAndView(new RedirectView("./loginindex.jsp"));
				mav.addObject("user_session",user);
				logininfo.put("user_session", vo);
			}
			else
			{
				mav = new ModelAndView("login.jsp");
				mav.addObject("loginmsg","密码错误");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="loginout")
	@ModelAttribute("user_session")
	public ModelAndView loginout(HttpServletRequest request, HttpServletResponse response){
//		Object obj = request.getSession().getAttribute("user_session");
		Enumeration<String> em = request.getSession().getAttributeNames();
        while (em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        request.getSession().removeAttribute("user_session");
        request.getSession().invalidate();
		return new ModelAndView(new RedirectView("index.html"));
	}
	
}
