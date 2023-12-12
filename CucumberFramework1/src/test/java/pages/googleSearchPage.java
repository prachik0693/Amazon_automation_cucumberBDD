package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class googleSearchPage extends BasePage {

	WebDriver driver;
	private By txt_searchBox =  By.id("twotabsearchtextbox");

	private By btn_submitButton = By.xpath("//input[@id=\"nav-search-submit-button\"]");
	private By  btn_selectProduct = By.xpath("//img[@alt='Sponsored Ad - Apple iPhone 13 (128GB) - Pink']");

	private By btn_addtocartButton = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");

	private By page_addToCart = By.xpath("//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']");

	public googleSearchPage(WebDriver driver) {
		log.info("initializing session");
		this.driver = driver;	
	}

	public void enterProductInSearchBox(String productName) {
		log.info("Enter product name in search box");
		driver.findElement(txt_searchBox).sendKeys(productName);
	}

	public void clickSubmitButton() {
		log.info("Clicking on submit button to find product result");
		driver.findElement(btn_submitButton).click();
	}

	public void clickSelectProduct() {

		try {
			driver.findElement(btn_selectProduct).click();
			log.info("Selecting 1st product from product list displayed");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			log.error("Exception occured", new Exception("Element not found"));
		}	
	}

	public void clickAddToCart() {
		log.info("Click to add to Cart button to add selected product");
		driver.findElement(btn_addtocartButton).click();
	}

	public void verifyAddedToCart() {
		try {
			driver.findElement(page_addToCart).isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			log.info("Product is added to cart successfully");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			log.error("Exception occured", new Exception("Element not found"));
		}
		finally {
			driver.close();
			driver.quit();
			log.info("Quiting the driver");
		}
		Assert.assertEquals(true, driver.findElement(page_addToCart).isDisplayed());

	}



}
