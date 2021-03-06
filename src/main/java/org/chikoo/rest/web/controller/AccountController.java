package org.chikoo.rest.web.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.service.AccountService;
import org.chikoo.core.service.exception.AccountDoesNotExistException;
import org.chikoo.core.service.exception.AccountExistsException;
import org.chikoo.core.service.util.AccountList;
import org.chikoo.core.service.util.BlogList;
import org.chikoo.rest.exception.ConflictException;
import org.chikoo.rest.exception.NotFoundException;
import org.chikoo.rest.resources.AccountListResource;
import org.chikoo.rest.resources.AccountResource;
import org.chikoo.rest.resources.BlogListResource;
import org.chikoo.rest.resources.asm.AccountListResourceAsm;
import org.chikoo.rest.resources.asm.AccountResourceAsm;
import org.chikoo.rest.resources.asm.BlogListResourceAsm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rest/accounts")
public class AccountController {
	@Inject
	private AccountService accountService;

	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<AccountListResource> findAllAccounts(@RequestParam(value="name", required = false) String name) {
	        AccountList list = null;
	        if(name == null) {
	            list = accountService.findAllAccounts();
	        } else {
	            Account account = accountService.findAccountByName(name);
	            if(account == null) {
	                list = new AccountList(new ArrayList<Account>());
	               
	            } else {
	                list = new AccountList(Arrays.asList(account));
	            }
	        }
	        AccountListResource res = new AccountListResourceAsm().toResource(list);
	        return new ResponseEntity<AccountListResource>(res, HttpStatus.OK);
	    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccount(@RequestBody AccountResource sentAccount) {
		try {
			Account createdAccount = accountService.createAccount(sentAccount.toAccount());
			AccountResource res = new AccountResourceAsm().toResource(createdAccount);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
		} catch (AccountExistsException exception) {
			throw new ConflictException(exception);
		}
	}

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountResource> getAccount(@PathVariable long accountId) {
		Account account = accountService.findAccount(accountId);
		if (account != null) {
			AccountResource res = new AccountResourceAsm().toResource(account);
			return new ResponseEntity<AccountResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
		}
	}

	   @RequestMapping(value="/{accountId}/blogs",
	            method = RequestMethod.GET)
	    public ResponseEntity<BlogListResource> findAllBlogs(
	            @PathVariable long accountId) {
	        try {
	            BlogList blogList = accountService.findBlogsByAccount(accountId);
	            BlogListResource blogListRes = new BlogListResourceAsm().toResource(blogList);
	            return new ResponseEntity<BlogListResource>(blogListRes, HttpStatus.OK);
	        } catch(AccountDoesNotExistException exception)
	        {
	            throw new NotFoundException(exception);
	        }
	    }

}
