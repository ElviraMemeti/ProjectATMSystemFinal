package com.example.ProjectATMSystem.pojo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "atm")
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bank")
    private String bank;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "atm")
    @JsonManagedReference
    private List<Account> accounts;



    public ATM(Integer id, String bank, String location, List<Account> accounts) {
        this.id = id;
        this.bank = bank;
        this.location = location;
        this.accounts = accounts;

    }

    public ATM() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", location='" + location + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
