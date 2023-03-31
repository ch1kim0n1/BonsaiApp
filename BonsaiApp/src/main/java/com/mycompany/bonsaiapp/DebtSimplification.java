/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;
import java.util.ArrayList;
//For now we are not using hashmap or map, but we will need it later
//DO NOT DELETE
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author skyla
 */
public class DebtSimplification {
    private ArrayList<Transaction> transactions;
    private ArrayList<User> users;

    public DebtSimplification() {
        this.transactions = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        //add users into the list
        users.add(user);
    }

    public void addTransaction(Transaction transaction) {
        //add transaction into the list
        transactions.add(transaction);
    }

    public ArrayList<Transaction> simplifyDebts() {
        //this method will simplify dept with the logic of (You owe me 10 and I owe you 10, lets simplify to 0 for each)
        ArrayList<Transaction> simplifiedTransactions = new ArrayList<>();

        // Calculate debts and credits for each user
        for (User user : users) {
            //probably need double to calculate with cents (May switch to int)
            double debt = 0.0;
            double credit = 0.0;
            //To clarify:
            //Credit - Money that other owe the user
            //Debt - Money that user owe to someone
            
            //This loop collects credit and dept from a user and makes them as 2 different objects
            for (Transaction transaction : transactions) {
                if (transaction.getUserNameFrom().equals(user.getName())) {
                    debt += transaction.getAmount();
                } else if (transaction.getUserNameTo().equals(user.getName())) {
                    credit += transaction.getAmount();
                }
            }
            
            //passing the value to the user
            user.setDebt(debt);
            user.setCredit(credit);
        }

        // Generate simplified transactions
        while (true) {
            //getting the numbers
            User debtor = getHighestDebtor();
            User creditor = getHighestCreditor();

            if (debtor == null || creditor == null) {
                //we dont want to do anything if people dont owe anything to each other
                break;
            }
               
            //picking the lowest number as we are simplfying from 10 and 5 we pick 5 to simplify for both
            double amount = Math.min(debtor.getDebt(), creditor.getCredit());
            //set new values to the debtor and creditor
            debtor.setDebt(debtor.getDebt() - amount);
            creditor.setCredit(creditor.getCredit() - amount);

            //we record new transaction for dashboard (NOT logs as there are only completed transactions)
            Transaction simplifiedTransaction = new Transaction(
                    debtor.getName(),
                    "Payment",
                    amount,
                    creditor.getName(),
                    "Simplified debt",
                    "Today",
                    "Now", true);

            simplifiedTransactions.add(simplifiedTransaction);
        }
        //return recorded transaction
        return simplifiedTransactions;
    }

    
    //two loops bellow to determine the highest debtor and highest creditor
    //Probably need to change later because we dont need to simplify debt of 2 random people
    private User getHighestDebtor() {
        User highestDebtor = null;
        double highestDebt = 0.0;

        for (User user : users) {
            if (user.getDebt() > highestDebt) {
                highestDebtor = user;
                highestDebt = user.getDebt();
            }
        }

        return highestDebtor;
    }

    private User getHighestCreditor() {
        User highestCreditor = null;
        double highestCredit = 0.0;

        for (User user : users) {
            if (user.getCredit() > highestCredit) {
                highestCreditor = user;
                highestCredit = user.getCredit();
            }
        }

        return highestCreditor;
    }
}