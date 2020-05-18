package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcode {
	public static WebDriver driver;  
	
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
		
		
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("intercityashwin@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Chennai@12163");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		
		int rocnt = driver.findElements(By.xpath("//table[@class='cart']//tbody/tr")).size();
		double arr[]  = new double [rocnt]; 
		int indexvalue; 
		for(int i=1;i<=rocnt;i++){
			indexvalue = i-1; 
			String price = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr["+i+"]/td[4]")).getText().trim(); 
			double pricevalue = Double.valueOf(price); 
			
			String quantity = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr["+i+"]/td[5]/input")).getAttribute("value").trim();
			double quantityvalue = Double.valueOf(quantity); 
			
			double totalvalueexpected = pricevalue*quantityvalue; 
					
			String totalvalueui = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr["+i+"]/td[6]")).getText().trim(); 
			double totalvalueuivalue = Double.valueOf(totalvalueui); 
			
			if(totalvalueuivalue==totalvalueexpected){
				System.out.println("Test Case Pass "+  totalvalueuivalue);
				arr[indexvalue]=totalvalueuivalue; 
			}
			
		}
		double sum = 0; 
		
		for(int i =0;i<arr.length;i++){
			sum = sum + arr[i]; 
		}
		
		System.out.println("TOTAL : "+sum);
		
		String prodprice = driver.findElement(By.xpath("//span[text()='Sub-Total:']//../..//span[@class='product-price']")).getText().trim();
		double prodprocevalue = Double.valueOf(prodprice); 
			if (prodprocevalue==sum){
				System.out.println("VALIDATION IS PASSED");
			}
		
		
	}

}
