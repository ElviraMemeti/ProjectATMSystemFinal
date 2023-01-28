package com.example.ProjectATMSystem.service;

import com.example.ProjectATMSystem.pojo.ATM;

import com.example.ProjectATMSystem.pojo.Account;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ATMService {


    public List<ATM> findAll();
    public ATM findOneById(Integer id);
    public void delete(Integer id);
    public ATM createATM(Integer id, String bank, String location);
    public List<ATM> findAtmByLocation(String location);
}
