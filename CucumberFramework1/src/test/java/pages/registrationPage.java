package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class registrationPage extends BasePage {
	WebDriver driver;
	private By txt_username =  By.id("ap_customer_name");
	private By txt_phonenumber = By.id("ap_phone_number");
	private	By txt_emailid = By.id("ap_email");
	private	By txt_password = By.id("ap_password");

	private By dropDown_topmenu = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	private By btn_starthere = By.xpath("//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][normalize-space()='Start here.']");
	private By btn_mobilenumberbutton = By.id("continue");

	public registrationPage(WebDriver driver) {
		log.info("initializing session for use registration");
		this.driver = driver;	
	}


	public void selectedTopMenuDropdown() {
		log.info("Select top menu dropdown ");
		WebElement element = driver.findElement(dropDown_topmenu);
		Actions actions =new Actions(driver);
		actions.moveToElement(element).build().perform();
	}


	public void clickStartHereButton() {
		log.info("Click on start here button");
		driver.findElement(btn_starthere).click();
	}


	public void enterUserName(String userName) {
		log.info("Enter user name");
		driver.findElement(txt_username).sendKeys(userName);
	}

	public void enterPhoneNumber(String phonenumber) {
		log.info("Enter phone number");
		driver.findElement(txt_phonenumber).sendKeys(phonenumber);
	}

	public void enterEmailid(String emailid) {
		log.info("Enter emailId");
		driver.findElement(txt_emailid).sendKeys(emailid);
	}

	public void enterPassword(String password) {
		log.info("Enter password");
		driver.findElement(txt_password).sendKeys(password);
	}


	public void clickVerifyButton() throws Exception {
		Thread.sleep(3000);
		driver.findElement(btn_mobilenumberbutton).click();
		String expectedMessage = "The mobile number you entered does not seem to be valid";
		String actualMessage = driver.findElement(By.xpath("//div[@class='a-alert-content'][normalize-space()='The mobile number you entered does not seem to be valid']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println("Equal Assertion Verified");
        
        Thread.sleep(3000);
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='a-alert-content'][normalize-space()='The mobile number you entered does not seem to be valid']")).isSelected());
        System.out.println("false Assertion Verified");
        
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-alert-content'][normalize-space()='The mobile number you entered does not seem to be valid']")).isDisplayed());
        System.out.println("true Assertion Verified");

		driver.close();
		driver.quit();
	}


}
