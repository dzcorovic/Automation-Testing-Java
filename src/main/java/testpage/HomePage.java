package testpage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	private WebDriver driver;

	private By hide = By.id("hide-textbox");
	private By verifyText = By.id("displayed-text");
	private By emu_checkbox = By.id("emu-checkbox");
	private By jkucica = By.xpath("//input[@value=\"Jezeva kucica\"]");
	private By ncourse = By.id("Nahla Course");
	private By promptbox = By.id("promptBox");
	private By pboxmessage = By.id("demo");
	private By studentTable = By.xpath("//*[@id=\"studentTable\"]/tbody/tr");
	private By studentEnglish = By.xpath("//*[@id=\"studentTable\"]/tbody/tr/td[3]");
	private By firstname = By.xpath("//*[@id=\"studentTable\"]/tbody/tr/td[1]");
	private By lastname = By.xpath("//*[@id=\"studentTable\"]/tbody/tr/td[2]");
	private By newbrowser = By.id("win1");
	private By volontirajLink = By.xpath("//a[@href=\"https://nahla.ba/volontiraj/\"]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHideButton() {
		driver.findElement(hide).click();
	}

	public boolean VerifyTextIsHidden() {
		String value = "display: none;";
		if (value.equals(driver.findElement(verifyText).getAttribute("style"))) {
			return true;
		}
		return false;
	}

	public boolean EmuCheckDisabled() {
		if (driver.findElement(emu_checkbox).getAttribute("disabled") != null) {
			return true;
		}
		return false;
	}

	public int numOfCheckBox() {
		List<WebElement> list = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		return list.size();
	}

	public void clickRadioButton() {
		driver.findElement(jkucica).click();
	}

	public void selectCourse() {
		WebElement nc = driver.findElement(ncourse);
		nc.click();
		nc.sendKeys("T" + Keys.ENTER);
	}

	public void clickPromptBox() throws InterruptedException {
		driver.findElement(promptbox).click();
		driver.switchTo().alert().sendKeys("Dzenana");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	public boolean textIsDisplayed() {
		if (driver.findElement(pboxmessage).isDisplayed() == true) {
			return true;
		}
		return false;
	}

	public int numOfRows() {
		List<WebElement> list = driver.findElements(studentTable);
		return list.size() - 1;
	}

	public void NameOfStudent() {
		String value = "English";
		List<WebElement> list = driver.findElements(studentEnglish);
		List<WebElement> firstName = driver.findElements(firstname);
		List<WebElement> lastName = driver.findElements(lastname);
		for (int i = 0; i < list.size(); i++) {
			if (value.equals(list.get(i).getText())) {
				System.out.println("First and Last Name of students which are in English course: "
						+ firstName.get(i).getText() + " " + lastName.get(i).getText());
			}
		}
	}

	public NahlaPage clickNewBrowser() throws InterruptedException {
		WebElement sub = driver.findElement(newbrowser);
		String script = "arguments[0].scrollIntoView()";
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript(script, sub);
		Thread.sleep(2000);
		sub.click();
		return new NahlaPage(driver);
	}

	public void dragAndDrop() {

		WebElement sub = driver.findElement(By.id("sortable"));
		String script = "arguments[0].scrollIntoView()";
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript(script, sub);

		WebElement source = driver.findElement(By.id("clickAndHold"));
		WebElement target = driver.findElement(By.id("click"));
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public void clickOnVolontirajLink() {

		WebElement sub = driver.findElement(By.xpath("//iframe[@src=\"https://nahla.ba/\"]"));
		String script = "arguments[0].scrollIntoView()";
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript(script, sub);
		driver.switchTo().frame(0);
		driver.findElement(volontirajLink).click();
	}

	public boolean VerifyUserIsOnVolontirajPage() {

		List<WebElement> list = driver.findElements(By.xpath("//*[@href=\"https://nahla.ba/volontiraj/\"]"));
		if (list.size() > 1) {
			return true;
		}
		return false;
	}
}
