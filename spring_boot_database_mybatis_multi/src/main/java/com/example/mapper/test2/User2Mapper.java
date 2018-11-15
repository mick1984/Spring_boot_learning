package com.example.mapper.test2;

import java.util.List;
import com.example.model.User;

public interface User2Mapper {
	List<User> getAll();
	
	User getOne(String userName);
	
	void insert(User data);
	
	void update(User data);
	
	void delete(Long id);
}
