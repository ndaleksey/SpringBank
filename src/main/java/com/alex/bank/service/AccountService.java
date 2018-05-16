package com.alex.bank.service;


import com.alex.bank.model.Account;

import java.util.List;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
public interface AccountService {
	List<Account> getAllAccounts();

	void addAccount(Account account);

	List<Account> findByAccountNumber(String number);

}
