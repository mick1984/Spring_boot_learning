package com.example.controller;

import com.example.dao.*;
import com.example.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
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
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		List<User> users = userRespo.findAll();
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@RequestMapping("/toEdit")
	public String toEdit(Model model,Long id)
	{
		User data = userRespo.getOne(id);
		model.addAttribute("user",data);
		
		return "user/userEdit";
	}
	
	@RequestMapping("/edit")
	public String edit(User user)
	{
		userRespo.save(user);
		
		return "redirect:/list";
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
