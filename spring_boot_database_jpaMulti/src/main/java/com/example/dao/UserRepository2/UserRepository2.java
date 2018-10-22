package com.example.dao.UserRepository2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepository2 extends JpaRepository<User, Long>  {
	User findByUserName(String userName);
}
