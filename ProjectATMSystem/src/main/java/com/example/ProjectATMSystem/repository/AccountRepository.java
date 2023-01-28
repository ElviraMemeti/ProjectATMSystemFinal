package com.example.ProjectATMSystem.repository;

import com.example.ProjectATMSystem.pojo.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
   public List<Account> findAll();
   public Account findOneById(Integer id);
}
