/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skyla
 */
public class PrivatePaymentLogs {
    private User user;
    private ArrayList<Transaction> transactions;
    
    public PrivatePaymentLogs(User user) {
        this.user = user;
        this.transactions = new ArrayList<>();
    }
    
    public void addTransaction(Transaction transaction) {
        // logic to add a confirmed transaction to the list
    }
    
    public void display() {
        // logic to display all confirmed transactions the user has made or received
    }
}
