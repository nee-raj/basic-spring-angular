package org.chikoo.core.service;

import org.chikoo.core.model.entity.BlogEntry;

public interface BlogEntryService {
	public BlogEntry findBlogEntry(long id);
	public BlogEntry deleteBlogEntry(long id);
	public BlogEntry updateBlogEntry(long id, BlogEntry data);
}
 