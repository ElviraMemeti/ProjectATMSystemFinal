package com.example.ProjectATMSystem.service;

import com.example.ProjectATMSystem.pojo.ATM;
import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.BankCard;
import com.example.ProjectATMSystem.pojo.CreateInputCard;
import com.example.ProjectATMSystem.repository.AccountRepository;
import com.example.ProjectATMSystem.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultCardService implements CardService{

    @Autowired
    CardRepository cardRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<BankCard> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public BankCard findOneById(Integer id) {
        return cardRepository.findOneById(id);
    }

    @Override
    public BankCard createCard(Integer accountId, CreateInputCard input) {


        Account account = accountRepository.findOneById(accountId);


        BankCard bankCard = new BankCard();
        bankCard.setId(input.getId());
        bankCard.setCardNumber(input.getCardNumber());
        bankCard.setCardType(input.getCardType());
        bankCard.setExpirationDate(input.getExpirationDate());


        bankCard.setAccount(account);
        return cardRepository.save(bankCard);

    }

    @Override
    public void delete(Integer id) {
        cardRepository.deleteById(id);
    }
}
