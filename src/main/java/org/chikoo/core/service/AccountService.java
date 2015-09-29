package org.chikoo.core.service;

import java.util.List;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.service.util.AccountList;

public interface AccountService {
	AccountList findAllAccounts();
	Account findAccount(Long id);
	Account createAccount(Account account);
	Account findAccountByName(String name);
	Blog createBlog(Long accountId, Blog data);
}
