package org.chikoo.core.service.impl;

import javax.inject.Inject;

import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.repository.BlogEntryRepository;
import org.chikoo.core.service.BlogEntryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {

	@Inject
	private BlogEntryRepository blogEntryRepo; 
	
	
	@Override
	public BlogEntry findBlogEntry(long id) {
		return blogEntryRepo.findBlogEntry(id);
	}

	@Override
	public BlogEntry deleteBlogEntry(long id) {
		return blogEntryRepo.deleteBlogEntry(id);
	}

	@Override
	public BlogEntry updateBlogEntry(long id, BlogEntry data) {
		return blogEntryRepo.updateBlogEntry(id, data);
	}
	
}
