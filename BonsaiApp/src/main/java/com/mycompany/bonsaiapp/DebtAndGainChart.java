/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonsaiapp;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
//is not working, need to be fixed
import org.jfree.chart.ChartFactory;
/**
 *
 * @author skyla
 */
public class DebtAndGainChart {

    private Map<String, Integer> debt;
    private Map<String, Integer> gain;

    public DebtAndGainChart() {
        debt = new HashMap<>();
        gain = new HashMap<>();
    }

    public void addDebt(String username, int amount) {
        debt.put(username, debt.getOrDefault(username, 0) + amount);
    }

    public void addGain(String username, int amount) {
        gain.put(username, gain.getOrDefault(username, 0) + amount);
    }

    public int getDebt(String username) {
        return debt.getOrDefault(username, 0);
    }

    public int getGain(String username) {
        return gain.getOrDefault(username, 0);
    }

    public Map<String, Integer> getDebtMap() {
        return debt;
    }

    public Map<String, Integer> getGainMap() {
        return gain;
    }

    //ALL OF THE ERRORS ARE COMING FROM THE IMPORT - CHARTFACTORY CANNOT BE IMPORTED
    public void createChart() {
        // Create a chart object
        JFreeChart chart = ChartFactory.createBarChart(
            "Debt and Gain Chart", // chart title
            "Username", // x-axis label
            "Debt or Gain", // y-axis label
            getDebtMap(), // data
            PlotOrientation.VERTICAL, // orientation
            true, // include legend
            true, // tooltips
            false // urls
        );

        // Set the chart's title
        chart.setTitle("Debt and Gain Chart");

        // Set the x-axis label
        chart.getXYPlot().getDomainAxis().setLabel("Username");

        // Set the y-axis label
        chart.getXYPlot().getRangeAxis().setLabel("Debt or Gain");

        // Set the chart's size
        chart.setPreferredSize(new Dimension(800, 600));

        // Display the chart
        JOptionPane.showMessageDialog(null, chart);
    }
}