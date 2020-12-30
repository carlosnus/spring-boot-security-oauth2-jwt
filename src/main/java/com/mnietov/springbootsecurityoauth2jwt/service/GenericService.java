package com.mnietov.springbootsecurityoauth2jwt.service;

import java.util.List;

import com.mnietov.springbootsecurityoauth2jwt.domain.RandomCity;
import com.mnietov.springbootsecurityoauth2jwt.domain.User;

public interface GenericService {
	
	User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();

}
