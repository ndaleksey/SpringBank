package com.alex.bank.controller;

import com.alex.bank.model.Account;
import com.alex.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Controller
@RequestMapping(path = "/accounts")
public class BankController {
	@Autowired
	private AccountService accountService;

	@GetMapping
	public String getAccounts(Model model) {
		model.addAttribute("accounts", accountService.getAllAccounts());
		model.addAttribute("message", null);
		model.addAttribute("account", new Account());

		return "account_list";
	}

	@PostMapping
	public String addAccount(@RequestParam Account account, Model model) {
		Account findAccount = accountService.findByAccountNumber(account.getAccountNumber());

		if (findAccount != null) {
			model.addAttribute("message", "Account with such number is already exist");
			return "redirect:/account_list";
		}

		accountService.addAccount(account);

		return "redirect:/account_list";
	}
}
