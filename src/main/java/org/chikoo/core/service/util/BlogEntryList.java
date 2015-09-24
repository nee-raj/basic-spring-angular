package org.chikoo.core.service.util;

import java.util.ArrayList;
import java.util.List;

import org.chikoo.core.entity.BlogEntry;

public class BlogEntryList {

	private List<BlogEntry> blogs = new ArrayList<BlogEntry> ();

	public List<BlogEntry> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogEntry> blogs) {
		this.blogs = blogs;
	}
}
