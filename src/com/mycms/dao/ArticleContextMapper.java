package com.mycms.dao;

import java.util.List;
import java.util.Map;

import com.mycms.model.ArticleContext;


public interface ArticleContextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContext record);

    int insertSelective(ArticleContext record);

    ArticleContext selectByPrimaryKey(Integer id);
    
    ArticleContext selectByTitleId(Integer id);

    int updateByPrimaryKeySelective(ArticleContext record);

    int updateByPrimaryKeyWithBLOBs(ArticleContext record);

    int updateByPrimaryKey(ArticleContext record);
    
    List<ArticleContext> searchByKey(String key);
}