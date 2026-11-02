package com.qa.base;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;

public class BaseTest
{
	public static WebDriver driver;
    public static String url = "";
    public static String username = "";
    public static String password = "";
    
    public static String firstname;
    public static String lastname;
    public static String zipcode;
    
    @BeforeMethod
	public void setup()
	{
		
		
		try {
			FileInputStream fis= new FileInputStream("TestData.xlsx");
			Workbook workbook= WorkbookFactory.create(fis);
			  Sheet sheet = workbook.getSheet("Sheet1");
			  url=sheet.getRow(0).getCell(1).getStringCellValue();
			  username = sheet.getRow(1).getCell(1).getStringCellValue();
	          password = sheet.getRow(2).getCell(1).getStringCellValue();
	          firstname=sheet.getRow(3).getCell(1).getStringCellValue();
	          lastname=sheet.getRow(4).getCell(1).getStringCellValue();
	          //DataFormatter formater=new DataFormatter();
	          //zipcode=formater.formatCellValue(sheet.getRow(5).getCell(1)); for converting number to string
	          // in excel before number place '123 to consider as text 
	          zipcode=sheet.getRow(5).getCell(1).getStringCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		
		
		
	}

}
