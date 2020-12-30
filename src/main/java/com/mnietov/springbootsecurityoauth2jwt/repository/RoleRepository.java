package com.mnietov.springbootsecurityoauth2jwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.mnietov.springbootsecurityoauth2jwt.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
