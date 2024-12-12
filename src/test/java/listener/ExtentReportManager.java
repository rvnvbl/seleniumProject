package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;


    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("On Start");
        sparkReporter = new ExtentSparkReporter("src/test/resources/reports/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Smoke Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("ComputerName","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","localhost");
        extent.setSystemInfo("os","localhost");
        extent.setSystemInfo("Browser name","localhost");
    }


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("On TestStart");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"Test case PASSED is: " + result.getName());

    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        test = extent.createTest(result.getName());
        test.log(Status.FAIL,"Test case FAILED is: " + result.getName());

    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        test = extent.createTest(result.getName());
        test.log(Status.SKIP,"Test case SKIPPED is: " + result.getName());

    }


    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
