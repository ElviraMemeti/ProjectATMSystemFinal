package com.example.ProjectATMSystem.pojo;

import javax.persistence.Column;
import java.util.Calendar;

public class CreateInputCard {

    private Integer id;
    private Integer cardNumber;
    private CardType cardType;
    private String expirationDate;

    public CreateInputCard(Integer id, Integer cardNumber, CardType cardType, String expirationDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
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

    @Override
    public String toString() {
        return "CreateInputCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardType=" + cardType +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
