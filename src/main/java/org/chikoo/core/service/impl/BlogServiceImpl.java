package org.chikoo.core.service.impl;

import javax.inject.Inject;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.repository.BlogEntryRepository;
import org.chikoo.core.repository.BlogRepository;
import org.chikoo.core.service.BlogService;
import org.chikoo.core.service.exception.BlogNotFoundException;
import org.chikoo.core.service.util.BlogEntryList;
import org.chikoo.core.service.util.BlogList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Inject
	BlogRepository blogRepo;
	
	@Inject
	BlogEntryRepository blogEntryRepo;
	
	@Override
	public Blog find(long id) {
		
		return blogRepo.findBlog(id);
	}

	@Override
	public BlogEntry createBlogEntry(long id, BlogEntry data) {
		Blog blog = blogRepo.findBlog(id);
		if(blog == null ){
			throw new BlogNotFoundException();
		}
		
		BlogEntry entry = blogEntryRepo.createBlogEntry(data);
		entry.setBlog(blog);
		return entry;
	}

	@Override
	public BlogList findAllBlogs() {
		return new BlogList(blogRepo.findAllBlogs());
	}

	@Override
	public BlogEntryList findAllBlogEntries(long blogId) {
		Blog blog = blogRepo.findBlog(blogId);
		if(blog == null) {
			throw new BlogNotFoundException();
		}
		return new BlogEntryList(blogId, blogEntryRepo.findByBlogId(blogId));
	}
	
}
