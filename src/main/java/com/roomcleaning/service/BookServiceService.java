package com.roomcleaning.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomcleaning.model.BookService;
import com.roomcleaning.repository.BookServiceRepository;

@Service
public class BookServiceService {
	@Autowired
	private BookServiceRepository bookServiceRepository;
	
	public void saveBookService(BookService bookService) {
		bookServiceRepository.save(bookService);
	}
	
	public List<BookService> getAllBookService(String userName) {
		List<BookService> bookServiceList = new ArrayList<>();
		bookServiceRepository.findAll().forEach(bookServiceList::add);
		List<BookService> userBookServiceList = new ArrayList<>();
		Iterator itr = bookServiceList.iterator();
		while(itr.hasNext()) {
			BookService userBookservice = (BookService) itr.next();
			if(userBookservice.getUserName().contentEquals(userName))
				userBookServiceList.add(userBookservice);
		}
		return userBookServiceList;

	}
	
	public List<BookService> getAllBookServiceForAdmin() {
		List<BookService> bookServiceList = new ArrayList<>();
		bookServiceRepository.findAll().forEach(bookServiceList::add);
		return bookServiceList;

	}
	
	public Optional<BookService> getBookServiceById(int serviceId) {
		Optional<BookService> userBookservice = bookServiceRepository.findById(serviceId);
		return userBookservice;
	}
}
