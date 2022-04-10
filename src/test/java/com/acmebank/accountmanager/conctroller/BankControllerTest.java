package com.acmebank.accountmanager.conctroller;

import com.acmebank.accountmanager.controller.BankController;
import com.acmebank.accountmanager.controller.CheckBalanceRequest;
import com.acmebank.accountmanager.repository.entity.AccountEntity;
import com.acmebank.accountmanager.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BankController.class,excludeAutoConfiguration = SecurityAutoConfiguration.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class BankControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BankService bankService;

    @Test
    public void checkBalanceTest() throws Exception {
        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setBalance(new BigDecimal("100"));
        when(bankService.checkBalance(anyInt())).thenReturn(accountEntity);
        CheckBalanceRequest checkBalanceRequest=new CheckBalanceRequest();

        mockMvc.perform(post("/checkBalance").contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isOk())
        .andExpect(jsonPath("$.balance").value(100));
    }


}
