package demo.com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.com.qa.testbase.testbase;

public class loginPage extends testbase{
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginlink; 
	
	
	public loginPage(){
		PageFactory.initElements(driver, this);
	}

	public logincredPage clickloginlink(){
		loginlink.click();
		return new logincredPage(); 
	}

}
