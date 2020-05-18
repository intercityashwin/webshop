package demo.com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.com.qa.testbase.testbase;

public class mobilephonepage extends testbase{
	
	@FindBy(xpath="//a[contains(text(),'Smartphone')]//../..//input")
	WebElement smartphonelink; 
	
	@FindBy(xpath="//p[@class='content']")
	WebElement status; 
	
	@FindBy(xpath="//span[contains(text(),'Shopping cart')]")
	WebElement shpcrtlink; 
	
	@FindBy(xpath="//a[contains(text(),'Used phone')]//../..//input")
	WebElement phonelink; 
	
	@FindBy(xpath="//input[@name='updatecart']")
	WebElement updtcart; 
	
	
	public mobilephonepage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickinusedphone(){
		phonelink.click();
	}
	
	public void clickonsmartphonecart(){
		smartphonelink.click();
	}


	public String checkstatusmessagecart(){
		return status.getText().trim();               //"The product has been added to your "
	}
	
	
	public void clickshopcartlink(){
		shpcrtlink.click();
	}
	
	
	public boolean verifytheproductaddtocart(int colnumber, String expvalue){
		int rowcnt = driver.findElements(By.xpath("//table[@class='cart']//tbody/tr")).size(); 
			for(int ro = 1; ro<=rowcnt ; ro++){
				String celval = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr["+ro+"]/td["+colnumber+"]")).getText().trim(); 
				System.out.println(celval);	
					if (celval.equals(expvalue)){				
						JavascriptExecutor js = (JavascriptExecutor)driver; 
						WebElement elemt = driver.findElement(By.xpath("//a[contains(text(),'"+expvalue+"') and contains(@class,'product')]"));
						try {
							js.executeScript("arguments[0].scrollIntoView();",elemt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true; 
					}				
			}
		return false; 
	}
	
	

	public void clickUpdateCart(){
		updtcart.click();
	}

}
