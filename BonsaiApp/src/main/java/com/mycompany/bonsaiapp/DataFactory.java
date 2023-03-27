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

    public DataFactory(CSVhandler csvHandler, CSVhandler csvTransaction) {
        //two scvhandler will be for 2 files we have to store our data in (Users and transactions)
        this.csvHandler = csvHandler;
        //Transaciton is not yet used
        this.csvTransaction = csvTransaction;
    }

    public ArrayList<User> getUsers() throws IOException {
        //This method takes the csvhandler from User and takes all of them and stores at specific order
        //Username -> Display Name -> Passowrd
        ArrayList<User> users = new ArrayList<>();
        List<String[]> data = csvHandler.readData();//uses readData to get all the data(Switch to arraylist)
        //when trying to switch to ArrrayList it gives me an error
        for (String[] row : data) {
            //Order of things its trying to record in array list
            String name = row[0];
            String displayName = row[1];
            String password = row[2];
            //2 new variables for stats
            double credit = Double.parseDouble(row[3]);
            double debt = Double.parseDouble(row[4]);
            ArrayList<Transaction> transactions = new ArrayList<>();
            //creates a user object
            User user = new User(name, displayName, password, credit, debt, transactions);
            users.add(user);
        }
        return users;
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

    public ArrayList<Transaction> getTransactions() throws IOException {
        //This method is reading Transaction CSV file and getting all the data and record it 
        //as arraylist within correct order as in CSV file
        ArrayList<Transaction> transactions = new ArrayList<>();
        List<String[]> data = csvHandler.readData(); //From CSVhandler
        for (String[] row : data) {
            String userNameFrom = row[0];
            String transactionType = row[1];
            //new variable amount
            double amount = Double.parseDouble(row[2]);
            String userNameTo = row[3];
            String reason = row[4];
            String date = row[5];
            String time = row[6];
            Transaction transaction = new Transaction(userNameFrom, transactionType, amount, userNameTo, reason, date, time);
            transactions.add(transaction);
        }
        //return full list of data about a transaction info
        return transactions;
    }

    public void saveTransactions(List<Transaction> transactions) throws IOException {
        //This method will save all of the transaction info that you could locallcy create or save 
        //and it writes of the NEW transactions into the csv file (Working as writeData from CSVhandler) 
        ArrayList<String[]> data = new ArrayList<>();
        for (Transaction transaction : transactions) {
            String[] row = { transaction.getUserNameFrom(), transaction.getTransactionType(), Double.toString(transaction.getAmount()), transaction.getUserNameTo(), transaction.getReason(), transaction.getDate(), transaction.getTime() };
            data.add(row);
        }
        csvHandler.writeData(data);
    }
}