/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: ReportBuilderImpl.java
 * Description: Concrete implementation of ReportBuilder.
 */
package edu.bu.met.cs665.builder;


import edu.bu.met.cs665.models.ColorDecoratorReport;
import edu.bu.met.cs665.models.FontDecoratorReport;
import edu.bu.met.cs665.models.Report;
public class ReportBuilderImpl implements ReportBuilder {

    private Report report;
    private ReportType reportType;

    public ReportBuilderImpl() {
        this.report = new Report();
    }

    @Override
    public ReportBuilder addChart() {
        report.addComponent("Chart");
        return this;
    }

    @Override
    public ReportBuilder addTable() {
        report.addComponent("Table");
        return this;
    }

    @Override
    public ReportBuilder addText(String text) {
        report.addComponent("Text: " + text);
        return this;
    }

    @Override
    public Report build() {
        return report;
    }

    @Override
    public ReportBuilder setReportType(ReportType type) {
        this.reportType = type;
        return this;
    }

    public ReportBuilder addFontDecorator(String fontStyle) {
        report = new FontDecoratorReport(report, fontStyle);
        return this;
    }

    @Override
    public ReportBuilder addColorDecorator(String color) {
        report = new ColorDecoratorReport(report, color);
        return this;
    }

}