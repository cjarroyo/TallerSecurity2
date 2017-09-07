package com.iconectiv.repository;

import org.springframework.data.repository.CrudRepository;

import com.iconectiv.modelo.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	Role findByName(String role);
}
