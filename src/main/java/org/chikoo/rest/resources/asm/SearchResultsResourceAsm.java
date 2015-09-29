package org.chikoo.rest.resources.asm;

import org.chikoo.core.model.entity.SearchResults;
import org.chikoo.rest.resources.SearchResultsResource;
import org.chikoo.rest.web.controller.HomeController;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class SearchResultsResourceAsm extends ResourceAssemblerSupport<SearchResults, SearchResultsResource> {

	public SearchResultsResourceAsm() {
		super(HomeController.class, SearchResultsResource.class);
	}

	@Override
	public SearchResultsResource toResource(final SearchResults searchResults) {
		SearchResultsResource res = new SearchResultsResource();
		res.setSearchTerm(searchResults.getSearchTerm());
		Link link = linkTo( methodOn(HomeController.class).getSearchResultsById(searchResults.getId())).withSelfRel();
		res.add(link.withSelfRel());
		return res;
		
	}

}
