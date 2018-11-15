package com.example.mapper;

import java.util.List;
import com.example.model.User;

public interface UserMapper {

	List<User> getAll();
	
	User getOne(String userName);
	
	void insert(User data);
	
	void update(User data);
	
	void delete(Long id);
}
