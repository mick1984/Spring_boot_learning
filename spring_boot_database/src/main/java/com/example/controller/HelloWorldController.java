package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.*;
import com.example.model.*;
import java.util.Date;

@RestController
public class HelloWorldController {

	@Autowired
	private ArticleDao dao;
	
	@RequestMapping("/hello")    
    public String index() { 		
		//dao = new ArticleDaoJdbcTemplateImpl();
		Article data = dao.getArticle("测试");
        return data.getTitle();
		
		//return "string";
    }
	
	@RequestMapping("/insert")    
	public String insert()
	{
		Article data = new Article();
		data.setCreateTime(new Date());
		data.setPublicTime(new Date());
		data.setStatus(0);
		data.setSummary("备注");
		data.setTitle("测试插入");
		data.setType(1);
		data.setUpdateTime(new Date());
		
		Long result = dao.insertArticle(data);
		if(result>0)
			return "插入成功";
		else return "插入失败";
		
		
	}
}
