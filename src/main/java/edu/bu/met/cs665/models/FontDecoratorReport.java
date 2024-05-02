
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: FontDecoratorReport.java
 * Description: Decorator class to apply font styles to report components.
 */
package edu.bu.met.cs665.models;

import java.util.ArrayList;
import java.util.List;
public class FontDecoratorReport extends ReportDecorator {
    private String fontStyle;

    public FontDecoratorReport(Report report, String fontStyle) {
        super(report);
        this.fontStyle = fontStyle;
    }

    @Override
    public List<String> getComponents() {
        List<String> decoratedComponents = new ArrayList<>();
        for (String component : super.getComponents()) {
            decoratedComponents.add("[" + fontStyle + "]" + component + "[/" + fontStyle + "]");
        }
        return decoratedComponents;
    }

    // Methods to apply font styles to the report components
}
