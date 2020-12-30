package com.mnietov.springbootsecurityoauth2jwt.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mnietov.springbootsecurityoauth2jwt.domain.Role;
import com.mnietov.springbootsecurityoauth2jwt.domain.User;
import com.mnietov.springbootsecurityoauth2jwt.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	
    	
    	// PRUEBAS MARC
    	Iterable<User> users = userRepository.findAll();
    	for (User user : users) {
    		System.out.println(user.getUsername());
    		System.out.println(user.getPassword());
		}    	
    	// FIN PRUEBAS MARC    	
    	
    	
        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

}
