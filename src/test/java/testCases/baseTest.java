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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegisterationPage;
import utilities.ReadConfig;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homepage;
	protected RegisterationPage regpage;
	protected LoginPage logpage;
	protected MyAccountPage myAccpage;
	public Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		configureLogger();

		// Browser Setup
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name provided: " + browser);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get(baseURL);
		homepage = new HomePage(driver);
		regpage = new RegisterationPage(driver);
		logpage = new LoginPage(driver);
		myAccpage = new MyAccountPage(driver);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	private void configureLogger() {
		// Generate a unique log file name with timestamp
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String logFileName = "logs/application_" + timestamp + ".log";

		// Load the log4j properties file
		Properties logProperties = new Properties();
		try (FileInputStream fis = new FileInputStream("log4j.properties")) {
			logProperties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load log4j properties file.");
		}

		// Set the log file name dynamically
		logProperties.setProperty("log4j.appender.file.File", logFileName);

		// Apply the properties to Log4j
		PropertyConfigurator.configure(logProperties);
		logger = Logger.getLogger(this.getClass());
	}
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getURL();
	public String email=readconfig.getUsername();
	public String pass=readconfig.getpassword();
	
	
	
	
	
	
	
	
	
}
