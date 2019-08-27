package com.clc.test.cases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clc.page.objects.AddCustomerPage;
import com.clc.page.objects.LoginPage;

public class TC_Login_3 extends BaseClass{
	
	@Test
	public void addCustomer() throws IOException {
		
		LoginPage lop = new LoginPage(driver);
		lop.setUsername(Uname);
		lop.setPassword(Upass);
		lop.clickLogin();
		
		AddCustomerPage adp = new AddCustomerPage(driver);
        adp.newCustomer();
        
		adp.getName("Abc");
		adp.getGender("f");
		adp.dateOfBirth("04","30","1998");
		adp.getAddress("pune");
		adp.getCity("pune");
		adp.getState("maharashtra");
		adp.getPin("444603");
		adp.getPhoneNo("898456388");
		
		String email=generateString()+"@gmail.com";
		adp.getEmail(email);
		
		adp.getPassword("sadfgh");
		adp.clickSubmit();
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result == true) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
	public String generateString() {
		
		String random = RandomStringUtils.randomAlphabetic(5);
		return random;
	}

}
