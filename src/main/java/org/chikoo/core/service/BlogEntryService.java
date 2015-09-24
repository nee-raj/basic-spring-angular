package org.chikoo.core.service;

import org.chikoo.core.entity.BlogEntry;

public interface BlogEntryService {
	public BlogEntry findBlogEntry(Long id);
	public BlogEntry deleteBlogEntry(Long id);
	public BlogEntry updateBlogEntry(Long id, BlogEntry data);
}
 