/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author skyla
 */
public class PersonalTransactionTargets {
    private User user;
    private Map<String, Double> targets; // Map to store targets with names and total amount owed
    
    public PersonalTransactionTargets(User user) {
        this.user = user;
        this.targets = new HashMap<>();
    }
    
    public void addTarget(String name, double amount) {
        targets.put(name, amount);
    }
    
    public void displayTargets() {
        System.out.println("Transaction Targets:");
        for (Map.Entry<String, Double> entry : targets.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

