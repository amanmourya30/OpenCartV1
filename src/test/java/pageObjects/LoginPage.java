package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement MailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	public void EnterEmail(String email) {
		MailAddress.sendKeys(email);
	}

	public void EnterPass(String pass) {
		password.sendKeys(pass);
	}

	public void clickloginBtn() {
		loginBtn.click();
	}

}
