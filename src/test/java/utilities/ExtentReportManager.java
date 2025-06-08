package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
        test.pass(reportStatement);
    }

    public static void stepFail(String reportStatement) {
        test.fail(reportStatement);
    }

    public static void stepInfo(String reportStatement) {
        test.info(reportStatement);
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
