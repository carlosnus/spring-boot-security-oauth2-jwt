package com.mnietov.springbootsecurityoauth2jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mnietov.springbootsecurityoauth2jwt.domain.RandomCity;
import com.mnietov.springbootsecurityoauth2jwt.domain.User;
import com.mnietov.springbootsecurityoauth2jwt.service.GenericService;

@RestController
public class ApplicationController {
	
	@Autowired
    private GenericService userService;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<RandomCity> getUser(){
        return userService.findAllRandomCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}	

}
