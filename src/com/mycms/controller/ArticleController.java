package com.mycms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycms.model.Admin;
import com.mycms.model.Article;
import com.mycms.model.ArticleContext;
import com.mycms.model.User;
import com.mycms.service.ArticleContextService;
import com.mycms.service.ArticleService;


@Controller
public class ArticleController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleContextService articleContextService;
	
	@RequestMapping(value="/latest")
	public ModelAndView getLatestArticle(){
		ModelAndView mav = null;
		List<Article> list=articleService.selectLastArticle();
		if(list!=null){
			mav = new ModelAndView("latestarticle.jsp");
			mav.addObject("latest",list);
		}
		return mav;
	}
	
	@RequestMapping(value="/articledetail")
	@ResponseBody
	public ModelAndView getArticledetail(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = null;
		int id = Integer.parseInt(request.getParameter("articleid")) ;
		try{
			Article ar = articleService.selectByPrimaryKey(id);
			ArticleContext article = articleContextService.selectArticleContext(id);
			if(article!=null){
				mav = new ModelAndView("articledetail.jsp");
				mav.addObject("articledetail",article);
				mav.addObject("article", ar);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/addarticle")
	@ModelAttribute("user_session")
	public void addArticle(HttpServletRequest request, HttpServletResponse response, Article article , ArticleContext articlecontext){
		ModelAndView mav = null;
		Admin obj = (Admin)logininfo.get("user_session");
		Date date = new Date();
		article.setPubtime(date);
		article.setUserid(obj.getId());
		article.setUsername(obj.getUsername());
		if(articleService.insert(article))
		{
			int articleid = articleService.getMaxId();
			articlecontext.setTitleid(articleid);
			articleContextService.insert(articlecontext);
		}
	}
	
	@RequestMapping(value="/myarticle")
	@ModelAttribute("user_session")
	public ModelAndView getArticleByUserId(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = null;
		Object obj = request.getSession().getAttribute("user_session");
		List<Article> articlelist = null;
		Class<?> superClass = obj.getClass();
		if(superClass.getName()=="Admin"){
			articlelist = articleService.selectByUserId( ((Admin)obj).getId() );
		}
		if(superClass.getName()=="User"){
			articlelist = articleService.selectByUserId( ((User)obj).getId() );
		}
		if(articlelist!=null){
			mav = new ModelAndView("myarticle.jsp");
			mav.addObject("myarticlelist",articlelist);
		}
		return null;
	}
	
}
