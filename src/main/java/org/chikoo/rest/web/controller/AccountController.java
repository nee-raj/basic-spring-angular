package org.chikoo.rest.web.controller;

import java.net.URI;

import org.chikoo.core.entity.Account;
import org.chikoo.core.service.AccountService;
import org.chikoo.core.service.exception.AccountExistsException;
import org.chikoo.rest.exception.ConflictException;
import org.chikoo.rest.resources.AccountResource;
import org.chikoo.rest.resources.asm.AccountResourceAsm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/rest/accounts")
public class AccountController {

	private AccountService accountService ;
	
	 @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<AccountResource> createAccount( @RequestBody AccountResource sentAccount ) {
	        try {
	            Account createdAccount = accountService.createAccount(sentAccount.toAccount());
	            AccountResource res = new AccountResourceAsm().toResource(createdAccount);
	            HttpHeaders headers = new HttpHeaders();
	            headers.setLocation(URI.create(res.getLink("self").getHref()));
	            return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
	        } catch(AccountExistsException exception) {
	            throw new ConflictException(exception);
	        }
	    }

	 @RequestMapping( value="/{accountId}", method = RequestMethod.GET)
	 public ResponseEntity<AccountResource> getAccount( @PathVariable Long accountId ) {
     
		Account account = accountService.findAccount(accountId);
		 if(account != null)
		 {
		     AccountResource res = new AccountResourceAsm().toResource(account);
		     return new ResponseEntity<AccountResource>(res, HttpStatus.OK);
		 } else {
		     return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
		 }
	
 }

}
