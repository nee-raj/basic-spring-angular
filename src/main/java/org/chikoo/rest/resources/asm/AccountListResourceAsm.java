package org.chikoo.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.chikoo.core.service.util.AccountList;
import org.chikoo.rest.resources.AccountListResource;
import org.chikoo.rest.resources.AccountResource;
import org.chikoo.rest.web.controller.AccountController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountListResourceAsm  extends ResourceAssemblerSupport<AccountList, AccountListResource>{

	public AccountListResourceAsm() {
		super(AccountController.class, AccountListResource.class);
	}

	@Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}

