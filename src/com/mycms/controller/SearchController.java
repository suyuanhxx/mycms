package com.mycms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.mycms.page.Page;
import com.mycms.page.PageContext;
import com.mycms.service.AdminService;
import com.mycms.service.ArticleContextService;
import com.mycms.service.ArticleService;
import com.mycms.service.UserService;
import com.mycms.util.web.HandlerResult;
import com.sun.org.apache.bcel.internal.generic.NEW;


@Controller
public class SearchController extends BaseController{
	
	@Autowired
	private ArticleService as;
	@Autowired
	private ArticleContextService acs;
	@Autowired
	private AdminService admins;
	@Autowired
	private UserService us;
	
	private Page statePage = null;
	
	public Page getStatePage() {
		return statePage;
	}

	public void setStatePage(Page statePage) {
		this.statePage = statePage;
	}
	
//	@RequestMapping(value="/allsearch")
//	public ModelAndView search(HttpServletRequest request, HttpServletResponse response){
//		ModelAndView mav = null;
//		int page = Integer.parseInt(request.getParameter("page"));
//		String key = request.getParameter("key");
//		try{
//			pagination.setCurrentPage(page);
//			List<ArticleContext> list = acs.searchByKey(key);
//			if(list!=null)
//			{
//				mav = new ModelAndView("searchresult.jsp");
//				mav.addObject("searchlist",list);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return mav;
//	}
	
	@RequestMapping(value="/allsearch")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) 
	{
		//可以将分页参数获取封装，已达到更好的复用效果。
		//page=2&pageSize=10&totalPages=19&totalRows=188
		String key = request.getParameter("key");
		String pagec = request.getParameter("page"); 
//		String pageSize = request.getParameter("pageSize"); 
//		String totalPage = request.getParameter("totalPage"); 
//		String totalRows = request.getParameter("totalRows");
		
		//方法1：将分页参数直接放到mapper接口函数参数中，也可在对象中定义名字为page的属性，反射一样可以得到
		//后台连接直接获取
		//Page page = new Page();
		
		//方法2：不用进行map传参，用ThreadLocal进行传参,方便没有侵入性
		PageContext page = PageContext.getContext();
		//请自行验证
		if(null == pagec)
		{
			page.setCurrentPage(1);
			page.setPageSize(10);
			page.getParam().put("FuzzyQuery", key);
		}
		else{
			page.setCurrentPage(Integer.parseInt(pagec));
			if(statePage!=null)
			{
				page.setPageSize(statePage.getPageSize());
				page.setTotalPage(statePage.getTotalPage());
				page.setTotalRows(statePage.getTotalRows());
				key = (String)statePage.getParam().get("FuzzyQuery");
			}
		}
		page.setPagination(true);

//		方法1用
//		Map map = new HashMap();
//		map.put("page", page);
//		HandlerResult rs = userService.list(map);
		
		//方法2用
		HandlerResult rs = acs.searchByKeyPagination(key);
		ModelAndView mv = new ModelAndView("showresult.jsp");
		mv.addObject("resultlist", rs.getResultObj());
		mv.addObject("pagination",page);
		statePage = page;
		return mv;
	}
}
