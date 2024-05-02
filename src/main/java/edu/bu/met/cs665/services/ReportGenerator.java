
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: ReportGenerator.java
 * Description: Class for generating reports using the ReportBuilder.
 */
package edu.bu.met.cs665.services;


import edu.bu.met.cs665.builder.ReportBuilder;
import edu.bu.met.cs665.builder.ReportBuilderImpl;
import edu.bu.met.cs665.builder.ReportType;
import edu.bu.met.cs665.models.Report;


public class ReportGenerator {

    private static ReportGenerator instance;

    private ReportGenerator() {
    }

    public static synchronized ReportGenerator getInstance() {
        if (instance == null) {
            instance = new ReportGenerator();
        }
        return instance;
    }

    public Report generateReport(ReportType type) {
        ReportBuilder builder = new ReportBuilderImpl();
        Report report = builder.setReportType(type)
                .addChart()
                .addTable()
                .addText("Sample Text")
                .build();
        return report;
    }

}
