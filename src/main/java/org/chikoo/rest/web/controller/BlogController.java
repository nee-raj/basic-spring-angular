package org.chikoo.rest.web.controller;

import javax.inject.Inject;

import org.chikoo.core.entity.Blog;
import org.chikoo.core.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BlogController {
	
	@Inject
	private BlogService blogService ;
	
	public ResponseEntity<Blog> getBlogById(Long id) {
		Blog blog =  blogService.find(id);
		return new ResponseEntity<Blog>( blog, HttpStatus.OK);
	}

	

}
