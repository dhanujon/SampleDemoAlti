package stepDef;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public ChromeDriver driver;

	@Given("open the chrome browser and maximize the window")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Given("load the service now application")
	public void loadAppUrl() {
		driver.get("https://dev68594.service-now.com/");

	}

	@Given("enter username as {string}")
	public void enter_username_as_admin(String username) {
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys(username);
	}

	@Given("enter password as {string}")
	public void enter_password_as_india(String password) {
		driver.findElementById("user_password").sendKeys(password);
	}

	@When("click login button")
	public void click_login_button() {
		driver.findElementByName("not_important").click();
	}

	@Then("homepage should be displayed")
	public void homepage_should_be_displayed() {
		System.out.println("Home page should be displayed");
	}
	
	@But("error should be displayed")
	public void verifyError() {
		System.out.println("error is displayed");

	}

}
