package com.mnietov.springbootsecurityoauth2jwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnietov.springbootsecurityoauth2jwt.domain.RandomCity;
import com.mnietov.springbootsecurityoauth2jwt.domain.User;
import com.mnietov.springbootsecurityoauth2jwt.repository.RandomCityRepository;
import com.mnietov.springbootsecurityoauth2jwt.repository.UserRepository;
import com.mnietov.springbootsecurityoauth2jwt.service.GenericService;

@Service
public class GenericServiceImpl implements GenericService {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomCityRepository randomCityRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<RandomCity> findAllRandomCities() {
        return (List<RandomCity>)randomCityRepository.findAll();
    }

}
