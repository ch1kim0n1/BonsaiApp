/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alejandrodiaz
 */
public class CSVhandler {
    private String csvFile;

    public CSVhandler(String csvFile) {
        this.csvFile = csvFile;
    }

    public ArrayList<String[]> readData() throws IOException {
         Scanner file = new Scanner(new File("DataSample" + File.separator + "UserCSV.csv"));
        //This method read CSV files and return you the content of the file you assigned as a String[]
        ArrayList<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line; //Probably need to skip first row
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); //splits all the data with comma
                records.add(values);
            }
        }
        return records; //return list of the valuses of the csv file
    }

    public void writeData(ArrayList<String[]> records) throws IOException {
        //This method will modify the CSV file and all all of the information you provide
        //NOTE: need to be careful of that you add because there is a specific order and this method dosent check it
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String[] record : records) {
                String line = String.join(",", record); //takes the same list that readData returns(Same format)
                //NOTE: if we want method to read it correctly we need to format it right
                writer.write(line + System.lineSeparator());
            }
        }
    }
}
