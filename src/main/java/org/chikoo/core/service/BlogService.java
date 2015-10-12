package org.chikoo.core.service;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.service.util.BlogEntryList;
import org.chikoo.core.service.util.BlogList;
import org.springframework.stereotype.Service;
public interface BlogService {
	public Blog find(long id);
	public BlogEntry createBlogEntry(long id, BlogEntry data);
	public BlogList findAllBlogs();
	public BlogEntryList findAllBlogEntries(long blogId);
}

