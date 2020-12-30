package com.mnietov.springbootsecurityoauth2jwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.mnietov.springbootsecurityoauth2jwt.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
