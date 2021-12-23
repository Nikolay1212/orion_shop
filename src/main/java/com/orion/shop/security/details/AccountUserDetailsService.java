package com.orion.shop.security.details;

import com.orion.shop.model.Account;
import com.orion.shop.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("accountUserDetailsService")
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepo.findAccountByEmail(email);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            return new AccountUserDetails(account);
        } else {
            throw new UsernameNotFoundException("Account not found");
        }
    }
}
