package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.twozo.crm.base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ExtentManager;
import utilities.ScreenShotUtils;

public class ExtentTestNGListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getExtent();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    public void onTestStart(final ITestResult result) {
        final ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        extentTest.assignAuthor("Jabez");
        test.set(extentTest);
    }

    public void onTestSuccess(final ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(final ITestResult result) {
        final  Object testClass = result.getInstance();
        final  WebDriver driver = ((BaseTest) testClass).driver;
        final  String screenshotPath = ScreenShotUtils.takeScreenShot(driver, result.getMethod().getMethodName());
        test.get().fail(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build() );
    }

    public void onTestSkipped(final ITestResult result) {
        test.get().skip("Test Skipped");
    }

    public void onFinish(final ITestContext context) {
        extent.flush();
    }
}