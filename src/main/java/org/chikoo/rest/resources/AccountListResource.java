package org.chikoo.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.chikoo.core.model.entity.Account;
import org.springframework.hateoas.ResourceSupport;

public class AccountListResource extends ResourceSupport {
	private List<AccountResource> accounts = new ArrayList<AccountResource>();

	public void setAccounts(List<AccountResource> accounts) {
		this.accounts = accounts;
	}

	public AccountListResource toAccountListResource() {
		AccountListResource accountListResource = new AccountListResource();
		accountListResource.setAccounts(accounts);
		return accountListResource;
	}

	public List<AccountResource> getAccounts() {
		return accounts;
	}

}
