package com.springBasics.Transaction_Management.services;

import com.springBasics.Transaction_Management.models.Account;
import com.springBasics.Transaction_Management.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Account getAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Account> createAccount(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBalance(String accountNumber, BigDecimal amount) {
        Account account = getAccount(accountNumber);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }
}