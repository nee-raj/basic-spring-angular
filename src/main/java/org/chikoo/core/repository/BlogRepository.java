package org.chikoo.core.repository;

import org.chikoo.core.model.entity.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository {

	Blog createBlog(Blog data);
	Blog findBlog(long id);
	
}
  