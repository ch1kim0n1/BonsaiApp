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
    private ArrayList<Transaction> reducedTransactions;
    private ArrayList<Transaction> dueTransactions;
    private ArrayList<Transaction> doneTransactions;

    public DebtSimplification(User u, ArrayList<Transaction> t) {
        //Debt simplification class passes in the logged in user's password
        //and all the transactions that exist.
        
        user = u;
        allTransactions = t;
        name = user.getUserName();
        
        buildUserTransactions();
        buildDueTransactions();
        buildDoneTransactions();
        
        u.setUserTransactions(userTransactions);
        u.setReducedTransactions(reducedTransactions);
        u.setDueTransactions(dueTransactions);
        u.setDoneTransactions(doneTransactions);
        
    }

    private void buildUserTransactions() {
        //this method will filter all Bonsai transactions to only the user's transactions
        
        for (Transaction t : allTransactions) {
            if (t.getUserNameFrom().equals(name))
                userTransactions.add(t);
            if (t.getUserNameTo().equals(name))
                userTransactions.add(t);
        }
    }
    
    /*private void buildReducedTransactions() {
        String name = user.getName();
        
        for(Transaction t : userTransactions) {
        }
    }*/
    
    private void buildDueTransactions() {
        
        for (Transaction t : allTransactions) {
            if(t.getUserNameFrom().equals(name) &&
               t.getTransactionType().equals("Owe") &&
               !t.isDone())
                dueTransactions.add(t);
            
            else if(t.getUserNameTo().equals(name) && 
                    t.getTransactionType().equals("Request") && 
                    !t.isDone())
                dueTransactions.add(t);
        }
    }
    
    private void buildDoneTransactions() {
        for (Transaction t : userTransactions) {
            if(t.isDone() && t.getUserNameFrom().equals(name))
                doneTransactions.add(t);
            if(t.isDone() && t.getUserNameTo().equals(name))
                doneTransactions.add(t);
        }
    }
}