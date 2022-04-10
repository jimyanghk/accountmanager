package com.acmebank.accountmanager.conctroller;

import com.acmebank.accountmanager.controller.BankController;
import com.acmebank.accountmanager.controller.CheckBalanceRequest;
import com.acmebank.accountmanager.model.Account;
import com.acmebank.accountmanager.repository.entity.AccountEntity;
import com.acmebank.accountmanager.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(controllers = BankController.class,excludeAutoConfiguration = SecurityAutoConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
public class BankControllerEndToEndTest {

    @Autowired
    //WebTestClient webTestClient;
    TestRestTemplate testRestTemplate;

    @Test
    public void checkBalanceTest() throws Exception {
        //AccountEntity accountEntity=new AccountEntity();
        //accountEntity.setBalance(new BigDecimal("100"));

        CheckBalanceRequest checkBalanceRequest=new CheckBalanceRequest();
        checkBalanceRequest.setAccountNum(12345678);

        Account account=testRestTemplate.postForObject("/checkBalance",checkBalanceRequest,Account.class);
        System.out.println("account:"+account);
        assertThat(account.getBalance().equals(new BigDecimal("1000000")));
    }


}
