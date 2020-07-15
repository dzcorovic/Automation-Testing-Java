package testpage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
	
    public WebDriver driver;
	
    public void initialization() {
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\executable\\chromedriver.exe");
		driver= new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://amina-pez.github.io/automation/");
   
	}
    
    public void takeScreenshot()  {
        
    	File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 
    	try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\screenshot\\TestPage.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
