package demo.com.qa.pages;

import org.openqa.selenium.By;

import demo.com.qa.testbase.testbase;

public class cartpagetotalling extends testbase {
	
	public cartpagetotalling(){
		super();
	}

	public static boolean addVerifyTotalinCart(){
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
				return (prodprocevalue==sum);
			}else{
				return (prodprocevalue==sum);
			}
		
	}
	
	
}
