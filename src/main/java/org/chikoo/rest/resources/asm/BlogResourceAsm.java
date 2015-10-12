package org.chikoo.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.rest.resources.BlogResource;
import org.chikoo.rest.web.controller.AccountController;
import org.chikoo.rest.web.controller.BlogController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogResourceAsm extends ResourceAssemblerSupport<Blog, BlogResource>{

	public BlogResourceAsm() {
		super(BlogController.class, BlogResource.class);
	}

	 @Override
	    public BlogResource toResource(Blog blog) {
	        BlogResource resource = new BlogResource();
	        resource.setTitle(blog.getTitle());
	        resource.add(linkTo(BlogController.class).slash(blog.getId()).withSelfRel());
	        resource.add(linkTo(BlogController.class).slash(blog.getId()).slash("blog-entries").withRel("entries"));
	        if(blog.getOwner() != null)
	            resource.add(linkTo(AccountController.class).slash(blog.getOwner().getId()).withRel("owner"));
	        return resource;
	    }

}
