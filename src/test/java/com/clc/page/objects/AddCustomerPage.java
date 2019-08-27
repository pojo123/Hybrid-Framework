package com.clc.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newCust;

	@FindBy(name = "name")
	WebElement name;

	@FindBy(name = "rad1")
	List<WebElement> gender;

	@FindBy(name = "dob")
	WebElement date;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pin;

	@FindBy(name = "telephoneno")
	WebElement phone;

	@FindBy(name = "emailid")
	WebElement mail;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(name = "sub")
	WebElement submit;
	
	public void newCustomer() {
		newCust.click();;
	}

	public void getName(String uname) {

		name.sendKeys(uname);
	}

	public void getGender(String gen) {

		for (WebElement gend : gender) {
			if (gend.getAttribute("value").equals(gen)) {
				gend.click();
				break;
			}
		}
	}

	public void dateOfBirth(String mm, String dd, String yy) {

		date.sendKeys(mm);
		date.sendKeys(dd);
		date.sendKeys(yy);
	}

	public void getAddress(String addr) {

		address.sendKeys(addr);
	}

	public void getCity(String cityy) {

		city.sendKeys(cityy);
	}

	public void getState(String state1) {

		state.sendKeys(state1);
	}

	public void getPin(String pinno) {

		pin.sendKeys(pinno);
	}

	public void getPhoneNo(String phoneno) {

		phone.sendKeys(phoneno);
	}

	public void getEmail(String emailid) {

		mail.sendKeys(emailid);
	}

	public void getPassword(String password) {

		pwd.sendKeys(password);
	}

	public void clickSubmit() {
		submit.click();
	}
}
