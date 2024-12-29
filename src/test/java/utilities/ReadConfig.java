package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getURL() {
		String url = pro.getProperty("URL");
		return url;
	}
	
	public String getUsername() {
		String url = pro.getProperty("username");
		return url;
	}
	
	public String getpassword() {
		String url = pro.getProperty("password");
		return url;
	}

}
