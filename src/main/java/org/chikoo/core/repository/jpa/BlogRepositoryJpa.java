package org.chikoo.core.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.repository.BlogRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepositoryJpa implements BlogRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Blog createBlog(Blog data) {
		em.persist(data);
		return data;
	}

	@Override
	public List<Blog> findBlogsByAccount(long accountId) {
		Query query = em.createQuery("Select b from Blog b where b.owner.id = ?");
		query.setParameter(1, accountId);
		List<Blog> blogs = query.getResultList();
		if (blogs.isEmpty()) {
			return null;
		} else {
			return blogs;
		}
	}

	@Override
	public Blog findBlogByTitle(String title) {
		Query query = em.createQuery("select b from Blog b where b.title = ?");
		query.setParameter(1, title);
		List<Blog> blogs = query.getResultList();
		if (blogs.isEmpty()) {
			return null;
		} else {
			return blogs.get(0);
		}
	}

	@Override
	public Blog findBlog(long id) {
		return em.find(Blog.class, id);
	}

	@Override
	public List<Blog> findAllBlogs() {
		Query query = em.createQuery("select b from Blog b");
		return query.getResultList();
	}
}