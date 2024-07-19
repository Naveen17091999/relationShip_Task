package com.springBasics.Transaction_Management.controllers;

import com.springBasics.Transaction_Management.exceptions.InsufficientFundsException;
import com.springBasics.Transaction_Management.models.Account;
import com.springBasics.Transaction_Management.models.Transaction;
import com.springBasics.Transaction_Management.services.AccountService;
import com.springBasics.Transaction_Management.services.TransactionService;
import com.springBasics.Transaction_Management.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    public AccountService accountService;
    @Autowired
    public TransferService transferService;
    @Autowired
    public TransactionService transactionService;

    @PostMapping("/bulk")
    public List<Account> createAll(@RequestBody List<Account> accounts){
        return accountService.createAccount(accounts);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber){
        return accountService.getAccount(accountNumber);
    }

    @PutMapping("/{accountNumber}/{amount}")
    public String  updateAccount(@PathVariable String accountNumber,@PathVariable BigDecimal amount){
        accountService.updateBalance(accountNumber,amount);
        return "Amount updated.";
    }

    @PostMapping("/transfer/{from}/{to}/{amount}")
    public String transaction(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) throws InsufficientFundsException {
        transferService.transfer(from,to,amount);
        return "Amount transferred successfully.";
    }

    @GetMapping("/log")
    public List<Transaction> getAllLogs(){
        return transactionService.getTransaction();
    }

}
