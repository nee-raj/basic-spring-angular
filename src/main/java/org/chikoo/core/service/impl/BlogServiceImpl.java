package org.chikoo.core.service.impl;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.service.BlogService;
import org.chikoo.core.service.util.BlogEntryList;
import org.chikoo.core.service.util.BlogList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Override
	public Blog find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog createBlogEntry(long id, BlogEntry data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogList findAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntryList findAllBlogEntries(long blogId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
