package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_AccountRegisteration extends BaseTest {

	@Test
	public void validateReg() throws InterruptedException {
		logger.info("*****validateReg started*****");
		homepage.clickMyAccount();
		homepage.clickRegister();
		regpage.EnterFirstName("aman");
		regpage.EnterLastName("mourya");
		regpage.EnterEmail(randomString() + "@gmail.com");
		regpage.EnterTelephone(randomNumber());
		String pwd = randomString() + "#" + randomNumber();
		regpage.EnterPassword(pwd);
		regpage.EnterPasswordConfirm(pwd);
		regpage.clickAgreeCheckbox();
		regpage.clickContinue();

		Assert.assertEquals(regpage.getSuccessText(), "Your Account Has Been Created!");
		logger.info("*****validateReg finished*****");

	}
}
