/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skyla
 */
public class DataFactory {
    private final CSVhandler csvHandler;
    private CSVhandler csvTransaction; //Modify and add to the methods as 2nd csv file

    public DataFactory(CSVhandler csvHandler, CSVhandler csvTransaction) throws IOException {
        //two scvhandler will be for 2 files we have to store our data in (Users and transactions)
        this.csvHandler = csvHandler;
        //Transaciton is not yet used
        this.csvTransaction = csvTransaction;
        BuildUsers();
        BuildTransactions();
    }

    public void saveUsers(List<User> users) throws IOException {
        //This method will save all of the users that you could locallcy create or save 
        //and it writes of the NEW users into the csv file (Working as writeData from CSVhandler) 
        ArrayList<String[]> data = new ArrayList<>();
        for (User user : users) {
            String[] row = { user.getName(), user.getDisplayName(), user.getPassword(), Double.toString(user.getCredit()), Double.toString(user.getDebt()) };
            data.add(row);
        }
        csvHandler.writeData(data);
    }

    public void saveTransactions(List<Transaction> transactions) throws IOException {
        //This method will save all of the transaction info that you could locallcy create or save 
        //and it writes of the NEW transactions into the csv file (Working as writeData from CSVhandler) 
        ArrayList<String[]> data = new ArrayList<>();
        for (Transaction transaction : transactions) {
            String[] row = { transaction.getUserNameFrom(), transaction.getTransactionType(), Double.toString(transaction.getAmount()), transaction.getUserNameTo(), transaction.getReason(), transaction.getDate(), transaction.getTime() };
            data.add(row);
        }
        csvTransaction.writeData(data);
    }
    
    public ArrayList<User> BuildUsers() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        List<String[]> data = csvHandler.readData();
        for (String[] row : data) {
            String name = row[0];
            String displayName = row[1];
            String password = row[2];
            double credit = Double.parseDouble(row[3]);
            double debt = Double.parseDouble(row[4]);
            ArrayList<Transaction> transactions = new ArrayList<>();
            User user = new User(name, displayName, password, credit, debt, transactions);
            users.add(user);
        }
        return users;
    }

    public ArrayList<Transaction> BuildTransactions() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        List<String[]> data = csvTransaction.readData();
        for (String[] row : data) {
            String userNameFrom = row[0];
            String transactionType = row[1];
            double amount = Double.parseDouble(row[2]);
            String userNameTo = row[3];
            String reason = row[4];
            String date = row[5];
            String time = row[6];
            Transaction transaction = new Transaction(userNameFrom, transactionType, amount, userNameTo, reason, date, time);
            transactions.add(transaction);
        }
        return transactions;
    }
}