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


    @Override
    public void onTestStart(final ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName(),
                        result.getMethod().getDescription());

        extentTest.assignAuthor("Jabez");
        extentTest.assignCategory(result.getMethod().getGroups());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        test.get().pass("✅ Test Passed");
    }

    @Override
    public void onTestFailure(final ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;

        String screenshotPath =
                ScreenShotUtils.takeScreenShot(
                        driver,
                        result.getMethod().getMethodName() + "_" + System.currentTimeMillis()
                );

        test.get().fail(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public void onTestSkipped(final ITestResult result) {
        test.get().skip("⚠ Test Skipped");
    }

    @Override
    public void onFinish(final ITestContext context) {
        extent.flush();
    }
}