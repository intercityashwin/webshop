package demo.com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class testUtil {

	public static ExtentReports report = null; 
	public Object data [][]; 
	
	static Workbook book; 
	static Sheet sheet; 
	
	public static ExtentTest test = null; 
	
	
	public static String ExcelFilePath = System.getProperty("user.dir")+"//src//main//java//demo//com//qa//data//demoWegShopdata.xlsx";
	
	
/*	public static void main(String[] args) {
		HashMap<String,String> datava =  gettestdata("forms","addTocart"); 

		System.out.println(datava.get("validationmsg"));
	}*/
	
	public static  HashMap<String,String> gettestdata(String SheetName, String TestcaseName){
		FileInputStream File = null; 
		HashMap<String,String> exceldata = null; 
		
		try {
			File = new FileInputStream(ExcelFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		try {
			book = WorkbookFactory.create(File);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		sheet = book.getSheet(SheetName); 
		
		for (int ro = 0 ; ro < sheet.getLastRowNum(); ro ++){
			String tcName = sheet.getRow(ro).getCell(0).toString().trim(); 
				if (tcName.equals(TestcaseName)){
					exceldata = new HashMap<String,String>(); 
					for (int col = 0;col<sheet.getRow(ro+1).getLastCellNum();col++){
						String keyname = sheet.getRow(ro+1).getCell(col).toString().trim(); 
						String keyvalue = sheet.getRow(ro+2).getCell(col).toString().trim(); 
						exceldata.put(keyname, keyvalue);
					}
					break; 
				};
		}
		
		
		return exceldata; 
	}
	
	
		// Takes Screen Shot
		public static void takeScreenShot(WebDriver driver,ExtentTest test){
			try {
				Date d = new Date(); 
				String timeStamp = d.toString().replace(" ", "_").replace(":","_");
				String screenShotPath = System.getProperty("user.dir")+"//screenshots//s_"+timeStamp+".png";
				TakesScreenshot snapshot = (TakesScreenshot)driver; 
				File f = snapshot.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(f, new File(screenShotPath));
				test.log(LogStatus.INFO, test.addScreenCapture(screenShotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		
	
	// get the instance of the Extend Report		
	public static ExtentReports getInstance(){
				
		if (report==null){
			Date d = new Date(); 
			String timeStamp = d.toString().replace(" ", "_").replace(":","_");
			String reportPath = System.getProperty("user.dir")+"//reports//r_"+timeStamp+".html";
			report = new ExtentReports(reportPath);
		}	
			return report; 
	}
	
	//webdriver explicit wait 
	
	public static void explicitwaitsforelem(WebDriver driver, String xpathValue){
		WebDriverWait wait = new WebDriverWait(driver,100); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))); 
		
	}
		
	
}
