package org.chikoo.core.service.impl;

import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.service.BlogEntryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {

	@Override
	public BlogEntry findBlogEntry(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntry deleteBlogEntry(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
