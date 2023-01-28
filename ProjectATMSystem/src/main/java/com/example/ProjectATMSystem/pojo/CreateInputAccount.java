package com.example.ProjectATMSystem.pojo;

public class CreateInputAccount {
    private Integer id;

    private String username;
    private String password;
    private double balance;
    private Integer accountNumber;
    private double amount;

    public CreateInputAccount(Integer id, String username, String password, double balance, Integer accountNumber, double amount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Double toStringAmount()
    {
        return amount;
    }

    @Override
    public String toString() {
        return "CreateInputAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
