package com.alex.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String bic;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bank", fetch = FetchType.EAGER)
	private Set<Account> accounts = new HashSet<>();

	public Bank() {
	}

	public Bank(String name, String bic) {
		this.name = name;
		this.bic = bic;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		account.setBank(this);
		accounts.add(account);
	}

	public void removeAccount(Account account) {
		if (account == null) return;

		accounts.remove(account);
		account.setBank(null);
	}
}
