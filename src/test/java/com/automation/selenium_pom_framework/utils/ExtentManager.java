package com.automation.selenium_pom_framework.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            reporter.config().setReportName("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getInstance().createTest(testName);
        return test;
    }

    public static void flush() {
        extent.flush();
    }
}