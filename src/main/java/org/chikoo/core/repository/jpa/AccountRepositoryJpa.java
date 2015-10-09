package org.chikoo.core.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.repository.AccountRepository;
import org.chikoo.core.service.util.AccountList;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryJpa implements AccountRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Account findAccount(long id) {
		return em.find(Account.class, id);
	}
	@Override
	public Account createAccount(Account data) {
		em.persist(data);
		return data;
	}
	
	@Override
	public List<Account> findAllAccounts() {
		Query query = em.createQuery("Select a from Account a");
		return  query.getResultList();
	}
	
	@Override
	public Account findAccountByName(String name) {
		Query query = em.createQuery("Select a from Account a where lower(a.name) = lower(?) ");
		query.setParameter(1, name);
		List<Account> accounts = query.getResultList();
		if (accounts.size() == 0) {
			return null;
		} else {
			return accounts.get(0);
		}
		
	}
		
}
