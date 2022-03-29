package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.model.Account;
import com.acmebank.accountmanager.repository.entity.AccountEntity;

import java.math.BigDecimal;

public interface BankService {
    public AccountEntity checkBalance(int accountNum);

    public boolean transfer(int fromAccountNum, int toAccountNum, BigDecimal amount);


}
