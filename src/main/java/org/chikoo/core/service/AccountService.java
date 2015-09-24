package org.chikoo.core.service;

import org.chikoo.core.entity.Account;
import org.chikoo.core.entity.Blog;

public interface AccountService {
	public Account findAccount(Long id);
	public Account createAccount(Account account);
	public Blog createBlog(Long accountId, Blog data);
}
