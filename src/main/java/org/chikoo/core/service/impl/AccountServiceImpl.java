package org.chikoo.core.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.repository.AccountRepository;
import org.chikoo.core.repository.BlogRepository;
import org.chikoo.core.service.AccountService;
import org.chikoo.core.service.exception.AccountDoesNotExistException;
import org.chikoo.core.service.exception.AccountExistsException;
import org.chikoo.core.service.util.AccountList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Inject
	private AccountRepository accountRepo;
	@Inject
	private BlogRepository blogRepo;

	@Override
	public Account findAccount(long id) {
		Account account = accountRepo.findAccount(id);
		if (account != null) {
			return account;
		} else {
			throw new AccountDoesNotExistException();
		}
	}

	@Override
	public Account createAccount(Account account) {
		Account accountWithId = accountRepo.createAccount(account);
		if (accountWithId != null) {
			return accountWithId;
		} else {
			throw new AccountExistsException();
		}
	}

	@Override
	public Blog createBlog(long accountId, Blog data) {
		Account account = accountRepo.findAccount(accountId);
		if (account != null) {
			throw new AccountExistsException();
		} else {
			return blogRepo.createBlog(data);
		}
	}

	@Override
	public AccountList findAllAccounts() {
		return new AccountList(accountRepo.findAllAccounts());
	}

	@Override
	public Account findAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
