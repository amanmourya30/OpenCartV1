package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelDataReader;

public class TC2_LoginTest extends BaseTest {

	@Test
	public void verifyLogin() throws InterruptedException {
		logger.info("*****Starting TC2_LoginTest*****");
		homepage.clickMyAccount();
		homepage.clickLogIn();

		logpage.EnterEmail(email);
		logpage.EnterPass(pass);
		logpage.clickloginBtn();

		boolean targetPage = myAccpage.isMyAccountPageExists();
		Assert.assertTrue(targetPage);

		logger.info("*****TC2_LoginTest finished*****");

	}
	
	public Object[][] getLoginData() throws IOException{
		ExcelDataReader excelDataReader=new ExcelDataReader();
		return excelDataReader.getExcelData(".\testData\\opencartLoginData.xlsx",0);
	}
}
