package org.chikoo.core.service.util;

import java.util.ArrayList;
import java.util.List;

import org.chikoo.core.model.entity.Account;

public class AccountList {

	private List<Account> accounts = new ArrayList<Account>();

	public AccountList(List<Account> asList) {
		this.accounts = asList;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
