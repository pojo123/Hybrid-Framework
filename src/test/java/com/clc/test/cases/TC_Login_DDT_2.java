package com.clc.test.cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clc.page.objects.LoginPage;
import com.clc.utility.XLUtils;

public class TC_Login_DDT_2 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd) {

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(uname);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/clc/test/data/ExcelHybrid.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);

		String[][] loginData = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colnum; j++) {

				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return loginData;

	}
}
