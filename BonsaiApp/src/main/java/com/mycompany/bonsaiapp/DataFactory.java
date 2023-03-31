/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataFactory implements Serializable{
    
    private HashMap<String, User> users;
    private ArrayList<Transaction> transactions;

    public DataFactory() {
        BuildUsers();
        BuildTransactions();
    }
    
    private void BuildUsers(){
         try { 
            users = new HashMap<>();
            Scanner file = new Scanner(new File("DataSample" + File.separator + "UserCSV.txt"));

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
                double credit = 0;
                double debt = 0;
                ArrayList<Transaction> userTransactions = new ArrayList<>();
                User user = new User(username, displayName, password, credit, debt, userTransactions);
                users.put(password, user);
            }
         }
        catch (FileNotFoundException ex) {
            System.out.println("ERROR: Users TXT file not found");
        }
    }


    private void BuildTransactions() {
        try{
            transactions = new ArrayList<>();
            Scanner file = new Scanner(new File("DataSample" + File.separator + "TransactionCSV.txt"));
            // First line of pre load file is column headers.  Skips line 1 so that
            // data is read beginnng with line 2
            file.nextLine();
            while(file.hasNextLine()){
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
        }
        catch (FileNotFoundException ex) {
            System.out.println("ERROR: Transactions TXT file not found");
        }
    }
    
    public BonsaiManagerModel getModel(){
        return new BonsaiManagerModel(users, transactions);
    }
}