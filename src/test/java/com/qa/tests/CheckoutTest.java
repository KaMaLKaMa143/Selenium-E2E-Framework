package com.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.CheckoutPage;

@Listeners(com.qa.listeners.Listeners.class)
public class CheckoutTest extends BaseTest 
{
	@Test
	public void checkoutToEnd()
	{
		LoginPage log=new LoginPage(driver);
		log.login(url, username, password);
		
		ProductsPage pp=new ProductsPage(driver);
		pp.addItemandCheckout();
		
		CheckoutPage cop=new CheckoutPage(driver);
		cop.fillCheckoutDetails(lastname, firstname, zipcode);

		
	}

}
