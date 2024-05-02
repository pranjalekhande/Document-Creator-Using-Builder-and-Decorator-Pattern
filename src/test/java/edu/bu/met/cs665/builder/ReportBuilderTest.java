
/**
 * Name: Pranjal Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/01/2024
 * File Name: ReportBuilderTest.java
 * Description: Tests build method for report builder.
 */

package edu.bu.met.cs665.builder;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.bu.met.cs665.models.Report;

public class ReportBuilderTest {

    private ReportBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new ReportBuilderImpl();
    }

    @Test
    public void testBuild_Success() {
        List<String> expectedComponents = Arrays.asList("Chart", "Table", "Text: Sample Text");
        Report report = builder
                .setReportType(ReportType.PDF)
                .addChart()
                .addTable()
                .addText("Sample Text")
                .build();

        assertEquals(expectedComponents, report.getComponents());
    }

}