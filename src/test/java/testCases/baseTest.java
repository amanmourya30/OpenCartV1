package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.RegisterationPage;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homepage;
	protected RegisterationPage regpage;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");
		homepage = new HomePage(driver);
		regpage = new RegisterationPage(driver);
	}

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
}
