package com.acmebank.accountmanager;

import com.acmebank.accountmanager.repository.AccountRepository;
import com.acmebank.accountmanager.repository.entity.AccountEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
public class DatabaseInitializer {
    //@Bean
    CommandLineRunner init(AccountRepository accountRepository){
        System.out.println("DatabaseInitializer started");
        return args -> {
            accountRepository.save(new AccountEntity(12345678,new BigDecimal("1000000")));
            accountRepository.save(new AccountEntity(88888888,new BigDecimal("1000000")));
        };
    }
}
