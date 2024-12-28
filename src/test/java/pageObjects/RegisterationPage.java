package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends BasePage {

	public RegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Mail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement passwordConfirm;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreeChk;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement successTxt;
	

	// Acitons on weblement
	

	public void EnterFirstName(String str) {
		firstName.sendKeys(str);
	}

	public void EnterLastName(String str) {
		lastName.sendKeys(str);
	}

	public void EnterEmail(String email) {
		Mail.sendKeys(email);
	}

	public void EnterTelephone(String phone) {
		telephone.sendKeys(phone);
	}

	public void EnterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void EnterPasswordConfirm(String confirmPwd) {
		passwordConfirm.sendKeys(confirmPwd);
	}

	public void clickAgreeCheckbox() {
		agreeChk.click();
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
	
	public String getSuccessText() {
		return successTxt.getText();
	}
}
