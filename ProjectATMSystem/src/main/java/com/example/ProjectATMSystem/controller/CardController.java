package com.example.ProjectATMSystem.controller;

import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.BankCard;
import com.example.ProjectATMSystem.pojo.CreateInputAccount;
import com.example.ProjectATMSystem.pojo.CreateInputCard;
import com.example.ProjectATMSystem.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    CardService cardService;


    @GetMapping("/card")
    public List<BankCard> findAll(){
        return cardService.findAll();
    }

    @GetMapping("/card/{id}")
    public BankCard findOneById(@PathVariable Integer id){
        return cardService.findOneById(id);
    }

    @PostMapping("/card/account/{accountId}")
    public BankCard createCard(@PathVariable Integer accountId, @RequestBody CreateInputCard input)
    {
        return cardService.createCard(accountId,input);
    }

    @DeleteMapping("/card/{id}")
    public void delete(@PathVariable Integer id){
        cardService.delete(id);
    }

}
