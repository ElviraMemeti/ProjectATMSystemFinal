package com.example.ProjectATMSystem.pojo;

public class CreateInputATM {
    private Integer id;
    private String bank;
    private String location;

    public CreateInputATM(Integer id, String bank, String location) {
        this.id = id;
        this.bank = bank;
        this.location = location;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreateInputATM{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
