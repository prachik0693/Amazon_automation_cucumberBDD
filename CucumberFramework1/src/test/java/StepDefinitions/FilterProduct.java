package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.filterProductPage;

public class FilterProduct {

	WebDriver driver = null;
	filterProductPage filterProduct;
	@Given("browser is open for product filter")
	public void browser_is_open_for_product_filter() {
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

	@Then("navigate to amazon website to search a product")
	public void navigate_to_amazon_website_to_search_a_product() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@And("search phone in searchbox")
	public void search_phone_in_searchbox() {
		filterProduct = new filterProductPage(driver);
		filterProduct.enterProductInSearchBox("phone");
	}

	@Then("hits enter key")
	public void hits_enter_key() {
		filterProduct.clickSubmitButton();
	}

	@When("click on delivery day checkbox")
	public void click_on_delivery_day_checkbox() {
		filterProduct.clickDeliveryDayCheckbox();

	}
	
	@Then("filtered product list populated")
	public void filtered_product_list_populated() {
		filterProduct.checkFilteredProductIsPopulated();

	}

}

