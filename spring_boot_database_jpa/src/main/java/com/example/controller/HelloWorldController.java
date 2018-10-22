package com.example.controller;

import com.example.dao.*;
import com.example.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private UserRepository userRespo;
	
	@RequestMapping("/hello")    
    public User index(String userName) { 		
		User data =userRespo.findByUserName(userName);
		
		if(data==null)
			data =new User();
		
        return data;
		        
		//return "string";
    }
	
	@RequestMapping("/insert")    
	public User insert(String userName)
	{
		User data = new User();
		data.setEmail(userName+"@abc.com");
		data.setNickName(userName);
		data.setPassWord("123");
		data.setRegTime("2018-10-22");
		data.setUserName(userName);
				
		data = this.userRespo.save(data);
		
//		if(result>0)
//			return "插入成功";
//		else return "插入失败";
		
		return data;
	}
}
