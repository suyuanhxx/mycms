package com.mycms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycms.dao.ArticleContextMapper;
import com.mycms.model.ArticleContext;
import com.mycms.util.web.HandlerResult;


@Service("articleContextService")
public class ArticleContextService {
	
	@Autowired
	private ArticleContextMapper articleContextMapper;
	
	public ArticleContext selectArticleContext(int id){
		Integer a = new Integer(id);
		return articleContextMapper.selectByTitleId(a);
	}
	
	public List<ArticleContext> searchByKey(String key){
		return articleContextMapper.searchByKey(key);
	}
	
	public HandlerResult searchByKeyPagination(String key){
		HandlerResult rs = new HandlerResult();
		rs.setResultObj(articleContextMapper.searchByKey(key));
		return rs;
	}
}
