package org.chikoo.rest.resources;

import org.chikoo.core.model.entity.Account;
import org.springframework.hateoas.ResourceSupport;

public class BlogResource extends ResourceSupport {
	
	private Account owner;
	private String title;

	public Account getOwner() {
		return owner;
	}
	public void setOwner(Account account) {
		this.owner = account;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
