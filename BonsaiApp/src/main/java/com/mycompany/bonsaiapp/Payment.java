/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;
import java.time.LocalDateTime;

/**
 *
 * @author skyla
 */
public class Payment {
    //This class will be used to collect and create info about payments to create history about payments
    //this class can return and set new payments form user to user
    //TODO: add more methods to identify users
    
    private LocalDateTime dateTime;
    private String reason;
    private double amount;
    private User user;
    private User directedUser;

    public Payment(LocalDateTime dateTime, String reason, double amount, User user, User directedUser) {
        this.dateTime = dateTime;
        this.reason = reason;
        this.amount = amount;
        this.user = user;
        this.directedUser = directedUser;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getDirectedUser() {
        return directedUser;
    }

    public void setDirectedUser(User directedUser) {
        this.directedUser = directedUser;
    }
}