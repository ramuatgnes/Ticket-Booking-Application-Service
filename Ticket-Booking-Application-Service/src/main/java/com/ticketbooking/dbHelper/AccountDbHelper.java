package com.ticketbooking.dbHelper;

import com.ticketbooking.entity.Account;
import com.ticketbooking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountDbHelper {

    @Autowired
    AccountRepository repository;

    public Account signUpAccount(Account account) {
        return repository.save(account);
    }

    public Account findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Account sendVerificationCode(Account account) {
        return repository.save(account);
    }

    public Optional<Account> findById(Integer accountId) {
        return repository.findById(accountId);
    }

    public Account verifyVerificationCode(Account byId) {
        return repository.save(byId);
    }


    public Account findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public Account updateAccount(Account byEmail) {
        return repository.save(byEmail);
    }

    public Account findByResetToken(String resetToken) {
        return repository.findByResetToken(resetToken);
    }
}
