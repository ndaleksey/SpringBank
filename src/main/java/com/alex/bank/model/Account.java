package com.alex.bank.model;

import javax.persistence.*;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String accountNumber;

	private String iban;

	@ManyToOne(fetch = FetchType.EAGER)
	private Bank bank;

	public Account() {
	}

	public Account(String accountNumber, String iban) {
		this.accountNumber = accountNumber;
		this.iban = iban;
	}

	public Long getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
