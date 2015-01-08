package com.mycms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycms.dao.ArticleMapper;
import com.mycms.model.Article;


@Service("articleService")
public class ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	public Article selectByPrimaryKey(Integer id){
		return articleMapper.selectByPrimaryKey(id);
	}
	
	public List selectLaestArticle(){
		return articleMapper.selectLastArticle();
	}

}
