package com.iconectiv.repository;

import org.springframework.data.repository.CrudRepository;

import com.iconectiv.modelo.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
