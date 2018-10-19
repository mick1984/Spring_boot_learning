package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.*;
import com.example.dao.Impl.*;
import com.example.model.*;

@RestController
public class HelloWorldController {

	@Autowired
	private ArticleDaoJdbcTemplateImpl dao;
	
	@RequestMapping("/hello")    
    public String index() { 		
		dao = new ArticleDaoJdbcTemplateImpl();
		Article data = dao.getArticle("测试");
        return data.getTitle();
		
		//return "string";
    }
}
