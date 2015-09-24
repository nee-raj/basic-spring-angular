package org.chikoo.rest.resources;

import org.chikoo.core.entity.Account;
import org.springframework.hateoas.ResourceSupport;

public class BlogResource extends ResourceSupport {
	
	private Account account;
	private String title;

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
