package com.example.ProjectATMSystem.repository;

import com.example.ProjectATMSystem.pojo.Account;
import com.example.ProjectATMSystem.pojo.BankCard;
import com.example.ProjectATMSystem.pojo.CardType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardRepositoryFile {
    private static final String CARD_FILE = "card.csv";


    static ArrayList<BankCard> cardData = new ArrayList<>();



    public ArrayList<BankCard> findAll() {
        cardData = readFromFile();
        return cardData;
    }

    public BankCard findOneById(Integer id) {
        cardData = readFromFile();

        for (BankCard bankCard: cardData) {
            if (bankCard.getId().equals(id)) {
                return bankCard;
            }
        }
        return null;
    }

    private Boolean exists(Integer id) {
        cardData = readFromFile();
        for (BankCard bankCard: cardData) {
            if (bankCard.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public BankCard save(BankCard bankCard) {
        cardData = readFromFile();

        if (exists(bankCard.getId())) {
            System.out.println("Already exists!");
            return null;
        }
        cardData.add(bankCard);
        writeToFile(cardData);

        return bankCard;
    }

    public void delete(Integer id) {
        cardData = readFromFile();
        for (BankCard bankCard: cardData) {
            if (bankCard.getId().equals(id)) {
                cardData.remove(bankCard);
                writeToFile(cardData);
            }
        }
    }


    private void writeToFile(ArrayList<BankCard> bankCards) {
        try {
            FileWriter writer = new FileWriter(CARD_FILE);

            for (BankCard bankCard: bankCards) {
                writer.write(bankCard.toString());
                writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Something wrong happened!");
            e.printStackTrace();
        }
    }

    private static ArrayList<BankCard> readFromFile() {
        ArrayList<BankCard> bankCards = new ArrayList<>();
        try {
            File file = new File(CARD_FILE);
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String row = reader.nextLine();

                String[] Data = row.split(",");
                BankCard bankCard = new BankCard();

                bankCard.setId(Integer.valueOf(Data[0]));
                bankCard.setCardNumber(Integer.valueOf(Data[1]));
                bankCard.setCardType(CardType.DEBIT);
                bankCard.setExpirationDate(Data[3]);

                bankCards.add(bankCard);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }

        return bankCards;
    }
}
