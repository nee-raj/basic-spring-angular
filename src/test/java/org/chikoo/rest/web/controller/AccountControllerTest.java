package org.chikoo.rest.web.controller;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.service.AccountService;
import org.chikoo.core.service.exception.AccountExistsException;
import org.chikoo.core.service.util.AccountList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AccountControllerTest {

	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountService accountService;
	
    private ArgumentCaptor<Account> accountCaptor;

	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
		accountCaptor = ArgumentCaptor.forClass(Account.class);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void exceptionThrownIfAccountAlreadyExist() throws Exception {
		when(accountService.createAccount((Account) Mockito.any())).thenThrow(AccountExistsException.class);
		mockMvc.perform(post("/rest/accounts/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"neeraj\",\"password\":\"password\"}")
			)
			.andExpect(status().isConflict());
	}

	@Test
	public void createANewAccountforUserNotAlreadyPresent() throws Exception {
		Account newAccount = new Account();
		newAccount.setId(1L);
		newAccount.setName("neeraj");
		newAccount.setPassword("password");
		
		when(accountService.createAccount(any(Account.class))).thenReturn(newAccount);
		
		mockMvc.perform(post("/rest/accounts/")
							.contentType(MediaType.APPLICATION_JSON)
							.content("{\"name\":\"neeraj\",\"password\":\"password\"}")
						)
						.andExpect(header().string("Location", endsWith("/rest/accounts/1")))
		                .andExpect(jsonPath("$.name", is(newAccount.getName())))
						.andExpect(status().isCreated());
		
		verify(accountService).createAccount(accountCaptor.capture());
        
		String password = accountCaptor.getValue().getPassword();
        assertEquals("password", password);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void throwExceptionifUserAlreadyExists() throws Exception {
		
		when(accountService.createAccount(any(Account.class))).thenThrow(AccountExistsException.class);
		
		mockMvc.perform(post("/rest/accounts/")
							.contentType(MediaType.APPLICATION_JSON)
							.content("{\"name\":\"neeraj\",\"password\":\"password\"}")
						).andExpect(status().isConflict());
		
		verify(accountService).createAccount(accountCaptor.capture());
		String username= accountCaptor.getValue().getName();
		String password=accountCaptor.getValue().getPassword();
		
		assertEquals("neeraj", username);
		assertEquals("password", password);
		
	}
	
	@Test
	public void getUserInformation() throws Exception {
		Account someAccount = new Account();
		someAccount.setId(1L);
		someAccount.setName("neeraj");
	
		when(accountService.findAccount(1L)).thenReturn(someAccount);
		
		mockMvc.perform(get("/rest/accounts/1"))
			.andDo(print())
			.andExpect(status().isOk())
			//.andExpect( jsonPath("$.password").value(isNull()) );
		.andExpect(jsonPath("$.password", is(nullValue())));
	}	
	
	@Test
	public void searchUserAccountNotFound() throws Exception {
		
		when(accountService.findAccount(anyLong())).thenReturn(null);
		
		mockMvc.perform(get("/rest/accounts/1"))
			.andDo(print()).andExpect(status().isNotFound());
		
	}
	
	@Test
	public void testfindAllAccounts() throws Exception {
		
		Account account1 = new Account();
		Account account2 = new Account();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		
		AccountList accountList = new AccountList(accounts);
		when(accountService.findAllAccounts()).thenReturn(accountList);
		
		mockMvc.perform(get("/rest/accounts/"))
			.andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	public void testfindAllAccountsWithAccountName() throws Exception {
		
		Account account = new Account();
		account.setName("Neeraj");
		when(accountService.findAccountByName("Neeraj")).thenReturn(account);
		
		mockMvc.perform(get("/rest/accounts/").param("name", "Neeraj"))
			.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$..name").value("Neeraj"));

		
	}
	
}
