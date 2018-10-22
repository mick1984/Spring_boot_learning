package com.example.dao;

import com.example.model.Article;

//ArticleDao接口
public interface ArticleDao {
	Long insertArticle(Article article);
	
	Article getArticle(String title);
	
	Article getArticle2(String title);
}

