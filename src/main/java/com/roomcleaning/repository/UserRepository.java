package com.roomcleaning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roomcleaning.model.UserRegistrationForm;
@Repository
public interface UserRepository extends CrudRepository<UserRegistrationForm, Integer>{

}
