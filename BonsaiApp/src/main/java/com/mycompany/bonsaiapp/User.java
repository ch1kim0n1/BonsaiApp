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
    
    private String userName;
    private String displayName;
    private String password;
    private double credit;
    private double debt;
    private ArrayList<Transaction> transactions;

    public User(String userName, String displayName, String password,double credit, double debt, ArrayList<Transaction> t) {
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.credit = credit;
        this.debt = debt;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
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
}
