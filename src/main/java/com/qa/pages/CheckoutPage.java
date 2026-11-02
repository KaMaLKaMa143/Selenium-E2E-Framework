package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage 
{
	WebDriver driver;
	@FindBy(id="first-name")
	WebElement firstnamebutton;
	@FindBy(id="last-name")
	WebElement lastnamebutton;
	@FindBy(id="postal-code")
	WebElement zipcodebutton;
	@FindBy(id="continue")
	WebElement continuebutton;
	@FindBy(name="finish")
	WebElement finishbutton;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillCheckoutDetails(String fname,String lname,String pcode)
	{
		firstnamebutton.sendKeys(fname);
		lastnamebutton.sendKeys(lname);
		zipcodebutton.sendKeys(pcode);
		continuebutton.click();
		finishbutton.click();
	}

}
