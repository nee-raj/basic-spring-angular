package org.chikoo.rest.web.controller;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService ;
	
	@RequestMapping("/rest/blog/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable long id) {
		Blog blog =  blogService.find(id);
		return new ResponseEntity<Blog>( blog, HttpStatus.OK);
	}

	

}
