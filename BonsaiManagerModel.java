/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author skyla
 */
public class BonsaiManagerModel {

    HashMap<String, User> user;
    ArrayList<Transaction> transaction;

    public BonsaiManagerModel(HashMap<String, User> user, ArrayList<Transaction> transaction) {
        this.user = user;
        this.transaction = transaction;
    }

}
