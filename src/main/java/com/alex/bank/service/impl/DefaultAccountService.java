package com.alex.bank.service.impl;

import com.alex.bank.model.Account;
import com.alex.bank.model.Bank;
import com.alex.bank.repository.AccountRepository;
import com.alex.bank.repository.BankRepository;
import com.alex.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Controller
public class DefaultAccountService implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BankRepository bankRepository;

	@PostConstruct
	private void init() {
		addMockAccounts();
	}

	@Override
	public List<Account> getAllAccounts() {
		return StreamSupport.stream(accountRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public void addAccount(Account account) {
		accountRepository.save(account);
	}

	@Override
	public List<Account> findByAccountNumber(String number) {
		if (number == null || number.isEmpty()) return null;

		return accountRepository.findByAccountNumber(number);
	}

	private void addMockAccounts() {
		Bank bankOfAmerica = new Bank("Bank Of America", "111111");
		Bank bankOfChina = new Bank("Bank Of China", "222222");

		Account alex = new Account("1", "111111-1");
		Account nick = new Account("2", "111111-2");
		Account will = new Account("4", "222222-4");

		bankOfAmerica.addAccount(alex);
		bankOfAmerica.addAccount(nick);

		bankOfChina.addAccount(will);

		bankRepository.saveAll(Arrays.asList(bankOfAmerica, bankOfChina));
	}
}
