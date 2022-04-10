package com.acmebank.accountmanager.repository;

import com.acmebank.accountmanager.repository.entity.AccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void shouldSaveAccount(){
        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setAccountNum(123);
        accountEntity.setBalance(new BigDecimal("50000"));
        AccountEntity savedAccountEntity=accountRepository.save(accountEntity);
        assertThat(savedAccountEntity).usingRecursiveComparison().isEqualTo(accountEntity);
    }

    @Test
    @Sql("classpath:test-data.sql")
    public void shouldFindAccount(){
        AccountEntity savedAccountEntity=accountRepository.findByAccountNum(456);
        assertThat(savedAccountEntity.getBalance().setScale(0)).isEqualTo(new BigDecimal("1000000"));
    }

}
