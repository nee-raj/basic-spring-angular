package org.chikoo.rest.web.controller;

import javax.inject.Inject;

import org.chikoo.core.entity.BlogEntry;
import org.chikoo.core.service.BlogEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BlogEntryController {

	@Inject
	private BlogEntryService blogEntryService;

	public ResponseEntity<BlogEntry> getBlogEntryResultsById(Long id) {
		BlogEntry blogEntry = blogEntryService.findBlogEntry(id);
		return new ResponseEntity<BlogEntry>(blogEntry, HttpStatus.OK);
	}

}
