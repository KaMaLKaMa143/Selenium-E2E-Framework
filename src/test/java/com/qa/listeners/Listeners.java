package com.qa.listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.BaseTest;

public class Listeners implements ITestListener
{
   @Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestStart(result);
}
   @Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}
   @Override
	public void onTestFailure(ITestResult result) 
   {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		try 
		{
			TakesScreenshot tss=(TakesScreenshot)BaseTest.driver;
			File scr=tss.getScreenshotAs(OutputType.FILE);
			File disc=new File("Screenshots/" + result.getName() + "_Failed.png");
			FileUtils.copyFile(scr, disc);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
   @Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
}
