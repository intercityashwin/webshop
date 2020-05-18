package demo.com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.com.qa.testbase.testbase;

public class logincredPage extends testbase {
	
	@FindBy(name="Email")
	WebElement username; 
	
	
	@FindBy(id="Password")
	WebElement passwd; 
	
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement lgnbutton; 
	
	public logincredPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void setusername(String usernamestr){
		username.sendKeys(usernamestr);
	}
	
	public void setpassword(String passwordstr){
		passwd.sendKeys(passwordstr);
	}
	
	
	public homepage clicklogin(){
		lgnbutton.click();
		return new homepage(); 
	}
	
}
