package com.clc.test.cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clc.page.objects.LoginPage;

public class TestCase_Login_1 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("url is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(Uname);
		logger.info("username entered");
		lp.setPassword(Upass);
		logger.info("password entered");
		lp.clickLogin();
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("test case is failed");
		}
	}

}
