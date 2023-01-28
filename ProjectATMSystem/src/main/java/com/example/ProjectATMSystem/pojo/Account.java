package com.example.ProjectATMSystem.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Integer id;
@Column(name = "username")
    private String username;
@Column(name = "password")
    private String password;
@Column(name = "balance")
    private double balance;
@Column(name = "account_number")
    private Integer accountNumber;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<BankCard> bankCards;

    @ManyToOne
    @JoinColumn(name = "atm_id")
    @JsonBackReference
    private ATM atm;

    public Account(Integer id, String username, String password, double balance, Integer accountNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }


    public double checkBalance(Integer id)
    {
        return this.balance;
    }


    public void makeWithdrawal(Integer id, Double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + this.balance);
        }
    }

    public void makeDeposit(Integer id, Double amount) {
        if (amount<=0)
        {
            System.out.println("Invalid amount!");
        }
        this.balance += amount;
        System.out.println("Deposit successful. New balance: " + this.balance);
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
