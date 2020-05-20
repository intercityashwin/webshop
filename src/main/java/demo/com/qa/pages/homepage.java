package demo.com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.com.qa.testbase.testbase;

public class homepage extends testbase{
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement lgoutlink; 
	
	@FindBy(xpath="//input[@name='updatecart']")
	WebElement updtcart; 
	
	
	@FindBy(xpath="//span[contains(text(),'Shopping cart')]")
	WebElement shpcrtlink; 
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutlink;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement termsofService; 
	
	@FindBy(xpath="//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement continuelink;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement continuelinkpost; 
	
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
	WebElement continuepostpost; 
	
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
	WebElement continuepayment; 
	
	@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
	WebElement infonextcontuniue;
	
	@FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']")
	WebElement cnfordercontinue; 
	
	@FindBy(xpath="//strong[contains(text(),'Your order has been successfully processed!')]")
	WebElement verfiymessageorderplaced; 
	
	public homepage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle(); 
	}
	
	
	public mobilephonepage navigatetoCellPhones(){
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronics')]"))).moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Cell phones')]"))).click().build().perform();
		return new mobilephonepage(); 
	
	}
	
	public boolean deleteProductFromCart(String prodname, int colnumber){
		//	"//table[@class='cart']//tbody/tr[1]/td[1]/input"	
			int rowcnt = driver.findElements(By.xpath("//table[@class='cart']//tbody/tr")).size(); 
			for(int ro = 1; ro<=rowcnt ; ro++){
				String celval = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr["+ro+"]/td["+colnumber+"]")).getText().trim(); 
				System.out.println(celval);	
					if (celval.contains(prodname)){				
						try {
							driver.findElement(By.xpath("//table[@class='cart']//tbody/tr["+ro+"]/td[1]/input")).click();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true; 
					}				
			}
		return false; 
		}
	
	public void logoutapplication(){
		lgoutlink.click();
	}
	
	public void updatecrtlink(){
		updtcart.click();
	}
	
	public void clickShoppingcrt(){
		shpcrtlink.click();
	}

	
	public void clickcheckout(){
		checkoutlink.click();
	}
	
	public void termsofServiceclick(){
		termsofService.click();
	}
	
	public void continuelink(){
		continuelink.click();
	}
	
	public void continuelinkpost(){
		continuelinkpost.click();
	}
	public void continuelinkpostpost(){
		continuepostpost.click();
	}
	
	public void continuepayment(){
	continuepayment.click();
	}
	
	public void infonextcontuniue(){
		infonextcontuniue.click();
	}
	
	public void cnfordercontinue(){
		cnfordercontinue.click();
	}
	
	public boolean verfiymessageorderplaced(){
		return (verfiymessageorderplaced.isDisplayed()); 
	}
	
}
