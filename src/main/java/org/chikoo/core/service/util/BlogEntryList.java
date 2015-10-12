package org.chikoo.core.service.util;

import java.util.ArrayList;
import java.util.List;

import org.chikoo.core.model.entity.BlogEntry;

public class BlogEntryList {

	private long blogId;
	private List<BlogEntry> entries = new ArrayList<BlogEntry> ();

	  public BlogEntryList(Long blogId, List<BlogEntry> entries) {
	        this.blogId = blogId;
	        this.entries = entries;
	    }
	public List<BlogEntry> getBlogs() {
		return entries;
	}

	public void setBlogs(List<BlogEntry> blogs) {
		this.entries = blogs;
	}

	public long getBlogid() {
		return blogId;
	}

	public void setBlogid(long blogid) {
		this.blogId = blogid;
	}
}
