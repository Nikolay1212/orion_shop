package com.orion.shop.service;

import com.orion.shop.model.Account;
import com.orion.shop.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<Account> getUsers() {
        return accountRepo.findAll();
    }
}
