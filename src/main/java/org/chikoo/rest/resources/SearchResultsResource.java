package org.chikoo.rest.resources;

import org.springframework.hateoas.ResourceSupport;

public class SearchResultsResource extends ResourceSupport {
	
	private String searchTerm = "" ;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
