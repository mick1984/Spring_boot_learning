package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.*;

public interface UserRepository extends JpaRepository<User, Long>  {
	User findByUserName(String userName);
}
