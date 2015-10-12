package org.chikoo.core.service;

import java.util.List;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.service.util.AccountList;
import org.chikoo.core.service.util.BlogList;

public interface AccountService {
	AccountList findAllAccounts();
	Account findAccount(long id);
	Account createAccount(Account account);
	Account findAccountByName(String name);
	Blog createBlog(long accountId, Blog data);
	BlogList findBlogsByAccount(long id);
}
