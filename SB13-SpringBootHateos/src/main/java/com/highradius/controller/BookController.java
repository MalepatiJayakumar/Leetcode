package com.highradius.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.dto.BookDTO;

@RestController
@RequestMapping("/book")
public class BookController {

	@RequestMapping(value="/get-hibernate" , method= RequestMethod.GET)
	public ResponseEntity<BookDTO> getHibernateBook(){
		BookDTO bookDTO = new BookDTO("hibernate","jaikumar");
		Link link =WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("get-all-books");
		bookDTO.add(link);
		return new ResponseEntity<BookDTO>(bookDTO,HttpStatus.OK);
	}

	@RequestMapping(value = "/get-all-books", method = RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		BookDTO book1 = new BookDTO("spring", "RodJohnson");
		BookDTO book2 = new BookDTO("Spring Boot", "David");
		BookDTO book3 = new BookDTO("Core Java", "Sun");
		return new ResponseEntity<>(Arrays.asList(book1, book2, book3), HttpStatus.OK);
	}

}