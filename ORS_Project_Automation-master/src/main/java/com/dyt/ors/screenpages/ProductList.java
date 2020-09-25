package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class ProductList extends WebLibrary {
	//===============WebElements for ProductList Page ====================
	
	
	
	//=================Method for ProductList Page =============================
	/*
	Name            :   clickOnProduct
	Description		: 	This method is used to search a product from the product list,after finding it, check the availability of product, if available,
	                    then it will redirect to product details page
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	productname -> product name 
	Modified Date	:	
	Modified By		:
	*/
	// it will search for user request product,when  find it ,click on it to see the product details
	public  void clickOnProduct(String expProductname) {
		boolean bstatus = false;
		List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='col-md-8 ']/div/div[2]/table/tbody/tr[1]/td[3]"));
		
		for(int i=1; i<=productNames.size();i++) {
			String actProductName  = driver.findElement(By.xpath("//div[@class='col-md-8 ']/div["+i+"]/div[2]/table/tbody/tr[1]/td[3]/h5/a")).getText();
			if(actProductName.equalsIgnoreCase(expProductname.trim())) {
				String actAvailability =driver.findElement(By.xpath("//div[@class='col-md-8 ']/div["+i+"]/div[2]/table/tbody/tr[3]/td[3]/a/span")).getText();
				 if(!actAvailability.contains("Contact Us")) {
					 driver.findElement(By.xpath("//div[@class='col-md-8 ']/div["+i+"]/div[2]/table/tbody/tr[1]/td[3]/h5/a")).click();
					 bstatus = true;
					 break;
				 }
			}
		}
		
		Reporter.log(bstatus, "Product link Clicked", "Product link Not Clicked");
		
		
	}
	//==========================================================================
	
	
	

}
