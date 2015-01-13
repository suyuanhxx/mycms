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
	
	public int getMaxId(){
		return articleMapper.selectLastInsertId().intValue();
	}
	
	public Article selectByPrimaryKey(Integer id){
		return articleMapper.selectByPrimaryKey(id);
	}
	
	public List<Article> selectLastArticle(){
		return articleMapper.selectLastArticle();
	}
	
	public List<Article> selectByUserId(Integer id){
		return articleMapper.selectByUserId(id);
	}
	
	public boolean insert(Article record){
		int p = articleMapper.insert(record);
		if(p==1)return true;
		return false;
	}

}
