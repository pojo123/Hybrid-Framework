package com.clc.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name="uid")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;

	public void setUsername(String Uname) {
		username.sendKeys(Uname);
	}

	public void setPassword(String Upass) {
		password.sendKeys(Upass);
	}

	public void clickLogin() {
		login.click();
	}
	
	public void clicklogout() {
		logout.click();
	}
}
