package com.example.ProjectATMSystem.service;

import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.BankCard;
import com.example.ProjectATMSystem.pojo.CreateInputCard;

import java.util.List;

public interface CardService {

    public List<BankCard> findAll();
    public BankCard findOneById(Integer id);
    public BankCard createCard(Integer accountId, CreateInputCard input);

    public void delete(Integer id);
}
