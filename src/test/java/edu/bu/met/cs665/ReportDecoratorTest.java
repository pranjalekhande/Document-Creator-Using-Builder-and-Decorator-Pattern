
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: ReportDecoratorTest.java
 * Description: Unit tests for the ReportDecorator and its concrete implementations.
 */
package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import edu.bu.met.cs665.builder.ReportBuilder;
import edu.bu.met.cs665.builder.ReportBuilderImpl;
import edu.bu.met.cs665.builder.ReportType;
import org.junit.Before;
import org.junit.Test;

import edu.bu.met.cs665.models.Report;
import edu.bu.met.cs665.models.ColorDecoratorReport;
import edu.bu.met.cs665.models.FontDecoratorReport;

public class ReportDecoratorTest {

    private Report report;

    @Before
    public void setUp() {
        ReportBuilder builder = new ReportBuilderImpl();
        report = builder
                .setReportType(ReportType.PDF)
                .addChart()
                .addText("Sample Text")
                .addTable()
                .build();
    }

    @Test
    public void testFontDecoratorReport() {
        FontDecoratorReport fontDecorator = new FontDecoratorReport(report, "Bold");
        List<String> expectedComponents = Arrays.asList(
                "[Bold]Chart[/Bold]",
                "[Bold]Text: Sample Text[/Bold]",
                "[Bold]Table[/Bold]"
        );
        assertEquals(expectedComponents, fontDecorator.getComponents());
    }

    @Test
    public void testColorDecoratorReport() {
        ColorDecoratorReport colorDecorator = new ColorDecoratorReport(report, "Green");
        List<String> expectedComponents = Arrays.asList(
                "[Color=Green]Chart[/Color]",
                "[Color=Green]Text: Sample Text[/Color]",
                "[Color=Green]Table[/Color]"
        );
        assertEquals(expectedComponents, colorDecorator.getComponents());
    }

    @Test
    public void testMultipleDecorators() {
        FontDecoratorReport fontDecorator = new FontDecoratorReport(report, "Italic");
        ColorDecoratorReport colorDecorator = new ColorDecoratorReport(fontDecorator, "Red");
        List<String> expectedComponents = Arrays.asList(
                "[Color=Red][Italic]Chart[/Italic][/Color]",
                "[Color=Red][Italic]Text: Sample Text[/Italic][/Color]",
                "[Color=Red][Italic]Table[/Italic][/Color]"
        );
        assertEquals(expectedComponents, colorDecorator.getComponents());
    }
}
