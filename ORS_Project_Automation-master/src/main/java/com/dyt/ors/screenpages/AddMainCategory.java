package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class AddMainCategory extends WebLibrary {
	//=========WebElements for Add Main Category page==================
	
			@FindBy(xpath="//a[text()=' Add Main Categories']")
			public static WebElement btn_AddMainCategories;
			
			@FindBy(xpath="//input[@id='ors_mc_category_name']")
			public static WebElement MC_Name;	
			
			@FindBy(xpath="//select[@id='ors_order']")
			public static WebElement MC_AssOrder;
			
			@FindBy(xpath="//input[@id='catgImage']")
			public static WebElement MC_ChooseImg;	
			
			@FindBy(xpath="//input[@type='submit']")
			public static WebElement btn_Submit;	
			
	//============Methods for Add Main Category==============================
			
			public static void AddMainCategory(String MainCategoryName,String SelectOrder)
			{
				boolean bstatus;
				
				bstatus = clickElement(btn_AddMainCategories);
				Reporter.log(bstatus, "Add Main Category Button Clicked","Add Main Category Button not Clicked");
		
				bstatus = setEditValue(MC_Name, MainCategoryName);
				Reporter.log(bstatus, "Main Category Name Entered","Main Category Name Not Entered");
				
				bstatus = selectListItem(MC_AssOrder,SelectOrder);
				Reporter.log(bstatus, "Main Category Assigned Order Selected","Main Category Assigned Order Selected");
				
				bstatus = uploadFile(MC_ChooseImg, "C:\\Users\\lenavo\\Documents\\ORS_files_images\\image1.jpg");
				Reporter.log(bstatus, "Main Category Image Slected","Main Category Image Not Slected");
				
				bstatus = clickElement(btn_Submit);
				Reporter.log(bstatus, "Add MainCategory Button Clicked","Add MainCategory Button Not Clicked");
				 
			}

}

