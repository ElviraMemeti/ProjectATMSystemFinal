package com.example.ProjectATMSystem.repository;

import com.example.ProjectATMSystem.pojo.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountRepositoryFile {

    private static final String ACCOUNT_FILE = "account.csv";


    static ArrayList<Account> accountData = new ArrayList<>();




    public ArrayList<Account> findAll() {
        accountData = readFromFile();
        return accountData;
    }

    public Account findOneById(Integer id) {
        accountData = readFromFile();

        for (Account account: accountData) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    private Boolean exists(Integer id) {
        accountData = readFromFile();
        for (Account account: accountData) {
            if (account.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Account save(Account account) {
        accountData = readFromFile();

        if (exists(account.getId())) {
            System.out.println("Already exists!");
            return null;
        }
        accountData.add(account);
        writeToFile(accountData);

        return account;
    }

    public void delete(Integer id) {
        accountData = readFromFile();
        for (Account account: accountData) {
            if (account.getId().equals(id)) {
                accountData.remove(account);
                writeToFile(accountData);
            }
        }
    }



    public double checkBalance(Integer id){
        accountData=readFromFile();
        double blc=0;
        for (Account account:accountData)
        {
            if (account.getId().equals(id)){
                account.checkBalance(id);
                writeToFile(accountData);
                blc=account.checkBalance(id);
            }
        }

            return blc;
    }



    public void makeWithdrawal(Integer id, Double amount)
    {
        accountData=readFromFile();
        for (Account account: accountData)
        {
            if(account.getId().equals(id))
            {
                account.makeWithdrawal(id, amount);
                    writeToFile(accountData);
            }
        }
    }





    public void makeDeposit(Integer id, Double amount)
    {
        accountData=readFromFile();
        for (Account account: accountData)
        {
            if (!exists(account.getId())) {
                System.out.println("Does not exists!");

            }
            if (account.getId().equals(id))
            {
                account.makeDeposit(id, amount);
                writeToFile(accountData);
            }
        }
    }



    private void writeToFile(ArrayList<Account> accounts) {
        try {
            FileWriter writer = new FileWriter(ACCOUNT_FILE);

            for (Account account: accounts) {
                writer.write(account.toString());
                writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Something wrong happened!");
            e.printStackTrace();
        }
    }

    private static ArrayList<Account> readFromFile() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            File file = new File(ACCOUNT_FILE);
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String row = reader.nextLine();

                String[] Data = row.split(",");
                Account account = new Account();

                account.setId(Integer.valueOf(Data[0]));
                account.setUsername(Data[1]);
                account.setPassword(Data[2]);
                account.setBalance(Double.valueOf(Data[3]));
                account.setAccountNumber(Integer.valueOf(Data[4]));

                accounts.add(account);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }

        return accounts;
    }

















}
