package org.chikoo.rest.web.controller;

import java.lang.invoke.MethodHandles;

import org.chikoo.core.entity.SearchResults;
import org.chikoo.core.service.SearchService;
import org.chikoo.rest.resources.SearchResultsResource;
import org.chikoo.rest.resources.asm.SearchResultsResourceAsm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().getClass());
	
	private SearchService service;
	
	public HomeController( SearchService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public @ResponseBody SearchResults home(@RequestBody SearchResults searchResults) {
		if( StringUtils.isEmpty(searchResults.getSearchTerm()))  
				searchResults.setSearchTerm("No Search Term Found.");
		return searchResults;
	}

	@RequestMapping(value = "/rest/search-results/{id}", method = RequestMethod.GET)
	public ResponseEntity<SearchResultsResource> getSearchResultsById( @PathVariable Long id) {
		SearchResults searchResults = service.find(id);
		SearchResultsResource searchResultsResource = new SearchResultsResourceAsm().toResource(searchResults);
		return new ResponseEntity<SearchResultsResource>( searchResultsResource, HttpStatus.OK);
	}
	
}
