package com.example.ProjectATMSystem.repository;

import com.example.ProjectATMSystem.pojo.ATM;
import com.example.ProjectATMSystem.pojo.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMRepositoryFile {

    private static final String ATM_FILE = "atm.csv";


    static ArrayList<ATM> atmsData = new ArrayList<>();




    public ArrayList<ATM> findAll() {
        atmsData = readFromFile();
        return atmsData;
    }

    public ATM findOneById(Integer id) {
        atmsData = readFromFile();

        for (ATM atm: atmsData) {
            if (atm.getId().equals(id)) {
                return atm;
            }
        }
        return null;
    }

    public List<ATM> findAtmByLocation(String location) {
        atmsData = readFromFile();
        List<ATM> matchingATMs = new ArrayList<ATM>();
        for (ATM atm : atmsData) {
            if (atm.getLocation().equals(location)) {
                matchingATMs.add(atm);
            }
        }
        return matchingATMs;
    }




    private Boolean exists(Integer id) {
        atmsData = readFromFile();
        for (ATM atm: atmsData) {
            if (atm.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public ATM save(ATM atm)
    {
        atmsData=readFromFile();

        atmsData.add(atm);
        writeToFile(atmsData);
        return atm;
    }


    public void delete(Integer id) {
        atmsData = readFromFile();
        for (ATM atm: atmsData) {
            if (atm.getId().equals(id)) {
                atmsData.remove(atm);
                writeToFile(atmsData);
            }
        }
    }

    private void writeToFile(ArrayList<ATM> atms) {
        try {
            FileWriter writer = new FileWriter(ATM_FILE);

            for (ATM atm: atms) {
                writer.write(atm.toString());
                writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Something wrong happened!");
            e.printStackTrace();
        }
    }

    private ArrayList<ATM> readFromFile() {
        ArrayList<ATM> atms = new ArrayList<>();
        try {
            File file = new File(ATM_FILE);
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String row = reader.nextLine();

                String[] Data = row.split(",");
                ATM atm = new ATM();

                atm.setId(Integer.valueOf(Data[0]));
                atm.setBank(Data[1]);
                atm.setLocation(Data[2]);

                atms.add(atm);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }

        return atms;
    }
}
