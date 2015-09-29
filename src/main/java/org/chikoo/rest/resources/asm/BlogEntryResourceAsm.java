package org.chikoo.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.model.entity.SearchResults;
import org.chikoo.rest.resources.BlogEntryResource;
import org.chikoo.rest.resources.SearchResultsResource;
import org.chikoo.rest.web.controller.BlogEntryController;
import org.chikoo.rest.web.controller.HomeController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

	public BlogEntryResourceAsm() {
		super(BlogEntry.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(final BlogEntry blogEntry) {
		BlogEntryResource blogEntryResource = new BlogEntryResource();
		blogEntryResource.setTitle(blogEntry.getTitle());
		Link link = linkTo( methodOn(BlogEntryController.class).getBlogEntryResultsById(blogEntry.getId())).withSelfRel();
		blogEntryResource.add(link.withSelfRel());
		return blogEntryResource;
		
	}

}
