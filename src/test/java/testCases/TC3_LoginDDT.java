package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelDataReader;

public class TC3_LoginDDT extends BaseTest {

	@Test(dataProvider = "loginData")
	public void verifyLogin(String email, String pass, String exp) throws InterruptedException {
		try {
			homepage.clickMyAccount();
			homepage.clickLogIn();

			logpage.EnterEmail(email);
			logpage.EnterPass(pass);
			logpage.clickloginBtn();

			boolean targetPage = myAccpage.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myAccpage.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					myAccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

			System.out.println(System.getProperty("user.dir"));
		} catch (Exception e) {
			Assert.fail("An Exception occured: " + e.getMessage());
		}

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {
		ExcelDataReader excelDataReader = new ExcelDataReader();
		return excelDataReader.getExcelData("./src\\test\\java\\testData\\opencartLoginData.xlsx", 0);
	}
}
