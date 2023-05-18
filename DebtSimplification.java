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
 
    //this is the main function that will run all of the methods that will build, simplify and update tranastion data
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

        //this loop compaers logged username and every other username that was included in transaction log
        //in order to include only transactions where specific user was involved
        for (Transaction t : allTransactions) {
            if (t.getUserNameFrom().equals(name)) {
                userTransactions.add(t);
            }
            if (t.getUserNameTo().equals(name)) {
                userTransactions.add(t);
            }
        }
    }

    private void buildDueTransactions() {
        //finds all transactions that are not done, and require the user
        //to make a payment

        
        //this loop compaers logged username and every other username that was included in transaction log
        //in order to include only DUE transactions where specific user was involved
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

    private void buildDoneTransactions() {
        //iterates through all transactions relating to the user, finding any complete ones
        
        //this loop compaers logged username and every other username that was included in transaction log
        //in order to include only DONE transactions where specific user was involved
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
