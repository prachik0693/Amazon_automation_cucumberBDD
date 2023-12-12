package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class filterProductPage extends BasePage {

	WebDriver driver;
	private By txt_searchBox =  By.id("twotabsearchtextbox");
	private By btn_submitButton = By.xpath("//input[@id=\"nav-search-submit-button\"]");

	private By btn_deliveryDayCheckbox = By.xpath("//li[@id='p_90/6741118031']//i[@class='a-icon a-icon-checkbox']");

	private By btn_checkedBeliveryDayCheckbox = By.xpath("//li[@id='p_90/6741118031']//i[@class='a-icon a-icon-checkbox']");

	public filterProductPage(WebDriver driver) {
		log.info("Initializing session for filter product functionality");
		this.driver = driver;	
	}

	public void enterProductInSearchBox(String productName) {
		log.info("Enter pproduct name in search box");
		driver.findElement(txt_searchBox).sendKeys(productName);
	}

	public void clickSubmitButton() {
		log.info("Click on submit button to search product");
		driver.findElement(btn_submitButton).click();
	}

	public void clickDeliveryDayCheckbox() {
		log.info("Click on delivery day checkboxto filter product");
		driver.findElement(btn_deliveryDayCheckbox).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}

	public void checkFilteredProductIsPopulated() {
		try {
			log.info("Checbox is selected and  Filtered product is displayed");
			driver.findElement(btn_checkedBeliveryDayCheckbox).isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			log.error("Exception occured", new Exception("Element not found"));
		}
		finally {
			driver.close();
			driver.quit();
			log.info("Quiting the driver");
		}

	}


}
