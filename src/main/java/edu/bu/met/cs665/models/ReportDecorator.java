package edu.bu.met.cs665.models;



import java.util.List;

public abstract class ReportDecorator extends Report {
    protected Report report;

    public ReportDecorator(Report report) {
        this.report = report;
    }

    @Override
    public List<String> getComponents() {
        return report.getComponents();
    }

    @Override
    public void addComponent(String component) {
        report.addComponent(component);
    }
}
