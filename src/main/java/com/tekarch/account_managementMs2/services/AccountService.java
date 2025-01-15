package com.tekarch.account_managementMs2.services;

import com.tekarch.account_managementMs2.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    List<Account> getAllAccounts();
    Account getAccountById(Long accountId);
    Account addAccount(Account accounts);
    void deleteAccount(Long accountId);
    Account updateAccount(Account accounts);
}
