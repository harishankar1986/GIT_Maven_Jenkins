package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class EditSubCategory extends WebLibrary{
	
	//===============WebElements for Edit SubCategory============
	
		@FindBy(xpath="//table[@id='dataTable']/tbody/tr[3]/td[5]/a[1]/i")
		public static WebElement click_editicon;
		
		@FindBy(xpath="//select[@id ='mainCatgDropdown']")
		public static WebElement select_mainCategorydropdown;
		
		@FindBy(xpath="//input[@id='subCatgName']")
		public static WebElement edit_subcategory;	
		
		@FindBy(xpath="//select[@id ='ors_sub_order']")
		public static WebElement edit_Assignedorder;
		
		@FindBy(xpath="//input[@id='LitImage']")
		public static WebElement edit_Image;		
		
		@FindBy(xpath="//input[@class='btn btn-success']")
		public static WebElement Submit_button;	

	
		//==============Method for Edit icon ================================

		public static boolean selectEditicon(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int tabrowscount=rows.size();
			System.out.println(tabrowscount);
			
			for(int i=1; i<=tabrowscount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(actValue);
			if ((actValue.equals(expValue)))  {
				driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[5]/a[1]/i")).click();
				break;
				}
			}
			}
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		}
		//==============Method for Edit Sub Category==================================
		public static void editSubCategoryPage(String Maincategory, String subcategoryname, String AssignedOrder) {
			boolean bStatus;
			
			
			bStatus = selectListItem(select_mainCategorydropdown, Maincategory);
			Reporter.log(bStatus, "MainCategory entered", "MainCategory not entered");
			
			bStatus = setValueEscape(edit_subcategory, subcategoryname );
			 Reporter.log(bStatus,"Sub Category Value is Entered","Sub Category Value not entered");
					
			bStatus = selectListItem(edit_Assignedorder, AssignedOrder);
			Reporter.log(bStatus, "Order Value Selected", "Order Value not Selected");
			
			bStatus = clickElement(Submit_button);
			Reporter.log(bStatus, "Submit button clicked", "Submit button not clicked");
		}


	}


