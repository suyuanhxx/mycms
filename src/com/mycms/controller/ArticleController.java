package com.mycms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycms.dao.ArticleMapper;
import com.mycms.model.Article;
import com.mycms.model.ArticleContext;
import com.mycms.service.ArticleContextService;


@Controller
public class ArticleController extends BaseController{
	
	@Autowired
	private ArticleMapper articleService;
	
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

}
