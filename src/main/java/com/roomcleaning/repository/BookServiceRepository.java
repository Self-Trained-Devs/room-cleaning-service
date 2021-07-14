package com.roomcleaning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roomcleaning.model.BookService;

@Repository
public interface BookServiceRepository extends CrudRepository<BookService, Integer>{
	
}
