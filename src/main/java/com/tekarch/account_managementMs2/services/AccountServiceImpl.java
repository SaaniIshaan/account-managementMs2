package com.tekarch.account_managementMs2.services;

import com.tekarch.account_managementMs2.models.Account;
import com.tekarch.account_managementMs2.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountsRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${users.ms.url}")
    String url;

 //   String USER_SERVICE_URL = "http://localhost:8080/users";
 //   String FUND_TRANSFER_URL = "http://localhost:8082/transactions";

    @Override
    public List<Account> getAllAccounts() {
        return accountsRepository.findAll();
    }

    @Override
    public Account getAccountById(Long accountId) {
        return accountsRepository.findById(accountId).orElse(null);
    }

    @Override
    public Account addAccount(Account accounts) {
        return accountsRepository.save(accounts);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountsRepository.deleteById(accountId);
    }

    @Override
    public Account updateAccount(Account accounts) {
        return accountsRepository.save(accounts);
    }
}
