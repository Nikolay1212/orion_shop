package com.orion.shop.repo;

import com.orion.shop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByEmail(String email);
    Optional<Account> findAccountsByConfirmId(String confirmIs);
}
