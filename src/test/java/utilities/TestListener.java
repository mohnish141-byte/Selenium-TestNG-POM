package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentReportManager.getReportObject();

    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail("Test Failed");

        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}