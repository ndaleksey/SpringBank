package com.alex.bank.service.impl;

import com.alex.bank.model.Account;
import com.alex.bank.model.Bank;
import com.alex.bank.repository.AccountRepository;
import com.alex.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Controller
public class DefaultAccountService implements AccountService {
	private List<Account> accounts = new ArrayList<>();

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		return getMockAccounts();
	}

	@Override
	public void addAccount(Account account) {
		accounts.add(account);
	}

	@Override
	public Account findByAccountNumber(String number) {
		if (number == null || number.isEmpty()) return null;

		return accounts.stream().findFirst().filter(s -> s.getAccountNumber().equals(number)).get();
	}

	private List<Account> getMockAccounts() {
		Bank bankOfAmerica = new Bank(UUID.randomUUID(), "Bank Of America", "111111");
		Bank bankOfChina = new Bank(UUID.randomUUID(), "Bank Of China", "222222");

		Account alex = new Account(UUID.randomUUID(), "1", "111111-1", bankOfAmerica);
		Account nick = new Account(UUID.randomUUID(), "2", "111111-2", bankOfAmerica);
		Account will = new Account(UUID.randomUUID(), "4", "222222-4", bankOfChina);

		accounts.add(alex);
		accounts.add(nick);
		accounts.add(will);

		return accounts;
	}
}
