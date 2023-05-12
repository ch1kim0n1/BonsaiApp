/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.ArrayList;

/**
 *
 * @author alejandrodiaz
 */
public class User {
    //The most important class of all, this class will store and will be able to change info about users
    // as their name, display name, password, and etc.
    //This class will be able to change values of dept and creadit towards other users
    //This class also will be able to store the Transaction list of the persons transactions(Accessable by key of his username)

    //TODO: delete some setters
    private String userName;
    private String displayName;
    private String password;
    private double credit;
    private double debt;
    private ArrayList<Transaction> userTransactions;
    private ArrayList<Transaction> reducedTransactions;
    private ArrayList<Transaction> dueTransactions;
    private ArrayList<Transaction> doneTransactions;

    public User(String userName, String displayName, String password, double credit, double debt, ArrayList<Transaction> ut,
            ArrayList<Transaction> rt, ArrayList<Transaction> dueT, ArrayList<Transaction> doneT) {
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.credit = credit;
        this.debt = debt;
        this.userTransactions = ut;
        this.reducedTransactions = rt;
        this.dueTransactions = dueT;
        this.doneTransactions = doneT;
    }

    public User(String userName, String displayName, String password) {
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.debt = 0;
        this.credit = 0;
        this.userTransactions = null;
        this.reducedTransactions = null;
        this.dueTransactions = null;
        this.doneTransactions = null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public ArrayList<Transaction> getReducedTransactions() {
        return reducedTransactions;
    }

    public ArrayList<Transaction> getDueTransactions() {
        return dueTransactions;
    }

    public ArrayList<Transaction> getDoneTransactions() {
        return doneTransactions;
    }

    public void setUserTransactions(ArrayList<Transaction> userTransactions) {
        this.userTransactions = userTransactions;
    }
    public ArrayList<Transaction> getUserTransactions(){
        return userTransactions;
    }

    public void setReducedTransactions(ArrayList<Transaction> reducedTransactions) {
        this.reducedTransactions = reducedTransactions;
    }

    public void setDueTransactions(ArrayList<Transaction> dueTransactions) {
        this.dueTransactions = dueTransactions;
    }

    public void setDoneTransactions(ArrayList<Transaction> doneTransactions) {
        this.doneTransactions = doneTransactions;
    }

}
