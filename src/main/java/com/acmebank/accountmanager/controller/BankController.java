package com.acmebank.accountmanager.controller;

import com.acmebank.accountmanager.model.Account;
import com.acmebank.accountmanager.model.TxnResult;
import com.acmebank.accountmanager.repository.entity.AccountEntity;
import com.acmebank.accountmanager.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/checkBalance")
    @ResponseBody
    public Account checkBalance(@RequestBody CheckBalanceRequest checkBalanceRequest) {
        AccountEntity accountEntity=bankService.checkBalance(checkBalanceRequest.getAccountNum());
        Account account=new Account();
        account.setAccountNumber(accountEntity.getAccountNum());
        account.setBalance(accountEntity.getBalance());
        return account;


    }

    @PostMapping("/transfer")
    @ResponseBody
    public TxnResult transfer(@RequestBody TransferRequest transferRequest){
        TxnResult txnResult=new TxnResult();
        if(bankService.transfer(transferRequest.getFromAccountNum(),transferRequest.getToAccountNum(),transferRequest.getAmount())){
            txnResult.setResult("success");
        }else {
            txnResult.setResult("fail");
        }
        return txnResult;

    }

}
