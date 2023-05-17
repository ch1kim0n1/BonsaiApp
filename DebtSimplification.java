/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.ArrayList;

public class DebtSimplification {

    private User user;
    private String name;
    private ArrayList<Transaction> allTransactions;
    private ArrayList<Transaction> userTransactions;
    //private ArrayList<ReducedTransaction> reducedTransactions;
    private ArrayList<Transaction> dueTransactions;
    private ArrayList<Transaction> doneTransactions;

    public DebtSimplification(User u, ArrayList<Transaction> t) {
        //Debt simplification class passes in the logged in user's password
        //and all the transactions that exist.

        user = u;
        allTransactions = t;
        name = user.getUserName();
       
        userTransactions = new ArrayList<>();
        dueTransactions = new ArrayList<>();
        doneTransactions = new ArrayList<>();        

        buildUserTransactions();
        //buildReducedTransactions();
        buildDueTransactions();
        buildDoneTransactions();

        u.setUserTransactions(userTransactions);
        //u.setReducedTransactions(reducedTransactions);
        u.setDueTransactions(dueTransactions);
        u.setDoneTransactions(doneTransactions);
        
    }

    private void buildUserTransactions() {
        //this method will filter all Bonsai transactions to only the user's transactions

        for (Transaction t : allTransactions) {
            if (t.getUserNameFrom().equals(name)) {
                userTransactions.add(t);
            }
            if (t.getUserNameTo().equals(name)) {
                userTransactions.add(t);
            }
        }
    }
    
     private void UpdateUserTransactions(Transaction t) {
        //this method will filter all Bonsai transactions to only the user's transactions
        if (t.getUserNameFrom().equals(name)) {
            userTransactions.add(t);
        }
        else if (t.getUserNameTo().equals(name)) {
            userTransactions.add(t);
        }

    }

    /*private void buildReducedTransactions() {
        //This method will create the arraylist for the dashboard.
        //This is the starting list that shows compiled dues, reducing debts between 2 users
        //and stacking debts as well.

        //process starts by filtering all incomplete transactions
        ArrayList<Transaction> iuTransactions = new ArrayList<>();

        for (Transaction t : userTransactions) {
            if (!t.isDone()) {
                iuTransactions.add(t);
            }
        }
        
        //process creates custom transactions that exist only within the reduced transactions
        //arraylist.
        for (Transaction h : iuTransactions) {
            for (ReducedTransaction j : reducedTransactions) {
                if(h.getUserNameTo().equals(j.getUserName())
                   && h.getTransactionType().equals("Owe")) {
                    j.setAmount(j.getAmount() - h.getAmount());
                }
                else if (h.getUserNameTo().equals(j.getUserName())
                        && h.getTransactionType().equals("Request")) {
                    j.setAmount(j.getAmount() + h.getAmount());
                } 
        }
    }*/

    private void buildDueTransactions() {
        //finds all transactions that are not done, and require the user
        //to make a payment
        
        for (Transaction t : userTransactions) {
            if (t.getUserNameFrom().equals(name)
                    && t.getTransactionType().equals("owe")
                    && !t.isDone()) {
                dueTransactions.add(t);
            } else if (t.getUserNameTo().equals(name)
                    && t.getTransactionType().equals("request")
                    && !t.isDone()) {
                dueTransactions.add(t);
            }
        }
    }
    
    private void UpdateDueTransactions(Transaction t) {
        //finds all transactions that are not done, and require the user
        //to make a payment

        if (t.getUserNameFrom().equals(name)
                && t.getTransactionType().equals("owe")
                && !t.isDone()) {
            dueTransactions.add(t);
        } else if (t.getUserNameTo().equals(name)
                && t.getTransactionType().equals("request")
                && !t.isDone()) {
            dueTransactions.add(t);
        }
        
    }

    private void buildDoneTransactions() {
        //iterates through all transactions relating to the user, finding any complete ones
        for (Transaction t : userTransactions) {
            if (t.isDone() && t.getUserNameFrom().equals(name)) {
                doneTransactions.add(t);
            }
            if (t.isDone() && t.getUserNameTo().equals(name)) {
                doneTransactions.add(t);
            }
        }
    }
}
