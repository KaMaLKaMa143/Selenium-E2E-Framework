package com.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	@FindBy(id="user-name")
	WebElement userbutton;
	@FindBy(id="password")
	WebElement passbutton;
	@FindBy(id="login-button")
	WebElement loginbutton;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String url,String user,String pass)
	{
		driver.get(url);
		userbutton.sendKeys(user);
		passbutton.sendKeys(pass);
		loginbutton.click();
	}
}
