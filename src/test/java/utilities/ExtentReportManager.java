package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static utilities.WebDriverActions.driver;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter reporter;
    private static ExtentTest test;

    @BeforeSuite
    public void initializeReporter() {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        reporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void stepPass(String reportStatement) {
        test.pass(reportStatement, ScreenshotUtils.reportScreenshot(driver));
    }

    public static void stepFail(String reportStatement) {
        test.fail(reportStatement, ScreenshotUtils.reportScreenshot(driver));
    }

    public static void stepInfo(String reportStatement) {
        test.info(reportStatement, ScreenshotUtils.reportScreenshot(driver));
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
