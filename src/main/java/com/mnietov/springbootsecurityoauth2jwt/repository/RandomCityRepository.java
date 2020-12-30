package com.mnietov.springbootsecurityoauth2jwt.repository;


import org.springframework.data.repository.CrudRepository;
import com.mnietov.springbootsecurityoauth2jwt.domain.RandomCity;

public interface RandomCityRepository extends CrudRepository<RandomCity, Long> {

}
