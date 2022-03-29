package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.model.Account;
import com.acmebank.accountmanager.repository.AccountRepository;
import com.acmebank.accountmanager.repository.entity.AccountEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class BankServiceImpl implements BankService{
    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);
    @Autowired
    AccountRepository accountRepository;
    @Override
    public AccountEntity checkBalance(int accountNum) {
        return accountRepository.findByAccountNum(accountNum);
    }

    @Override
    public boolean transfer(int fromAccountNum, int toAccountNum,BigDecimal amount) {
        AccountEntity fromAccount=checkBalance(fromAccountNum);
        AccountEntity toAccount=checkBalance(toAccountNum);
        synchronized (this) {
            logger.info("fromAccount balance:{},toAccountBalance:{}",fromAccount.getBalance(),toAccount.getBalance());
            logger.info("compare result:{}",fromAccount.getBalance().compareTo(amount));
            if (fromAccount != null && fromAccount.getBalance().compareTo(amount) != -1) {
                BigDecimal fromBalance=fromAccount.getBalance().subtract(amount);
                BigDecimal toBalance=toAccount.getBalance().add(amount);
                fromAccount.setBalance(fromBalance);
                toAccount.setBalance(toBalance);
                accountRepository.save(fromAccount);
                accountRepository.save(toAccount);
                return  true;
            }
        }
        return false;
    }
}
