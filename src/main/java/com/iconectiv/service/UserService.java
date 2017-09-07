package com.iconectiv.service;

import java.util.List;

import com.iconectiv.modelo.User;

public interface UserService {
	
	User findById(Long id);
	
	User findByUsername(String username);
	
	List<User> findAllUsers();
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(Long id);
	
	boolean isUserExist(User user);
}
