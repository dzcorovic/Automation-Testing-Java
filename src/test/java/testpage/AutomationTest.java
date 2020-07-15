package testpage;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTest extends BaseTest {
	
	@BeforeClass
	public void setUp() {
		initialization();
	}

	@Test(priority = 0)
	public void clickHideButton() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickHideButton();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void VerifyText() throws InterruptedException {
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.VerifyTextIsHidden());
	}

	@Test(priority = 2)
	public void emuCheckBox() throws InterruptedException {
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.EmuCheckDisabled());
	}

	@Test(priority = 3)
	public void verifyNumOfCheckBoxes() throws InterruptedException {
		HomePage home = new HomePage(driver);
		Assert.assertEquals(home.numOfCheckBox(), 6, "Total number of checkboxes are not 6.");
	}

	@Test(priority = 4)
	public void selectRadioButton() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickRadioButton();
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void selNahlaCourse() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.selectCourse();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void PromptBox() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickPromptBox();
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void PrompBoxText() throws InterruptedException {
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.textIsDisplayed());
	}

	@Test(priority = 8)
	public void getNumberOfRows() throws InterruptedException {
		HomePage home = new HomePage(driver);
		System.out.println("Total number of rows for table Podaci o studentima: " + home.numOfRows());
		Thread.sleep(2000);
	}

	@Test(priority = 9)
	public void getFirstAndLastNameOfStudents() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.NameOfStudent();
		Thread.sleep(2000);
	}

	@Test(priority = 10)
	public void newBrowser() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickNewBrowser();
		Set<String> allHands = driver.getWindowHandles();
		for (String hand : allHands) {
			driver.switchTo().window(hand);
		}
		Thread.sleep(2000);
	}

	@Test(priority = 11)
	public void getUrl1() throws InterruptedException {
		Assert.assertEquals(driver.getCurrentUrl(), "https://nahla.ba/", "You are not on Nahla page.");
	}

	@Test(priority = 12)
	public void nahlaTim() throws InterruptedException {
		NahlaPage nahla = new NahlaPage(driver);
		nahla.clickAboutUs();
		Thread.sleep(2000);
	}

	@Test(priority = 13)
	public void getUrl2() throws InterruptedException {
		Assert.assertEquals(driver.getCurrentUrl(), "https://nahla.ba/o-nama/#tim", "You are not on Nahla Tim Page.");
	}

	@Test(priority = 14)
	public void closeNahlaBrowser() throws InterruptedException {
		driver.close();
		Set<String> allHands = driver.getWindowHandles();
		for (String hand : allHands) {
			driver.switchTo().window(hand);
		}
		Thread.sleep(2000);
	}

	@Test(priority = 15)
	public void dragAndDrop() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.dragAndDrop();
		Thread.sleep(2000);
	}

	@Test(priority = 16)
	public void moveMouse() throws InterruptedException {
		WebElement mouse = driver.findElement(By.id("demo2"));
		Actions act = new Actions(driver);
		act.moveToElement(mouse).perform();
		Thread.sleep(2000);
	}

	@Test(priority = 17)
	public void ts() throws InterruptedException {
		takeScreenshot();
		Thread.sleep(2000);
	}

	@Test(priority = 18)
	public void clickVolontiraj() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickOnVolontirajLink();
		Assert.assertTrue(home.VerifyUserIsOnVolontirajPage());
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	@Test(priority = 19)
	public void getUrl3() throws InterruptedException {
		Assert.assertEquals(driver.getCurrentUrl(), "https://amina-pez.github.io/automation/",
				"You are on incorrect page.");
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown() {  
		driver.quit();
	}
}
