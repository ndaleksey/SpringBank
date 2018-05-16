package com.alex.bank.controller;

import com.alex.bank.model.Account;
import com.alex.bank.model.Bank;
import com.alex.bank.service.AccountService;
import com.alex.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Controller
@RequestMapping(path = "/accounts")
public class BankController {

	private final Logger logger = Logger.getLogger(BankController.class.getName());

	@Autowired
	private AccountService accountService;

	@Autowired
	private BankService bankService;

	@GetMapping
	public String getAccounts(Model model) {
		List<Bank> banks = bankService.getAllBanks();
		List<Account> accounts = new ArrayList<>();

		for (Bank bank : banks) {
			accounts.addAll(bank.getAccounts());
		}

		model.addAttribute("banks", banks);
		model.addAttribute("accounts", accounts);
		model.addAttribute("message", null);
		model.addAttribute("account", new Account());

		return "account_list";
	}

	@PostMapping
	public String addAccount(@ModelAttribute Account account, Model model) {
		List<Account> findAccount = accountService.findByAccountNumber(account.getAccountNumber());

		if (findAccount != null && !findAccount.isEmpty()) {
			logger.info("Account with such number is already exist");
			model.addAttribute("message", "Account with such number is already exist");
		} else {
			accountService.addAccount(account);
		}

		return "redirect:/accounts";
	}
}