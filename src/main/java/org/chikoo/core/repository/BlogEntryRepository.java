package org.chikoo.core.repository;

import java.util.List;

import org.chikoo.core.model.entity.BlogEntry;

public interface BlogEntryRepository {

	BlogEntry createBlogEntry(BlogEntry data);
	BlogEntry updateBlogEntry(long id, BlogEntry data);
	BlogEntry deleteBlogEntry(long id);
	BlogEntry findBlogEntry(long id);
	List<BlogEntry> findByBlogId(long blogId);


}
