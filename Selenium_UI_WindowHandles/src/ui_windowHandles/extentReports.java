package ui_windowHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports {
	
	ExtentReports extent;
	
	@BeforeTest
	public void extendreportConfig(){
		String path = System.getProperty("usr.dir")+"//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("****TEST EXTEND REPORT****");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Parvathy Krish");
		
	}
	
	@Test
	public void openBrowser() {
		extent.createTest("Extent test -- PK");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.getTitle();
		driver.quit();
		extent.flush();
		}

}
