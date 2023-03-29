/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author skyla
 */
public class DataFactory {
    
    private HashMap<String, User> users;
    private ArrayList<Transaction> transactions;

    public DataFactory() throws IOException {
        BuildUsers();
        BuildTransactions();
    }

    //TEST ID WE NEED THEM AT ALL
    public void saveUsers(List<User> users) throws IOException {
        //This method will save all of the users that you could locallcy create or save 
        //and it writes of the NEW users into the csv file (Working as writeData from CSVhandler) 
        ArrayList<String[]> data = new ArrayList<>();
        for (User user : users) {
            String[] row = { user.getName(), user.getDisplayName(), user.getPassword(), Double.toString(user.getCredit()), Double.toString(user.getDebt()) };
            data.add(row);
        }
        //csvHandler.writeData(data); directly write the data into the csv files
    }
    
    //TEST ID WE NEED THEM AT ALL
    public void saveTransactions(List<Transaction> transactions) throws IOException {
        //This method will save all of the transaction info that you could locallcy create or save 
        //and it writes of the NEW transactions into the csv file (Working as writeData from CSVhandler) 
        ArrayList<String[]> data = new ArrayList<>();
        for (Transaction transaction : transactions) {
            String[] row = { transaction.getUserNameFrom(), transaction.getTransactionType(), Double.toString(transaction.getAmount()), transaction.getUserNameTo(), transaction.getReason(), transaction.getDate(), transaction.getTime() };
            data.add(row);
        }
        //csvTransaction.writeData(data); manually save transactions into the csv files
    }
    
    public void BuildUsers(){
         try { 
            users = new HashMap<>();
            Scanner file = new Scanner(new File("DataSample" + File.separator + "UserCSV.txt"));

            // FIrst line of dat file is column headers.  Skips line 1 so that
            // data is read beginnng with line 2
            file.nextLine();

            while (file.hasNextLine()) {
                String lineData = file.nextLine();

                Scanner line = new Scanner(lineData);
                line.useDelimiter("\t");

                String username = line.next();
                String displayName = line.next();
                String password = line.next();
                double credit = 0;
                double debt = 0;
                ArrayList<Transaction> transactions = new ArrayList<>();
                User user = new User(username, displayName, password, credit, debt, transactions);
                users.put(password, user);
            }
         }
        catch (FileNotFoundException ex) {
            System.out.println("ERROR: Badges dat file not found");
        }
    }


    public void BuildTransactions() throws IOException {
        try{
            transactions = new ArrayList<Transaction>();
            Scanner file = new Scanner(new File("DataSample" + File.separator + "TransactionCSV.txt"));
            // FIrst line of dat file is column headers.  Skips line 1 so that
            // data is read beginnng with line 2
            file.nextLine();
            while(file.hasNextLine()){
            String lineData = file.nextLine();

            Scanner line = new Scanner(lineData);
            line.useDelimiter("\t");
            
            String userNameFrom = line.next();
            String transactionType = line.next();
            double amount = Double.parseDouble(line.next());
            String userNameTo = line.next();
            String reason = line.next();
            String date = line.next();
            String time = line.next();
            Boolean done = line.nextBoolean();
            
            Transaction transaction = new Transaction(userNameFrom, transactionType, amount, userNameTo, reason, date, time, done);
            transactions.add(transaction);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("ERROR: Badges dat file not found");
        }
    }
    
    public BonsaiManagerModel getModel(){
        return new BonsaiManagerModel(users, transactions);
    }
}