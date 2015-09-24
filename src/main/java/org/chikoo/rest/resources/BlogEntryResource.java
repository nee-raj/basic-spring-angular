package org.chikoo.rest.resources;

import org.chikoo.core.entity.Blog;
import org.springframework.hateoas.ResourceSupport;

public class BlogEntryResource extends ResourceSupport {

	private String title;
	private Blog blog;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
