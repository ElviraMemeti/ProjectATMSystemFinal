package com.example.ProjectATMSystem.repository;

import com.example.ProjectATMSystem.pojo.ATM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ATMRepository extends CrudRepository<ATM, Integer> {
    public List<ATM> findAll();
    public ATM findAtmById(Integer id);
    List<ATM> findAtmByLocation(String location);
}
