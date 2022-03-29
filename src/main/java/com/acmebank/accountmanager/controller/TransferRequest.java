package com.acmebank.accountmanager.controller;

import java.math.BigDecimal;

public class TransferRequest {
    public int fromAccountNum;
    public int toAccountNum;
    public BigDecimal amount;

    public int getFromAccountNum() {
        return fromAccountNum;
    }

    public void setFromAccountNum(int fromAccountNum) {
        this.fromAccountNum = fromAccountNum;
    }

    public int getToAccountNum() {
        return toAccountNum;
    }

    public void setToAccountNum(int toAccountNum) {
        this.toAccountNum = toAccountNum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
