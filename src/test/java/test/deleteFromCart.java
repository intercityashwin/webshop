package test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import demo.com.qa.pages.homepage;
import demo.com.qa.pages.loginPage;
import demo.com.qa.pages.logincredPage;
import demo.com.qa.pages.mobilephonepage;
import demo.com.qa.testbase.testbase;
import demo.com.qa.utils.testUtil;

public class deleteFromCart extends testbase{
	logincredPage lgncredpage; 
	homepage hmpage; 
	loginPage lgnstrtpage; 
	mobilephonepage mgpage; 
	ExtentReports report; 
	ExtentTest test;
	
	
	public deleteFromCart(){
		super();
	}
	
	
	
	@BeforeMethod
	public void checkurl(){
		initialization(); 
	}
	
	
	@Test
	public void deleteFromCartProduct(){
		report = testUtil.getInstance();
		test = report.startTest("Remove Product From Cart"); 
		lgnstrtpage = new loginPage(); 
		lgncredpage = lgnstrtpage.clickloginlink();
		lgncredpage.setusername(prop.getProperty("username"));
		lgncredpage.setpassword(prop.getProperty("password"));
		hmpage = lgncredpage.clicklogin();
		test.log(LogStatus.INFO, "Log in To the Application");
		testUtil.takeScreenShot(driver, test);
		hmpage.clickShoppingcrt();
		test.log(LogStatus.INFO, "Navigate to the Shopping Cart");
		HashMap<String, String> data = testUtil.gettestdata("forms", "deleteFromCartProduct"); 
		boolean status = hmpage.deleteProductFromCart(data.get("deleteproduct").trim(), 3);
			if (status==true){
				test.log(LogStatus.PASS, "The Product  "+data.get("deleteproduct")+ "is removed from the Cart" );
				testUtil.takeScreenShot(driver, test);
				hmpage.updatecrtlink();
				test.log(LogStatus.PASS, "Update the Cart");
			}
			else{
				test.log(LogStatus.FAIL, "The Product  "+data.get("deleteproduct")+ "is removed from the Cart" );
				testUtil.takeScreenShot(driver, test);
			}
		
		
		hmpage.logoutapplication();
		test.log(LogStatus.PASS, "Logout the Application");
		
	}
	
	
	@AfterMethod
	public void teardown(){	
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
	
	
	
	
	
}
