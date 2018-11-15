package com.example.mapper.test1;

import java.util.List;
import com.example.model.User;

public interface User1Mapper {

	List<User> getAll();
	
	User getOne(String userName);
	
	void insert(User data);
	
	void update(User data);
	
	void delete(Long id);
}
