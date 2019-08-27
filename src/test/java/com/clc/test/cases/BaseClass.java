package com.clc.test.cases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.clc.utility.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String Url = rc.getApplicationUrl();
	public String Uname = rc.getUsername();
	public String Upass = rc.getPassword();

	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		if (br.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/Driver/chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver","C:/Users/W7/eclipse-workspace/Hybrid-Framework/Driver/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", rc.getChromepath());
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxpath());
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", rc.getIepath());
			driver = new InternetExplorerDriver();
		}

		logger = Logger.getLogger("Hybrid-Framework");
		PropertyConfigurator.configure("log4j.properties");
		driver.get(Url);

	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}

}
