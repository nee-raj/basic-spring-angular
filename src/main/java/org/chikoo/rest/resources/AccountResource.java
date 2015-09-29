package org.chikoo.rest.resources;

import org.chikoo.core.model.entity.Account;
import org.springframework.hateoas.ResourceSupport;

public class AccountResource extends ResourceSupport {

	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public Account toAccount() {
        Account account = new Account();
        account.setName(name);
        account.setPassword(password);
        return account;
    }
}
