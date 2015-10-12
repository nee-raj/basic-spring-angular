package org.chikoo.core.service.util;

import java.util.ArrayList;
import java.util.List;

import org.chikoo.core.model.entity.Blog;

public class BlogList {

	private List<Blog> blogs = new ArrayList<Blog>();

	public BlogList(List<Blog> listOfBlogs) {
		this.blogs = listOfBlogs;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
}
