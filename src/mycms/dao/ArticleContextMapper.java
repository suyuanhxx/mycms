package mycms.dao;

import mycms.model.ArticleContext;

public interface ArticleContextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContext record);

    int insertSelective(ArticleContext record);

    ArticleContext selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleContext record);

    int updateByPrimaryKeyWithBLOBs(ArticleContext record);

    int updateByPrimaryKey(ArticleContext record);
}