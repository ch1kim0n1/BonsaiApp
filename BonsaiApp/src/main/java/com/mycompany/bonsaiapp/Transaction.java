/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

/**
 *
 * @author alejandrodiaz
 */
public class Transaction {
    //this class will contain transaction and all corresponding info in correct order
    //you can create and modify transactions if you want, but need to be careful as 
    //some of the setters are not suppose to be here, and I dont know which exactly
    //From -> type -> amount -> To -> reason -> date -> time(Current?)
    
    private String userNameFrom;
    private String transactionType;
    private double amount;
    private String userNameTo;
    private String reason;
    private String date;
    private String time;

    public Transaction(String userNameFrom, String transactionType, double amount, String userNameTo, String reason, String date, String time) {
        this.userNameFrom = userNameFrom;
        this.transactionType = transactionType;
        this.amount = amount;
        this.userNameTo = userNameTo;
        this.reason = reason;
        this.date = date;
        this.time = time;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUserNameTo() {
        return userNameTo;
    }

    public void setUserNameTo(String userNameTo) {
        this.userNameTo = userNameTo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
