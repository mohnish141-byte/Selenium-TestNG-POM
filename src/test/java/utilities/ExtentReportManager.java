package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir")
                + "/test-output/ExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config().setReportName("MyCarHelpline Automation Report");
        reporter.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Mohnish");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Application", "MyCarHelpline");

        return extent;
    }
}