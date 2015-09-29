package org.chikoo.core.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.chikoo.core.model.entity.Blog;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepositoryJpa {
	@PersistenceContext
	private EntityManager em;

	Blog createBlog(Blog data) {
		em.persist(data);
		return data;
	}

	Blog findBlog(Long id) {
		Query query = em.createQuery("select b from Blog b where b.id = ?");
		query.setParameter(0, id);
		List<Blog> blogList = query.getResultList();
		if (blogList.size() > 0) {
			return blogList.get(0);
		} else {
			return null;
		}
	}
}