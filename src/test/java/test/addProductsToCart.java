package test;

import java.util.HashMap;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import demo.com.qa.pages.cartpagetotalling;
import demo.com.qa.pages.homepage;
import demo.com.qa.pages.loginPage;
import demo.com.qa.pages.logincredPage;
import demo.com.qa.pages.mobilephonepage;
import demo.com.qa.testbase.testbase;
import demo.com.qa.utils.testUtil;

public class addProductsToCart extends testbase{
	logincredPage lgncredpage; 
	homepage hmpage; 
	loginPage lgnstrtpage; 
	mobilephonepage mgpage; 
	ExtentReports report; 
	ExtentTest test;
	
	public addProductsToCart(){
		super();
	}
	
	@BeforeMethod
	public void checkurl(){
		initialization(); 
		System.out.println("URL Launched");
	}
	
	@Test(priority=1)
	public void addCellPhoneToCart(){
		report = testUtil.getInstance();
		test = report.startTest("Add the Cell Phone to the cart"); 
		lgnstrtpage = new loginPage(); 
		lgncredpage = lgnstrtpage.clickloginlink();
		lgncredpage.setusername(prop.getProperty("username"));
		lgncredpage.setpassword(prop.getProperty("password"));
		hmpage = lgncredpage.clicklogin();
		test.log(LogStatus.INFO, "Log in To the Application");
		testUtil.takeScreenShot(driver, test);
		//String tit = hmpage.getTitle(); 
		//System.out.println(tit);
		mgpage = hmpage.navigatetoCellPhones(); 
		test.log(LogStatus.INFO, "Navigate to Cell phones section");
		mgpage.clickonsmartphonecart();
		String msg = mgpage.checkstatusmessagecart();
		HashMap<String, String> data = testUtil.gettestdata("forms", "addTocart"); 
		System.out.println(msg);
		if (msg.contains(data.get("validationmsg").trim())){
			test.log(LogStatus.PASS, "Validate the Message");
			testUtil.takeScreenShot(driver, test);
			System.out.println("ADDED TO CART");
		}
		else
		{
			test.log(LogStatus.FAIL, "Validate the Message");
			testUtil.takeScreenShot(driver, test);
		}
		
		mgpage.clickshopcartlink();
		test.log(LogStatus.PASS, "Click on the Shopcart Link");
		
		if (mgpage.verifytheproductaddtocart(3, "Smartphone") == true){
			test.log(LogStatus.PASS, "Validate the Presence of Smartphone in the Cart");
			testUtil.takeScreenShot(driver, test);
		}
		else{
			test.log(LogStatus.FAIL, "Validate the Presence of Smartphone in the Cart");
			testUtil.takeScreenShot(driver, test);
		}
		
		hmpage.logoutapplication();
		test.log(LogStatus.PASS, "Logout the Application");
	
		
	}
	
	
	@Test(priority=2)
	public void addUsedPhone(){
		report = testUtil.getInstance();
		test = report.startTest("Add the Used Phone to the cart"); 
		lgnstrtpage = new loginPage(); 
		lgncredpage = lgnstrtpage.clickloginlink();
		lgncredpage.setusername(prop.getProperty("username"));
		lgncredpage.setpassword(prop.getProperty("password"));
		hmpage = lgncredpage.clicklogin();
		test.log(LogStatus.INFO, "Log in To the Application");
		testUtil.takeScreenShot(driver, test);
		//String tit = hmpage.getTitle(); 
		//System.out.println(tit);
		mgpage = hmpage.navigatetoCellPhones(); 
		test.log(LogStatus.INFO, "Navigate to Cell phones section");
		mgpage.clickinusedphone();
		String msg = mgpage.checkstatusmessagecart();
		HashMap<String, String> data = testUtil.gettestdata("forms", "addTocart"); 
		System.out.println(msg);
		if (msg.contains(data.get("validationmsg").trim())){
			test.log(LogStatus.PASS, "Validate the Message");
			testUtil.takeScreenShot(driver, test);
			System.out.println("ADDED TO CART");
		}
		else
		{
			test.log(LogStatus.FAIL, "Validate the Message");
			testUtil.takeScreenShot(driver, test);
		}
		
		mgpage.clickshopcartlink();
		test.log(LogStatus.PASS, "Click on the Shopcart Link");
		
		if (mgpage.verifytheproductaddtocart(3, "Used phone") == true){
			test.log(LogStatus.PASS, "Validate the Presence of Used Phone in the Cart");
			testUtil.takeScreenShot(driver, test);
		}
		else{
			test.log(LogStatus.FAIL, "Validate the Presence of Used Phone in the Cart");
			testUtil.takeScreenShot(driver, test);
		}
		
		hmpage.logoutapplication();
		test.log(LogStatus.PASS, "Logout the Application");
	
		
	}
	
	@Test(priority=3)
	public void verifytheadditionofcost(){
		report = testUtil.getInstance();
		test = report.startTest("Verify the Addition of Product Values in the Cart"); 
		lgnstrtpage = new loginPage(); 
		lgncredpage = lgnstrtpage.clickloginlink();
		lgncredpage.setusername(prop.getProperty("username"));
		lgncredpage.setpassword(prop.getProperty("password"));
		hmpage = lgncredpage.clicklogin();
		test.log(LogStatus.INFO, "Log in To the Application");
		testUtil.takeScreenShot(driver, test);
		hmpage.clickShoppingcrt();
		test.log(LogStatus.INFO, "Navigate to Shopping cart and perfom the Calculation");
		boolean verStatus = cartpagetotalling.addVerifyTotalinCart();
			if (verStatus==true){
				test.log(LogStatus.PASS, "The Cart Calculation is Verified");
				testUtil.takeScreenShot(driver, test);
			}else{
				test.log(LogStatus.FAIL, "The Cart Calculation is Verified");
				testUtil.takeScreenShot(driver, test);
			}
		hmpage.logoutapplication();
		test.log(LogStatus.PASS, "Logout the Application");
	}

	
	@Test(priority=4)
	public void verifytheoderplacemessage(){
		report = testUtil.getInstance();
		test = report.startTest("Place the Order and Fetch the order ID"); 
		lgnstrtpage = new loginPage(); 
		lgncredpage = lgnstrtpage.clickloginlink();
		lgncredpage.setusername(prop.getProperty("username"));
		lgncredpage.setpassword(prop.getProperty("password"));
		hmpage = lgncredpage.clicklogin();
		test.log(LogStatus.INFO, "Log in To the Application");
		testUtil.takeScreenShot(driver, test);
		hmpage.clickShoppingcrt();
		test.log(LogStatus.INFO, "Navigate to Shopping Cart");
		hmpage.termsofServiceclick();
		hmpage.clickcheckout();
		hmpage.continuelink();
		hmpage.continuelinkpost();
		hmpage.continuelinkpostpost();
		hmpage.continuepayment();
		hmpage.infonextcontuniue();
		hmpage.cnfordercontinue();
		test.log(LogStatus.INFO, "Navigate To Final Submit Page");
		boolean msg = hmpage.verfiymessageorderplaced();
			if (msg==true){
				testUtil.takeScreenShot(driver, test);
				String orderID = driver.findElement(By.xpath("//li[contains(text(),'Order number')]")).getText(); 
				String str  []= orderID.split(":");
				test.log(LogStatus.PASS, "Order Placed Successfully !!!! with order ID - > "+ str[1]);
			}else{
				test.log(LogStatus.FAIL, "Order not placed !!!!");
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
