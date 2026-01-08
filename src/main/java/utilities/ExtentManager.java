package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private ExtentManager() {
    }

    public static ExtentReports getExtent() {
        final ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport.html");
        final ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);


        reporter.config().setReportName("Twozo CRM Automation Report");
        reporter.config().setDocumentTitle("Automation Execution Report");
        extent.setSystemInfo("Project", "Twozo CRM");
        extent.setSystemInfo("Tester", "Jabez");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
