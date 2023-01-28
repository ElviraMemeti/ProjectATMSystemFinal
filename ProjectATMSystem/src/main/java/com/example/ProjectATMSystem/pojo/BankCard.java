package com.example.ProjectATMSystem.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Calendar;
@Entity
@Table(name = "bankCard")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "card_number")
    private Integer cardNumber;
    @Column(name = "card_type")
    private CardType cardType;
    @Column(name = "expiration_date")
    private String expirationDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;



    public BankCard() {
    }

    public BankCard(Integer id, Integer cardNumber, CardType cardType, String expirationDate, Account account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardType=" + cardType +
                ", expirationDate=" + expirationDate +
                ", account=" + account +
                '}';
    }
}
