package com.alex.bank.repository;

import com.alex.bank.model.Bank;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shishkov A.V. on 16.05.18.
 */
public interface BankRepository extends CrudRepository<Bank, Long> {
}
