package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class EditSubCategories extends WebLibrary {
	// =========WebElements for Edit Sub Categories page==================
	@FindBy(xpath = "//select[@id ='mainCatgDropdown']")
	public static WebElement select_mainCategorydropdown;

	@FindBy(xpath = "//input[@id='subCatgName']")
	public static WebElement edit_subcategory;

	@FindBy(xpath = "//select[@id ='ors_sub_order']")
	public static WebElement select_Assigndorder;

	@FindBy(xpath = "//input[@class='btn btn-success']")
	public static WebElement btn_Submit;

	@FindBy(xpath = "//table[@id='servDetails']/thead/tr/th[1]")
	public static WebElement text_SNo_Table1;

	@FindBy(xpath = "//th[text()='Upload Literature Image']")
	public static WebElement text_UploadLiteratureImage;

	@FindBy(xpath = "//th[text()='Upload Literature Document']")
	public static WebElement text_UploadLiteratureDocument;

	@FindBy(xpath = "//*[@id='servDetails']/thead/tr/th[4]")
	public static WebElement text_Action_Table1;

	@FindBy(xpath = "//input[@id='LitImage']")
	public static WebElement btn_LiteratureImage;

	@FindBy(xpath = "//*[@id='LitPDF']")
	public static WebElement btn_LiteratureDocument;

	@FindBy(xpath = "//i[@class='fas fa-plus']")
	public static WebElement clk_PlusSign;

	@FindBy(xpath = "//i[@class='fas fa-minus']")
	public static WebElement clk_MinusSign;

	@FindBy(xpath = "//table[@class='table']/thead/tr/td[1]")
	public static WebElement text_SNo_Table2;

	@FindBy(xpath = "//td[text()='Literature Name']")
	public static WebElement text_LiteratureName;

	@FindBy(xpath = "//td[text()='Display Status']")
	public static WebElement text_DisplayStatus;

	@FindBy(xpath = "//td[text()='Download']")
	public static WebElement text_Download;

	@FindBy(xpath = "//td[text()='Action']")
	public static WebElement text_Action_Table2;

	@FindBy(xpath = "//*[@id='mainCatgDropdown']/option[@selected='selected']")
	public static WebElement text_MainCatergorydropdown;

	@FindBy(xpath = "//*[@id='ors_sub_order']/option[@selected='selected']")
	public static WebElement text_AssignedOrderdropdown;

	// ============Methods for Edit Sub Categories page==============================
	/*
	Name            :   verify_EditSubCategory_PrevoiusDetails
	Description		: 	This method is used to verify the expected main category name, sub category name  and order with actual value available on page
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	MainCategoryName - expected Main Category Name, SubCategoryName ->expected Sub Category Name,Order -> expected order
	Modified Date	:	
	Modified By		:
	*/

	public void verify_EditSubCategory_PrevoiusDetails(String MainCategoryName, String SubCategoryName, String Order) {
		boolean bstatus;
		bstatus = verifyText(text_MainCatergorydropdown, MainCategoryName);
		Reporter.log(bstatus, "Main Category  text box value matched", "Main Category  text box value not matched");

		bstatus = verifyEditboxValue(edit_subcategory, SubCategoryName);
		Reporter.log(bstatus, "Sub Category text box value matched", "Sub Category text box value not matched");

		bstatus = verifyEditboxValue(text_AssignedOrderdropdown, Order);
		Reporter.log(bstatus, "Assigned Order text box value matched", "Assigned Order text box value not matched");

	}

	// ===========================================================================================
	/*
	Name            :   update_EditSubCategories_MainCategory
	Description		: 	This method is used to update Main Category Name only  while the other items remains same
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	MainCategoryName - updated Main Category Name
	Modified Date	:	
	Modified By		:
	*/
	//Main Category Name only should be edited while the other items remains same
	public void update_EditSubCategories_MainCategory(String MainCategoryName) {
		boolean bstatus;
		bstatus = selectListItem(select_mainCategorydropdown, MainCategoryName);
		Reporter.log(bstatus, "Main category is selected from dropdown", "Main Category is not selected");

		bstatus = clickElement(btn_Submit);
		Reporter.log(bstatus, "Submit Button is clicked", "Submit Button not clicked");

	}

	// ===========================================================================================
	/*
	Name            :   update_EditSubCategory
	Description		: 	This method is used to update Sub Category Name only  while the other items remains same.
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	SubCategoryName ->updated Sub Category Name
	Modified Date	:	
	Modified By		:
	*/
	public void update_EditSubCategory(String subcategoryname) {
		boolean bstatus;
		bstatus = setValueEscape(edit_subcategory, subcategoryname);
		Reporter.log(bstatus, "Sub Category name is Entered", "Sub Category name not entered");

		bstatus = clickElement(btn_Submit);
		Reporter.log(bstatus, "Submit Button is clicked", "Submit Button not clicked");

	}
	// ===========================================================================================
	/*
	Name            :   update_EditSubCategories_Order
	Description		: 	This method is used to update  assigned order only  while the other items remains same.
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	Order -> updated order
	Modified Date	:	
	Modified By		:
	*/

	public void update_EditSubCategories_Order(String assignOrder) {
		boolean bstatus;
		bstatus = selectListItem(select_Assigndorder, assignOrder);
		Reporter.log(bstatus, "Assigned Order is selected from dropdown", "Assigned Order is not selected");

		bstatus = clickElement(btn_Submit);
		Reporter.log(bstatus, "Submit Button is clicked", "Submit Button not clicked");

	}
	// ===========================================================================================

}
