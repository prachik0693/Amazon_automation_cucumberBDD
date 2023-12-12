package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.googleSearchPage;

public class GoogleSearchSteps {

	WebDriver driver = null;
	googleSearchPage googleSearch;

	@Given("browser is open")
	public void browser_is_open() {
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

	@Then("navigate to amazon website")
	public void navigate_to_amazon_website() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@And("search iphone in searchbox")
	public void search_iphone_in_searchbox() {
		googleSearch = new googleSearchPage(driver);
		googleSearch.enterProductInSearchBox("iphone");
	}

	@And("hits enter")
	public void hits_enter() {
		googleSearch.clickSubmitButton();
	}

	@Then("select first product in the list")
	public void select_first_product_in_the_list() {
		googleSearch.clickSelectProduct();
	}

	@And("Open product detail page in another page")
	public void open_product_detail_page_in_another_page() {
		Set<String> s = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(s);
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));
		driver.switchTo().window((String)ar.get(1));
	}

	@And("click on add  to cart button")
	public void click_on_add_to_cart_button() {
		googleSearch.clickAddToCart();
	}

	@Then("product is added to cart")
	public void product_is_added_to_cart() {
		googleSearch.verifyAddedToCart();
		//		Assert.assertEquals(true, googleSearch.verifyAddedToCart());
	}

}
