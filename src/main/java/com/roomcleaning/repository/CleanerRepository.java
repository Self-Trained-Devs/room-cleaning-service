package com.roomcleaning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roomcleaning.model.CleanerRegistrationForm;
@Repository
public interface CleanerRepository extends CrudRepository<CleanerRegistrationForm, Integer>{

}
