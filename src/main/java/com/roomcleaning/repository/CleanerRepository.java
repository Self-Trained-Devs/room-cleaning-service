package com.roomcleaning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roomcleaning.model.BookService;
import com.roomcleaning.model.CleanerRegistrationForm;
@Repository
public interface CleanerRepository extends CrudRepository<CleanerRegistrationForm, Integer>{
	
	@Query("SELECT s FROM BookService s WHERE s.cleanerId = ?1")
	List<BookService> getcleanerAssinedServices(String cleanerId);
}
