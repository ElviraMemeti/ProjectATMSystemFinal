package com.example.ProjectATMSystem.service;

import com.example.ProjectATMSystem.pojo.ATM;
import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultATMService implements ATMService {
    @Autowired
    ATMRepository atmRepository;

    @Override
    public List<ATM> findAll() {
        return atmRepository.findAll();
    }

    @Override
    public ATM findOneById(Integer id) {
        return atmRepository.findAtmById(id);
    }

    @Override
    public void delete(Integer id) {

        atmRepository.deleteById(id);
    }

    @Override
    public ATM createATM(Integer id, String bank, String location) {
        ATM atm=new ATM();
        atm.setBank(bank);
        atm.setLocation(location);
        return atmRepository.save(atm);
    }


    @Override
    public List<ATM> findAtmByLocation(String location) {
        return  atmRepository.findAtmByLocation(location);
    }

}
