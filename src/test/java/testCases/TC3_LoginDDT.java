package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelDataReader;

public class TC3_LoginDDT extends BaseTest {

	@Test
	public void verifyLogin() throws InterruptedException {
		homepage.clickMyAccount();
		homepage.clickLogIn();

		logpage.EnterEmail(email);
		logpage.EnterPass(pass);
		logpage.clickloginBtn();
//need to add more step for logout
		boolean targetPage = myAccpage.isMyAccountPageExists();
		Assert.assertTrue(targetPage);

	}
	
	public Object[][] getLoginData(){
		ExcelDataReader excelDataReader=new ExcelDataReader();
		return excelDataReader.getExcelData("./testData//", 0);
	}
}
