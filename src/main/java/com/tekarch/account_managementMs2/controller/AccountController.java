package com.tekarch.account_managementMs2.controller;

import com.tekarch.account_managementMs2.models.Account;
import com.tekarch.account_managementMs2.services.AccountServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountServiceImpl accountsServiceImpl;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountsServiceImpl.getAllAccounts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountsServiceImpl.addAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account createdAccount = accountsServiceImpl.updateAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountsServiceImpl.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        if(!accountsServiceImpl.getAccountById(id).getAccountId().equals(0L)) {
            accountsServiceImpl.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
    //    boolean isDeleted = accountsServiceImpl.deleteAccount(id);
    //    if(isDeleted) {
    //        return ResponseEntity.ok("Account deleted successfully.");
    //    }
    //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");


    }
}
