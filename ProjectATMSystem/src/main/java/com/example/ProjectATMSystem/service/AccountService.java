package com.example.ProjectATMSystem.service;

import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.CreateInputATM;
import com.example.ProjectATMSystem.pojo.CreateInputAccount;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();
    public Account findOneById(Integer id);
    public Account createAccount(Integer ATMid, CreateInputAccount input);

    public void delete(Integer id);
    public double checkBalance(Integer id);
    public void makeDeposit(Integer id, Double amount);
    public void makeWithdrawal(Integer id, Double amount);

}
