package com.alex.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
@Entity
public class Bank {
	private UUID id;
	private String name;
	private String bic;

	public Bank(UUID id, String name, String bic) {
		this.id = id;
		this.name = name;
		this.bic = bic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
}
