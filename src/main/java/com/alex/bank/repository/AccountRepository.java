package com.alex.bank.repository;

import com.alex.bank.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Shishkov A.V. on 15.05.18.
 */
public interface AccountRepository extends CrudRepository<Account, UUID> {
}
