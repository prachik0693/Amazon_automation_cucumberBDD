package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.registrationPage;

public class RegistrationSteps {

	WebDriver driver = null;

	registrationPage registration;

	@Given("chrome browser is open")
	public void chrome_browser_is_open() {
		System.setProperty(
				"webdriver.chrome.driver",
				"D:\\documents\\software folder\\chromedriver-win32\\chromedriver.exe"); 

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	}

	@Then("navigate to amazon website for registration functionality")
	public void navigate_to_amazon_website_for_registration_functionality() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("From top menu, Select dropdown")
	public void from_top_menu_Select_dropdown() {
		registration = new registrationPage(driver);
		registration.selectedTopMenuDropdown();
		//		Assert.assertTrue(registration.selectedTopMenuDropdown());
	}

	@Then("click on start here button")
	public void click_on_start_here_button() {
		registration.clickStartHereButton();
	}

	@Then("enter all required details")
	public void enter_all_required_details() {

		registration.enterUserName("abc");
		registration.enterPhoneNumber("1234");
		registration.enterEmailid("abc@gmail.com");
		registration.enterPassword("123456");
	}

	@Then("click on verify mobile number button")
	public void click_on_verify_mobile_number_button() throws Exception {
		registration.clickVerifyButton();
	}

}