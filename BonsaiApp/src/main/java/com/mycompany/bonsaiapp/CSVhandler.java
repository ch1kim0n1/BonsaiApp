/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        ArrayList<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        }
        return records;
    }

    public void writeData(ArrayList<String[]> records) throws IOException {
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String[] record : records) {
                String line = String.join(",", record);
                writer.write(line + System.lineSeparator());
            }
        }
    }
}
