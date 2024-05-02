
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: ColorDecoratorReport.java
 * Description: Decorator class to apply colors to report components.
 */
package edu.bu.met.cs665.models;
import java.util.ArrayList;
import java.util.List;

public class ColorDecoratorReport extends ReportDecorator {
    private String color;

    public ColorDecoratorReport(Report report, String color) {
        super(report);
        this.color = color;
    }

    @Override
    public List<String> getComponents() {
        List<String> decoratedComponents = new ArrayList<>();
        for (String component : super.getComponents()) {
            decoratedComponents.add("[Color=" + color + "]" + component + "[/Color]");
        }
        return decoratedComponents;
    }
    // Methods to apply colors to the report components
}
