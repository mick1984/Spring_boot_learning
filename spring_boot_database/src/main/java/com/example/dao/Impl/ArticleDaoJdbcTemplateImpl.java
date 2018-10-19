package com.example.dao.Impl;

import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.ArticleDao;
import com.example.model.Article;

@Repository
public class ArticleDaoJdbcTemplateImpl implements ArticleDao {
 
    @Autowired  /*关键字@Autowired表示自动注入*/
    private NamedParameterJdbcTemplate jdbcTemplate;
 
    @Override
    public Long insertArticle(Article article) {
        String sql = "insert into tb_article(title,summary,create_time,public_time,update_time,status,type) " +
                "values(:title,:summary,:createTime,:publicTime,:updateTime,:status,:type)";
        Map<String, Object> param = new HashMap<>();
        param.put("title", article.getTitle());
        param.put("summary", article.getSummary());
        //param.put("userId", article.getUserId());
        param.put("status", article.getStatus());
        param.put("createTime", article.getCreateTime());
        param.put("publicTime", article.getPublicTime());
        param.put("updateTime", article.getUpdateTime());
        param.put("type", 1);
        return (long) jdbcTemplate.update(sql, param);              
        
    }

	@Override
	public Article getArticle(String title) {
		// TODO Auto-generated method stub	
		String sql="select * from tb_article t  where t.title= :title ";	
		
//		Object[] param=
//			{
//					"测试"
//			};
		
		Map<String,Object> param = new HashMap<>();
		param.put("title", title);
		
		List<Article> list = jdbcTemplate.query(sql,param,new RowMapper<Article>()
				{
			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Article a = new Article();
				a.setTitle(rs.getString("title"));
				
				return a;
			}
				});
		
		Article article = new Article();
		
		if(list.size()>0)
			article = list.get(0);
		else article.setTitle("暂缺");
		
		return article;
	}
    
    
}