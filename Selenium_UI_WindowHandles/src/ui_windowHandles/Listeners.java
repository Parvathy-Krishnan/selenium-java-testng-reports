package ui_windowHandles;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

//ITest Listeners interface is used here
public class Listeners extends ScreenshotFile implements ITestListener {
	
	ExtentTest test;
	
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started - Listener *******************************************************************");
    }
	
	@Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed - Listener *******************************************************************");
        }
	
	@Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed - Listener *******************************************************************");
        String filePath = null;
		try {
			filePath = takeScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        }
	
	
}



