package com.alex.bank.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Entity
public class Account {
	private UUID id;
	private String accountNumber;
	private String iban;
	private Bank bank;

	public Account() {
	}

	public Account(UUID id, String accountNumber, String iban, Bank bank) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.iban = iban;
		this.bank = bank;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	@ManyToOne
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
