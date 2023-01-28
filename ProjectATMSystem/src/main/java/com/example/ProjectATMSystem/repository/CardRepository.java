package com.example.ProjectATMSystem.repository;


import com.example.ProjectATMSystem.pojo.BankCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<BankCard, Integer> {
    public List<BankCard> findAll();
    public BankCard findOneById(Integer id);
}
