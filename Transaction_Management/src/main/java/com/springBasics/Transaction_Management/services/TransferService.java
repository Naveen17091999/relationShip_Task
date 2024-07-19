package com.springBasics.Transaction_Management.services;

import com.springBasics.Transaction_Management.exceptions.InsufficientFundsException;
import com.springBasics.Transaction_Management.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,
            rollbackFor = Exception.class, timeout = 30)
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) throws InsufficientFundsException {
        Account fromAccount = accountService.getAccount(fromAccountNumber);
        Account toAccount = accountService.getAccount(toAccountNumber);

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds in account " + fromAccountNumber);
        }

        accountService.updateBalance(fromAccountNumber, amount.negate());
        accountService.updateBalance(toAccountNumber, amount);

        transactionService.logTransaction(fromAccountNumber, toAccountNumber, amount);
    }
}