package demo.com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testbase {
	
	public static WebDriver driver; 
	public static Properties prop; 
	
	
	public testbase(){
		FileInputStream fis = null; 
		prop = new Properties(); 
		try {
			 	//fis = new FileInputStream("D://Selenium Class//domoWebShop//src//main//java//demo//com//qa//config/config.properties");
			 	fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//demo//com//qa//config/config.properties");
			 	
			 	
			 	System.out.println("Config File Loaded");
			 	System.out.println(System.getProperty("user.dir"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			prop.load(fis);
			System.out.println(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
		
	}
	
	public void waitforElement(WebElement ele, String str){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str))); 
	}

}
