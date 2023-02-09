package ui_windowHandles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotFile {
  private WebDriver driver;

  public void setUp() {
    driver = new ChromeDriver();
  }

  
  public String takeScreenshot(String testcaseName) throws IOException {
    driver.get("https://www.google.com");

    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    ImageIO.write(ImageIO.read(screenshot), "PNG", new File("screenshot.png"));
	return testcaseName;
  }
}

 