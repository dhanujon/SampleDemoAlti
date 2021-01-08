package automation.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident {

	public String incidentNumber;
	@Test
	public void openApp() throws InterruptedException {

		// step1: setup driver - Precondition
		WebDriverManager.chromedriver().setup();

		// step2: open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// step3: launch the application
		driver.get("https://dev68594.service-now.com/");

		// step4: maximize the browser
		driver.manage().window().maximize();

		// to apply implicitly wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// WebElement frameElement = driver.findElementById("gsft_main");

		// to get into a frame
		driver.switchTo().frame("gsft_main");
		// driver.switchTo().frame(0);
		// driver.switchTo().frame(frameElement);

		// step5: locate the webelement
		WebElement username = driver.findElementById("user_name");

		// step6: interact with webelement
		username.sendKeys("admin");

		driver.findElementById("user_password").sendKeys("India@123");

		// locate using name locator and click
		driver.findElementByName("not_important").click();

		// to come out of frame and get into main dom
		driver.switchTo().defaultContent();

		driver.findElementById("filter").sendKeys("incident");

		Thread.sleep(5000);
		driver.findElementByXPath("(//div[text()='All'])[2]").click();

		driver.switchTo().frame("gsft_main");

		driver.findElementByXPath("//button[text()='New']").click();

		//to click on Caller lookup
		driver.findElementByXPath("//span[text()='Caller']/following::span[@class='icon icon-search'][1]").click();

		
		//steps to switch to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);

		String secondWin = listHandles.get(1);
		String firstWin = listHandles.get(0);
		driver.switchTo().window(secondWin);

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys("Abel", Keys.ENTER);

		driver.findElementByLinkText("Abel Tuter").click();

		//switch to the first window
		driver.switchTo().window(firstWin);

		driver.switchTo().frame("gsft_main");
		
		 incidentNumber = driver.findElementById("incident.number").getAttribute("value");
		
		driver.findElementById("incident.short_description").sendKeys("Test");

		driver.findElementById("sysverb_insert").click();

		WebElement searchBy = driver.findElementByXPath("//select[contains(@id,'select')]");

		Select dd = new Select(searchBy);

		dd.selectByVisibleText("Number");

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNumber, Keys.ENTER);
		
		boolean displayed = driver.findElementByLinkText(incidentNumber).isDisplayed();
		Assert.assertTrue(displayed);

	}

}
