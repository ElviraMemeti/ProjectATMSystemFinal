package com.example.ProjectATMSystem.controller;

import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.CreateInputAccount;

import com.example.ProjectATMSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/account/{id}")
    public Account findOneById(@PathVariable Integer id){
        return accountService.findOneById(id);
    }

    @PostMapping("/account/atm/{ATMid}")
    public Account createAccount(@PathVariable Integer ATMid, @RequestBody CreateInputAccount input)
    {
        return accountService.createAccount(ATMid,input);
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable Integer id){
        accountService.delete(id);
    }

    @GetMapping("/account/balance/{id}")
    double checkBalance(@PathVariable Integer id){
       return accountService.checkBalance(id);
    }

    @PutMapping("/account/deposit/{id}")
    void makeDeposit(@PathVariable Integer id, @RequestParam Double amount){
        if(amount != null){
            accountService.makeDeposit(id, amount);
        }
    }

    @PutMapping("/account/withdraw/{id}")
    void makeWithdrawal(@PathVariable Integer id,  @RequestParam Double amount){
        if (amount !=null) {
            accountService.makeWithdrawal(id, amount);
        }
    }
}
