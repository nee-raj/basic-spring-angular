package org.chikoo.rest.web.controller;

import javax.inject.Inject;

import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.service.BlogEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BlogEntryController {

	@Inject
	private BlogEntryService blogEntryService;

	@RequestMapping("/rest/blogEntry/")
	public ResponseEntity<BlogEntry> getBlogEntryResultsById(Long id) {
		BlogEntry blogEntry = blogEntryService.findBlogEntry(id);
		return new ResponseEntity<BlogEntry>(blogEntry, HttpStatus.OK);
	}

}
