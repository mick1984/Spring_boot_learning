package com.example.dao.Impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.ArticleDao;
import com.example.model.Article;

@Repository
public class ArticleDaoJdbcTemplateImpl implements ArticleDao {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Override
    public Long insertArticle(Article article) {
        String sql = "insert into tb_article(title,summary,user_id,create_time,public_time,update_time,status) " +
                "values(:title,:summary,:userId,:createTime,:publicTime,:updateTime,:status)";
        Map<String, Object> param = new HashMap<>();
        param.put("title", article.getTitle());
        param.put("summary", article.getSummary());
        param.put("userId", article.getUserId());
        param.put("status", article.getStatus());
        param.put("createTime", article.getCreateTime());
        param.put("publicTime", article.getPublicTime());
        param.put("updateTime", article.getUpdateTime());
        return (long) jdbcTemplate.update(sql, param);
    }

	@Override
	public Article getArticle(String title) {
		// TODO Auto-generated method stub
		

		String sql="select * from tb_article t where t.title=:title";
		
		Map<String, Object> param = new HashMap<>();
		param.put("title", title);
		
		List<Map<String,Object>> list =  jdbcTemplate.queryForList(sql, param);
		
		Article article = new Article();
		
		for(Map<String,Object> map : list)
		{
			article.setTitle(map.get("title").toString());
		}	
		
		return article;
	}
    
    
}