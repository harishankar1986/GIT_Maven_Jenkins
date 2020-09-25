package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dyt.generic.BaseClass;

public class DeleteProduct extends BaseClass {
	
	//===================To select the delete icon======================
	
		public  boolean selectDeleteicon(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int tabrowscount=rows.size();
			
			for(int i=1; i<=tabrowscount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[6]")).getText();
			
			if ((actValue.equals(expValue)))  {
				driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[15]/a[2]/i")).click();
				break;
				
				}
			}
			}
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		}
	//==========================Accept the alert=================================
		public  boolean acceptAlert() {
			boolean bStatus = true;
			try {
				driver.switchTo().alert().accept();
			}
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
		}
	//======================verify that MC is deleted from the MC List page ========================
		public  boolean verifyDeletedProduct(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int tabrowscount=rows.size();
			
			for(int i=1; i<=tabrowscount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[6]")).getText();
					
			if ((actValue.equals(expValue))) { 
				System.out.println("Product is not deleted sucessfully");}
			else {
				System.out.println("Product is deleted sucessfully");
				break;
			}
			}
			}
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		} 

}
