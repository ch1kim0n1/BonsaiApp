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

    public DataFactory(CSVhandler csvHandler) {
        this.csvHandler = csvHandler;
    }

    public List<User> getUsers() throws IOException {
        List<User> users = new ArrayList<>();
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

    public void saveUsers(List<User> users) throws IOException {
        List<String[]> data = new ArrayList<>();
        for (User user : users) {
            String[] row = { user.getName(), user.getDisplayName(), user.getPassword(), Double.toString(user.getCredit()), Double.toString(user.getDebt()) };
            data.add(row);
        }
        csvHandler.writeData(data);
    }

    public List<Transaction> getTransactions() throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        List<String[]> data = csvHandler.readData();
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

    public void saveTransactions(List<Transaction> transactions) throws IOException {
        List<String[]> data = new ArrayList<>();
        for (Transaction transaction : transactions) {
            String[] row = { transaction.getUserNameFrom(), transaction.getTransactionType(), Double.toString(transaction.getAmount()), transaction.getUserNameTo(), transaction.getReason(), transaction.getDate(), transaction.getTime() };
            data.add(row);
        }
        csvHandler.writeData(data);
    }
}