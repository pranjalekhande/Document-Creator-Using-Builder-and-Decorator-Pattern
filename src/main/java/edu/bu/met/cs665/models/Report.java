
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: Report.java
 * Description: Class representing a report.
 */
package edu.bu.met.cs665.models;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<String> components;

    public Report() {
        this.components = new ArrayList<>();
    }

    public void addComponent(String component) {
        components.add(component);
    }

    public List<String> getComponents() {
        return components;
    }

}
