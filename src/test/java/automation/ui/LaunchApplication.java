package automation.ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApplication {
	
	@Test
	public void openApp() {

		//step1: setup driver - Precondition
		WebDriverManager.chromedriver().setup();
		
		//step2: open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//step3: launch the application
		driver.get("https://dev68594.service-now.com/");
		
		//step4: maximize the browser
		driver.manage().window().maximize();
		
		//to apply implicitly wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//WebElement frameElement = driver.findElementById("gsft_main");
		
		
		//to get into a frame
		driver.switchTo().frame("gsft_main");
	//	driver.switchTo().frame(0);
	//	driver.switchTo().frame(frameElement);
		
			
		//step5: locate the webelement
		WebElement username = driver.findElementById("user_name");
		
		//step6: interact with webelement
		username.sendKeys("admin");
		
		driver.findElementById("user_password").sendKeys("India@123");
		
		//locate using name locator and click
		driver.findElementByName("not_important").click();
		
		//to come out of frame and get into main dom
		driver.switchTo().defaultContent();
		
		//locate using linkText
		//driver.findElementByLinkText("Forgot Password ?").click();
		
		//locate using partial link text
		//driver.findElementByPartialLinkText("Forgot").click();
		
		
		  driver.findElementById("filter").sendKeys("incident");
		  
		  driver.findElementByXPath("(//div[text()='All'])[2]").click();
		  
		  
		  driver.switchTo().frame("gsft_main");
		  
		  //to interact with dropdown: locate the element with with select tag
		  WebElement searchDropDown = driver.findElementByXPath("//select[contains(@id,'select')]");
		  
		  //create object for select class 
		  Select dropDown = new Select(searchDropDown);
		  
		  //select option using visible text dropDown.selectByVisibleText("State");
		 
		
		
		
		
		//to use advance user interactions
		//Actions builder = new Actions(driver);
		//to mouse hover
		//builder.moveToElement(username).perform();
		//to right click
		//builder.contextClick(username).perform();
		//builder.doubleClick(username).perform();
		//to drag and drop
		//builder.dragAndDrop(username,searchDropDown).perform();
		//to do sequence of actions
		//builder.keyDown(Keys.CONTROL).click(username).click(searchDropDown).keyUp(Keys.CONTROL).perform();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
