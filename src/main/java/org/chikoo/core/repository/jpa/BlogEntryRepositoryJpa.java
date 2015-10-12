package org.chikoo.core.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.model.entity.BlogEntry;
import org.chikoo.core.repository.BlogEntryRepository;
import org.chikoo.core.repository.BlogRepository;
import org.chikoo.core.service.util.BlogEntryList;
import org.springframework.stereotype.Repository;

@Repository
public class BlogEntryRepositoryJpa implements BlogEntryRepository{
	@PersistenceContext
	private EntityManager em;

	@Override
	public BlogEntry findBlogEntry(long id) {
		return em.find(BlogEntry.class, id);
	}
	
	@Override
	public BlogEntry deleteBlogEntry(long id) {
		BlogEntry entry = em.find(BlogEntry.class, id);
		em.remove(entry);
		return entry;
	}
	
	@Override
	public BlogEntry updateBlogEntry(long id, BlogEntry data) {
		BlogEntry entry = em.find(BlogEntry.class, id);
		entry.setTitle(data.getTitle());
		entry.setContent(data.getContent());
		return entry;
	}

	@Override
	public BlogEntry createBlogEntry( BlogEntry data) {
		em.persist(data);
		return data;
	}

	@Override
	public List<BlogEntry> findByBlogId(long blogId) {
		Query query = em.createQuery("Select blogEntry from blogEntry be where be.blog.id = ?");
		return query.getResultList();
	}

	
	
}