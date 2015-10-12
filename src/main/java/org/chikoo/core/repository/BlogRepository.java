package org.chikoo.core.repository;

import java.util.List;

import org.chikoo.core.model.entity.Blog;
import org.springframework.stereotype.Repository;

public interface BlogRepository {

	Blog createBlog(Blog data);
	Blog findBlog(long id);
	List<Blog> findBlogsByAccount(long accountId);
	Blog findBlogByTitle(String title);
	List<Blog> findAllBlogs();
	
}
  