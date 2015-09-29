package org.chikoo.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.rest.resources.BlogResource;
import org.chikoo.rest.web.controller.BlogController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogResourceAsm extends ResourceAssemblerSupport<Blog, BlogResource>{

	public BlogResourceAsm() {
		super(BlogController.class, BlogResource.class);
	}

	@Override
	public BlogResource toResource(Blog blog) {
		
		BlogResource blogResource = new BlogResource();
		blogResource.setAccount(blog.getAccount());
		blogResource.setTitle(blog.getTitle());
		
		Link link = linkTo( methodOn(BlogController.class).getBlogById(blog.getId())).withSelfRel();
		blogResource.add(	link.withSelfRel());
		return blogResource;

	}

}
