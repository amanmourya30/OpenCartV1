package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.RegisterationPage;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homepage;
	protected RegisterationPage regpage;
	public Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {
		// Generate a unique log file name with timestamp
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String logFileName = "logs/application_" + timestamp + ".log";
		// Load the properties file
		Properties logProperties = new Properties();
		try {
			logProperties.load(new FileInputStream("log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Set the log file name property
		logProperties.setProperty("log4j.appender.file.File", logFileName);
		// Apply the properties to Log4j
		PropertyConfigurator.configure(logProperties);
		logger = Logger.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name..");
			return;
		}

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
