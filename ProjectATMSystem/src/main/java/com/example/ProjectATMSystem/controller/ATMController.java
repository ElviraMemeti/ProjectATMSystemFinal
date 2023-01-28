package com.example.ProjectATMSystem.controller;

import com.example.ProjectATMSystem.pojo.ATM;
import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.CreateInputATM;
import com.example.ProjectATMSystem.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class ATMController {
    @Autowired
    ATMService atmService;

    @PostMapping("/atm")
    public ATM createATM(@RequestBody CreateInputATM inputATM){
        Integer newAtmId = inputATM.getId();
        String newAtmBank =inputATM.getBank();
        String newAtmLocation = inputATM.getLocation();
       return atmService.createATM(newAtmId,newAtmBank,newAtmLocation);

    }

    @GetMapping("/atm")
    public List<ATM> findAll(){
        return atmService.findAll();
    }

    @GetMapping("/atm/{id}")
    public ATM findOneById(@PathVariable Integer id){
        return atmService.findOneById(id);
    }


    @GetMapping("/atm/findByLocation/{location}")
    public List<ATM> findAtmByLocation(@PathVariable String location){
        return atmService.findAtmByLocation(location);
    }

    @DeleteMapping("/atm/{id}")
    public void delete(@PathVariable Integer id){
        atmService.delete(id);
    }


}
