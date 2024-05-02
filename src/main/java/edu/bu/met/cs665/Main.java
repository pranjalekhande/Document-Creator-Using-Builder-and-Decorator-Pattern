/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: Main.java
 * Description: Main class to demonstrate the use of ReportGenerator and ReportBuilder.
 */

package edu.bu.met.cs665;
import edu.bu.met.cs665.builder.ReportType;
import edu.bu.met.cs665.models.Report;
import edu.bu.met.cs665.services.ReportGenerator;
import edu.bu.met.cs665.builder.ReportBuilder;
import edu.bu.met.cs665.builder.ReportBuilderImpl;

/**
 * This is the Main class.
 */
public class Main {
  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {

    ReportGenerator generator = ReportGenerator.getInstance();

    Report pdfReport = generator.generateReport(ReportType.PDF);
    System.out.println("PDF Report:");
    pdfReport.getComponents().forEach(System.out::println);

    Report htmlReport = generator.generateReport(ReportType.HTML);
    System.out.println("\nHTML Report:");
    htmlReport.getComponents().forEach(System.out::println);

    Report excelReport = generator.generateReport(ReportType.EXCEL);
    System.out.println("\nExcel Report:");
    excelReport.getComponents().forEach(System.out::println);



    // Using ReportBuilder directly
    ReportBuilder builder = new ReportBuilderImpl();
    Report customReport = builder
            .setReportType(ReportType.HTML)
            .addChart()
            .addText("Custom Text Section")
            .addTable()
            .build();

    System.out.println("\nCustom HTML Report (Built using ReportBuilder):");
    customReport.getComponents().forEach(System.out::println);


    Report reportWithFontColor = builder
            .setReportType(ReportType.PDF)
            .addChart()
            .addTable()
            .addText("Sample Text")
            .addFontDecorator("Italic") // Add font decorator
            .addColorDecorator("Red") // Add color decorator
            .build();

    System.out.println("\nCustom PDF Report (Built using ReportBuilder):");
    reportWithFontColor.getComponents().forEach(System.out::println);


    Report bigReport = builder
            .setReportType(ReportType.PDF)
            .addChart()
            .addText("Custom Text Section")
            .addColorDecorator("Blue") // Used this to Apply blue color
            .addTable()
            .addChart()
            .addFontDecorator("Italic") // Used this to Apply italic font
            .addTable()
            .addText("Sample Text")
            .addColorDecorator("Red")
            .addFontDecorator("Bold")
            .addFontDecorator("Arial")
            .build();

    System.out.println("\nCustom Big PDF Report (Built using ReportBuilder):");
    bigReport.getComponents().forEach(System.out::println);

  }

}
