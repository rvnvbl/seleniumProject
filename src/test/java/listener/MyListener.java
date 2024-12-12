package listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("On Start");
    }


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("On TestStart");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Success");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Fail");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("Skipped");
    }


    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("Finish");
    }
}
