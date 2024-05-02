
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: ReportBuilder.java
 * Description: Interface for building reports in different formats.
 */
package edu.bu.met.cs665.builder;
import edu.bu.met.cs665.models.Report;

public interface ReportBuilder {
        public ReportBuilder addChart();
        public ReportBuilder addTable();
        public ReportBuilder addText(String text);
        public Report build();
        public ReportBuilder setReportType(ReportType type);
        ReportBuilder addFontDecorator(String fontStyle);
        ReportBuilder addColorDecorator(String color);
    }
