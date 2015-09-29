package org.chikoo.core.repository;

import java.util.List;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.service.util.AccountList;

public interface AccountRepository {
	List<Account> findAllAccounts();
	Account findAccount(Long id);
	Account createAccount(Account account);
	Account findAccountByName(String name);
}