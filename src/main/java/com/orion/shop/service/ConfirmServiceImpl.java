package com.orion.shop.service;

import com.orion.shop.model.Account;
import com.orion.shop.model.State;
import com.orion.shop.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private AccountRepo accountRepo;

    @Transactional
    @Override
    public boolean confirm(String confirmId) {
        Optional<Account> accountOptional = accountRepo.findAccountsByConfirmId(confirmId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setState(State.CONFIRMED);
            accountRepo.save(account);
            return true;
        } else {
            return false;
        }
    }
}
