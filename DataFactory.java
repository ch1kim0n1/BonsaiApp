/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DataFactory implements Serializable {

    public HashMap<String, User> users;
    public ArrayList<Transaction> transactions;

    Path pathU = Paths.get("UserCSV.txt");
    Path pathT = Path.of("TransactionCSV.txt");

    public DataFactory() {
        BuildUsers();
        BuildTransactions();
    }

    public String getPath() {
        return pathU + " " + pathT;
    }

    //This method will access the txt file and take the information about every user that is stored.
    //it will take udername, displayname, and password and include them into the User list
    //Path for the file is the same for eveyone, so you dont need to put path manually
    private void BuildUsers() {
        try {
            users = new HashMap<>();

            Scanner file = new Scanner(new File(pathU.toAbsolutePath() + ""));

            // First line of pre load file is column headers.  Skips line 1 so that
            // data is read beginnng with line 2
            file.nextLine();

            while (file.hasNextLine()) {
                String lineData = file.nextLine();

                Scanner line = new Scanner(lineData);
                line.useDelimiter("\t");

                String username = line.next();
                String displayName = line.next();
                String password = line.next();
                User user = new User(username, displayName, password);
                users.put(username, user);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: Users TXT file not found");
        }
    }

    //This method will access the txt file and take the information about every user that is stored.
    //it will take userfrom, type, amount, userto, reason, date, and done? and include them into the Transaction list
    //Path for the file is the same for eveyone, so you dont need to put path manually
    private void BuildTransactions() {
        try {
            transactions = new ArrayList<>();

            Scanner file = new Scanner(new File(pathT.toAbsolutePath() + ""));
            // First line of pre load file is column headers.  Skips line 1 so that
            // data is read beginnng with line 2
            file.nextLine();
            while (file.hasNextLine()) {
                String lineData = file.nextLine();

                Scanner line = new Scanner(lineData);
                line.useDelimiter("\t");

                String userNameFrom = line.next();
                String transactionType = line.next();
                double amount = Double.parseDouble(line.next());
                String userNameTo = line.next();
                String reason = line.next();
                String date = line.next();
                String time = line.next();
                Boolean done = line.nextBoolean();

                Transaction transaction = new Transaction(userNameFrom, transactionType, amount, userNameTo, reason, date, time, done);
                transactions.add(transaction);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: Transactions TXT file not found");
        }
    }

    //this function will take collected information about users and take only their usernames
    //later needed for login verification
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        for (User user : users.values()) {
            usernames.add(user.getUserName());
        }
        return usernames;
    }

    public BonsaiManagerModel getModel() {
        return new BonsaiManagerModel(users, transactions);
    }
}
