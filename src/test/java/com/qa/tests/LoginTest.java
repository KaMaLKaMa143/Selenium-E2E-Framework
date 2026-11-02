package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;


@Listeners(com.qa.listeners.Listeners.class)

public class LoginTest extends BaseTest
{
	@Test
	public void verifyValidLogin()
	{
		LoginPage lp=new LoginPage(driver);
		lp.login(url, username, password); 
		String expectedurl="https://www.saucedemo.com/";
		Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
		
		
	}
	
   
}
