package com.example.controller;

import com.example.dao.UserRepository.*;
import com.example.dao.UserRepository2.*;
import com.example.model.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	@Resource
	private UserRepository userRespo;
	
	@Autowired
	@Resource
	private UserRepository2 userRespo2;
	
	@RequestMapping("/hello")    
    public User index(String userName) { 		
		User data =userRespo.findByUserName(userName);
		
		if(data==null)
			data =new User();
		
        return data;
		        
		//return "string";
    }
	
	@RequestMapping("/hello2")    
    public User index2(String userName) { 		
		User data =userRespo2.findByUserName(userName);
		
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
		
		return data;
	}
	
	@RequestMapping("/insert2")    
	public User insert2(String userName)
	{
		User data = new User();
		data.setEmail(userName+"@abc.com");
		data.setNickName(userName);
		data.setPassWord("123");
		data.setRegTime("2018-10-22");
		data.setUserName(userName);
				
		data = this.userRespo2.save(data);
		
		return data;
	}
}
