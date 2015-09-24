package org.chikoo.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.chikoo.core.entity.Account;
import org.chikoo.rest.resources.AccountResource;
import org.chikoo.rest.web.controller.AccountController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource>{

	public AccountResourceAsm() {
		super(Account.class, AccountResource.class);
	}

	 @Override
	    public AccountResource toResource(Account account) {
	        AccountResource res = new AccountResource();
	        res.setName(account.getName());
	        res.setPassword(account.getPassword());
	        res.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
	        return res;
	    }
	

}
