package automation.ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertHandling {

	@Test
	public void openApp() {

		// step1: setup driver - Precondition
		WebDriverManager.chromedriver().setup();

		// step2: open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// step3: launch the application
		driver.get("http://leafground.com/pages/Alert.html");

		// step4: maximize the browser
		driver.manage().window().maximize();

		// to apply implicitly wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementByXPath("//button[text()='Prompt Box']").click();

		// switch the control to alert
		Alert alert = driver.switchTo().alert();
		// to read text from alert
		String text = alert.getText();
		// to type value in the text filed in alert
		 alert.sendKeys("Hari");
		// to click ok button
		alert.accept();
		// to click cancel in the alert
		// alert.dismiss();
		

		System.out.println(text);

	}

}
