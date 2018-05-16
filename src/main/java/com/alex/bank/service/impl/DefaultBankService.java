package com.alex.bank.service.impl;

import com.alex.bank.model.Bank;
import com.alex.bank.repository.BankRepository;
import com.alex.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Shishkov A.V. on 16.05.18.
 */
@Controller
public class DefaultBankService implements BankService {

	@Autowired
	BankRepository bankRepository;

	@Override
	public List<Bank> getAllBanks() {
		return StreamSupport.stream(bankRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}
