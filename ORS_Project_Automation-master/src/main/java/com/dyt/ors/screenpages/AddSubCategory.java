package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class AddSubCategory extends WebLibrary{
	//===============WebElements for AddSubCategory============
	  
	    @FindBy(xpath="//a[@class='d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm']")
	    public static WebElement btn_AddSubCategories;
	
		@FindBy(xpath="//select[@id ='mainCatgDropdown']")
		public static WebElement select_mainCategory;
		
		@FindBy(xpath="//input[@id ='subCatgName']")
		public static WebElement Enter_SubCategory;
		
		@FindBy(xpath="//select[@id ='ors_sub_order']")
		public static WebElement select_AssignedOrder;
		
		@FindBy(xpath="//input[@id='LitImage']")
		public static WebElement select_LiteratureImage;
		
		@FindBy(xpath="//input[@id='LitPDF']")
		public static WebElement select_LiteratureDocument;
		
		@FindBy(xpath="//input[@class='btn btn-success']")
		public static WebElement Submit_Button;
			
	//===============Method for Add Sub Category==============================
		
		
		public static void AddSubCategory(String maincategoryname, String subcategoryname, String Assignorder)
		{
		boolean bstatus;
		
		bstatus = clickElement(btn_AddSubCategories);
		Reporter.log(bstatus, "Add Sub Category Button Clicked","Add Sub Category Button not Clicked");
		
		 bstatus = selectListItem(select_mainCategory, maincategoryname );
		 Reporter.log(bstatus,"Main category is selected from dropdown","Main Category is not selected");
		 
		 bstatus = setEditValue(Enter_SubCategory, subcategoryname );
		 Reporter.log(bstatus,"Sub Category Value is Entered","Sub Category Value not entered");	
			
		 bstatus = selectListItem(select_AssignedOrder,Assignorder);
		 Reporter.log(bstatus,"Assigned Order is selected from dropdown","Assigned Order is not selected");
		 
		 /*bstatus = uploadFile(select_LiteratureImage, "C:\\Users\\lenavo\\Documents\\ORS_files_images\\image2.jpg");
		 Reporter.log(bstatus, "Literature Image Slected","Literature Image Not Slected");
		 
		 bstatus = uploadFile(select_LiteratureDocument, "C:\\Users\\lenavo\\Documents\\ORS_files_images\\samplePFD.pdf");
		 Reporter.log(bstatus, "Literature Document Slected","Literature Document Not Slected");*/
		
		 bstatus = clickElement(Submit_Button);
		 Reporter.log(bstatus,"Submit Button is clicked","Submit Button not clicked");
		 
		}
	}


