package com.acmebank.accountmanager.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="ACCOUNT")
public class AccountEntity {
    @Id
    private int accountNum;
    private BigDecimal balance;

    public AccountEntity(int accountNum, BigDecimal balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public AccountEntity() {
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
