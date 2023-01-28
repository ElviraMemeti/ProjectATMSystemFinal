package com.example.ProjectATMSystem.service;

import com.example.ProjectATMSystem.pojo.ATM;
import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.CreateInputAccount;
import com.example.ProjectATMSystem.repository.ATMRepository;
import com.example.ProjectATMSystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAccountService implements AccountService{

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ATMRepository atmRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findOneById(Integer id) {
        return accountRepository.findOneById(id);
    }

    @Override
    public Account createAccount(Integer ATMid, CreateInputAccount input) {
        ATM atm = atmRepository.findAtmById(ATMid);


        Account account = new Account();
        account.setUsername(input.getUsername());
        account.setPassword(input.getPassword());
        account.setBalance(input.getBalance());
        account.setAccountNumber(input.getAccountNumber());
        account.setAtm(atm);
        return accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
      accountRepository.deleteById(id);
    }

    @Override
    public double checkBalance(Integer id) {
        Account account = accountRepository.findOneById(id);
//        if (account != null) {
//            account.checkBalance(id);
//            accountRepository.save(account);
//        }
        return account.checkBalance(id);
    }

    @Override
    public void makeDeposit(Integer id, Double amount) {

        Account account = accountRepository.findOneById(id);
        account.makeDeposit(id, amount);
        accountRepository.save(account);


    }

    @Override
    public void makeWithdrawal(Integer id, Double amount) {
        Account account = accountRepository.findOneById(id);
        account.makeWithdrawal(id, amount);
        accountRepository.save(account);
    }
}
