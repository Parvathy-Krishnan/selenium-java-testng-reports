package ui_windowHandles;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class windowHandles {

    private WebDriver driver;


	@BeforeMethod
	public void loadUrl() {
		  driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  	System.out.println(driver.getTitle());

	
}
	
	@AfterMethod
	public void closeWindow() {
		driver.quit();
	}
				
				
	// Window Handles - Open link in new tab and switch focus
	@Test
	public void linkInNewTab(ITestContext result) throws InterruptedException {
		
	       System.out.println("T1 The thread ID for Chrome is "+ Thread.currentThread().getId());

		
		// Wait for all the elements to load on the page
		Thread.sleep(3000);
		
		// Variable to click on multiple links
		String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
		
		// Find a link and perform CMD + Enter keyboard operation
		WebElement  topDeals = driver.findElement(By.xpath("//a[text()='Top Deals']"));

		topDeals.sendKeys(openInNewTab);
		
		// WindowHandles for handling multiple tabs in a browser window
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
		
		// Switch to the first new tab
		driver.switchTo().window(tab.get(0));
		System.out.println(driver.getTitle());
		
		
	}
				
			// Window Handles - Open multiple links in new tabs
	@Test
	public void multipleLinkInNewTab(ITestContext result) throws InterruptedException {
		
	       System.out.println("T2 The thread ID for Chrome is "+ Thread.currentThread().getId());

		
		// Wait for all the elements to load on the page
		Thread.sleep(3000);					
		
		// List out all the link labels
		String[] pages = {"Top Deals", "Flight Booking"};
	
		// Clicks on the multiple links that are listed in the 'pages' array of strings 
		for (String page : pages) {
	
		// Re-utilizing the xpath for different links -Pass the link labels as variable and click on multiple links
		WebElement clickables = driver.findElement(By.xpath("//a[text()='" + page + "']"));
		
		// Variable to click on multiple links
		String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
		
		clickables.sendKeys(openInNewTab);
	
		
	}
		
	}
	
	
	// Window Handles - Open multiple links in new tabs and switch between windows
	@Test
	public void switchMultipleLinkInNewTab(ITestContext result) throws InterruptedException {
		
	       System.out.println("T3 The thread ID for Chrome is "+ Thread.currentThread().getId());

		
		// Wait for all the elements to load on the page
		Thread.sleep(3000);					
		
		// List out all the link labels
		String[] pages = {"Top Deals", "Flight Booking"};
		
		// Parent and child window handles
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
	
		// loop to switch between parent and child windows
		for (String windowHandle : allWindows) {
			
		// loop to click on multiple links that are listed in the array of strings	
		for (String page : pages) {
	
	
		// Re-utilizing the xpath for different links -Pass the link labels as variable and click on multiple links
		WebElement clickables = driver.findElement(By.xpath("//a[text()='" + page + "']"));
		
		// Variable to click on multiple links
		String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
	
		clickables.sendKeys(openInNewTab);
		
		// switch to parent window then close the current window
		if (!windowHandle.equals(parentWindow)) {
		    driver.switchTo().window(windowHandle);
		    // perform actions in the child window
					    driver.close();
					  }
					}
	
					driver.switchTo().window(parentWindow);
					
					}
					}
	
					
				
				
				
				
	  }				
	

	

	
	
	


