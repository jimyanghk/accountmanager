package com.acmebank.accountmanager.repository;

import com.acmebank.accountmanager.repository.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Long> {
    AccountEntity  findByAccountNum(int accountNum);
}
