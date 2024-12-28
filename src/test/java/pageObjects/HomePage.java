package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement MyAccountDropDown;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement RegisterOption;

	public void clickMyAccount() {
		MyAccountDropDown.click();
	}

	public void clickRegister() {
		RegisterOption.click();
	}
	
}