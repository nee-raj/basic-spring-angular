package org.chikoo.core.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.chikoo.config.DBConfig;
import org.chikoo.core.model.entity.Account;
import org.chikoo.core.service.util.AccountList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository repo;
	private Account account;

	@Before
	@Transactional
	@Rollback(false)
	public void SetupContext() {
		account = new Account();
		account.setName("name");
		account.setPassword("password");
		repo.createAccount(account);
	}

	@Test
	@Transactional
	public void testFind() {
		assertNotNull(repo.findAccount(account.getId()));
	}

	@Test
	@Transactional
	public void testfindAccountByName() {
		assertEquals(account, repo.findAccountByName("name"));
	}

	@Test
	@Transactional
	public void testIfNoAccountExistsByInputName() {
		assertEquals(null, repo.findAccountByName("FakeName"));
	}

	@Test
	@Transactional
	public void testGetAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		AccountList accountsList = new AccountList(accounts);
		accounts.add(account);
		assertEquals(accountsList, repo.findAllAccounts());
	}
}
