package Utils; 

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ProductDataScraper {

    public static void scrapeAndSaveProducts(WebDriver driver) {
        try {
            // 1. Locate all product name and price elements on the Swag Labs inventory page
            List<WebElement> nameElements = driver.findElements(By.className("inventory_item_name"));
            List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

            // 2. Create a new Excel Workbook and Sheet using Apache POI
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Inventory Data");

            // 3. Create the Header Row (Row 0)
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Product Name");
            headerRow.createCell(1).setCellValue("Price");

            // 4. Loop through the scraped web elements and write them into rows
            for (int i = 0; i < nameElements.size(); i++) {
                String productName = nameElements.get(i).getText();
                String productPrice = priceElements.get(i).getText();

                // Create a new row for each product (starting from row 1)
                XSSFRow row = sheet.createRow(i + 1);
                
                // Column 0: Product Name
                row.createCell(0).setCellValue(productName);
                
                // Column 1: Price
                row.createCell(1).setCellValue(productPrice);
            }

            // Auto-size columns for better readability
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            // 5. Save the output Excel file to your project directory
            FileOutputStream fileOut = new FileOutputStream("SwagLabs_Product_Report.xlsx");
            workbook.write(fileOut);
            
            // Close streams and workbook
            fileOut.close();
            workbook.close();

            System.out.println("Successfully scraped product names and prices into 'SwagLabs_Product_Report.xlsx'!");

        } catch (IOException e) {
            System.out.println("Error writing to Excel file: " + e.getMessage());
        }
    }
}
