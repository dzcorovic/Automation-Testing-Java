package testpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NahlaPage {

	private WebDriver driver;

	private By nahlaTim = By.id("menu-item-1464");

	public NahlaPage(WebDriver driver) {
		this.driver = driver;
	}

	public NahlaTimPage clickAboutUs() {
		
		Actions act = new Actions(driver);
		WebElement oNama = driver.findElement(By.xpath("//li[@id=\"menu-item-22\"]"));
		act.moveToElement(oNama).perform();
		driver.findElement(nahlaTim).click();
		return new NahlaTimPage(driver);
	}
}
