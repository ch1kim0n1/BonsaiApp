/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        users.add(user);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> simplifyDebts() {
        ArrayList<Transaction> simplifiedTransactions = new ArrayList<>();

        // Calculate debts and credits for each user
        for (User user : users) {
            double debt = 0.0;
            double credit = 0.0;

            for (Transaction transaction : transactions) {
                if (transaction.getUserNameFrom().equals(user.getName())) {
                    debt += transaction.getAmount();
                } else if (transaction.getUserNameTo().equals(user.getName())) {
                    credit += transaction.getAmount();
                }
            }

            user.setDebt(debt);
            user.setCredit(credit);
        }

        // Generate simplified transactions
        while (true) {
            User debtor = getHighestDebtor();
            User creditor = getHighestCreditor();

            if (debtor == null || creditor == null) {
                break;
            }

            double amount = Math.min(debtor.getDebt(), creditor.getCredit());
            debtor.setDebt(debtor.getDebt() - amount);
            creditor.setCredit(creditor.getCredit() - amount);

            Transaction simplifiedTransaction = new Transaction(
                    debtor.getName(),
                    "Payment",
                    amount,
                    creditor.getName(),
                    "Simplified debt",
                    "Today",
                    "Now");

            simplifiedTransactions.add(simplifiedTransaction);
        }

        return simplifiedTransactions;
    }

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