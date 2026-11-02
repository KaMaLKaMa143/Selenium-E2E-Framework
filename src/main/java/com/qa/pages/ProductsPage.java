package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage 
{
	WebDriver driver;
	@FindBy(xpath="(//button[text()=\"Add to cart\"])[4]")
	WebElement item;
	@FindBy(className="shopping_cart_link")
	WebElement cartbutton;
	@FindBy(id="checkout")
	WebElement checkoutbutton;
	
	public ProductsPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void addItemandCheckout()
	{
		item.click();
		cartbutton.click();
		checkoutbutton.click();
	}

}
