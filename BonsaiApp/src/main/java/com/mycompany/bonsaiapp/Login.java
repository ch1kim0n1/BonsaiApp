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
public class Login {
    private ArrayList<User> users;

    public Login(ArrayList<User> users) {
        this.users = users;
    }

    public User validateUser(String userName, String password) {
        //Very simple logic for the login information
        //CHANGE as GUI will be developed
        for (User user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
