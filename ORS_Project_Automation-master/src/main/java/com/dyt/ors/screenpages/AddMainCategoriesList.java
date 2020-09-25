package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class AddMainCategoriesList extends WebLibrary {

	// =========WebElements for Add Main CategoriesList page==================

	@FindBy(xpath = "//input[@id='ors_mc_category_name']")
	public static WebElement edit_Name;

	@FindBy(xpath = "//select[@id='ors_order']")
	public static WebElement select_AssOrder;

	@FindBy(xpath = "//input[@id='catgImage']")
	public static WebElement btn_ChooseImg;

	@FindBy(xpath = "//input[@type='submit']")
	public static WebElement btn_Submit;

	@FindBy(xpath = "//h1[starts-with(text(),'Main')]")
	public static WebElement text_MainCategories;

	@FindBy(xpath = "//label[@for='ors_mc_category_name']")
	public static WebElement text_MainCategoryName;

	@FindBy(xpath = "//label[@for='ors_order']")
	public static WebElement text_Assignedorder;

	@FindBy(xpath = "//div[@class='form-group text-right']")
	public static WebElement text_CategoriesImage;

	@FindBy(xpath = "//span[contains(text(),'Name was already exist')]")
	public static WebElement error_MainCategoryNameExist;

	@FindBy(xpath = "//*[@id='ors_mc_category_name.errors']")
	public static WebElement error_MainCategoryNameMandatory;

	// ============Methods for Add Main CategoriesList page==============================
	/*
	Name            :   edit_MainCategory
	Description		: 	To set value to Main category edit box
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	MainCategoryName -> entered Main Category Name
	Modified Date	:	
	Modified By		:
	*/
	public static void edit_MainCategory(String MainCategoryName) {
		boolean bstatus;

		bstatus = setEditValue(edit_Name, MainCategoryName);
		Reporter.log(bstatus, "Main Category Name Entered", "Main Category Name Not Entered");

	}

	// =============================================================================
	/*
	Name            :   select_AssignedOrder
	Description		: 	select order based on visible text  from Assigned order drop down
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	SelectOrder -> selected order
	Modified Date	:	
	Modified By		:
	*/
	public static void select_AssignedOrder(String SelectOrder) {
		boolean bstatus;

		bstatus = selectListItem(select_AssOrder, SelectOrder);
		Reporter.log(bstatus, "Main Category Assigned Order Selected", "Main Category Assigned Order not Selected");

	}

	// =============================================================================
	/*
	Name            :   upload_Image
	Description		: 	use to upload file
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	filePath-> path of file 
	Modified Date	:	09th June 2020
	Modified By		:
	*/
	public static void upload_Image(String filePath) {
		boolean bstatus;

		bstatus = uploadFile1(btn_ChooseImg, filePath);
		Reporter.log(bstatus, "Main Category Image Slected", "Main Category Image Not Slected");

	}

	// =============================================================================
	/*
	Name            :   click_Submit
	Description		: 	click on submit
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	
	Modified Date	:	
	Modified By		:
	*/
	
	public static void click_Submit() {
		boolean bstatus;

		bstatus = clickElement(btn_Submit);
		Reporter.log(bstatus, "Submit Button Clicked", "Submit Button Not Clicked");

	}

	// =============================================================================
	/*
	Name            :   addMainCategory
	Description		: 	This method is used to add new Main category name, order and upload image 
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	MainCategoryName ->entered  Main Category Name, SelectOrder -> Order of main category, filePath -> path of uploaded file
	Modified Date	:	
	Modified By		:
	*/
	
	public void addMainCategory(String MainCategoryName, String SelectOrder, String filePath) {
		edit_MainCategory(MainCategoryName);
		select_AssignedOrder(SelectOrder);
		upload_Image(filePath);
		wait(10);
		click_Submit();
	}

	
	// =============================================================================
	/*
	Name            :   verify_AddMainCategoryListPage_DisplayedElements
	Description		: 	verify Add MainCategory List Page displayed the following controls Main Category Name ,Assigned Order,Category Images
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/
	public void verify_AddMainCategoryListPage_DisplayedElements() {

		boolean bstatus;

		bstatus = isElementDisplayed(edit_Name, true);
		Reporter.log(bstatus, "Main Category Name  text field  displayed ",
				"Main Category Name  text field not displayed");

		bstatus = isElementDisplayed(select_AssOrder, true);
		Reporter.log(bstatus, "Assigned order  drop down  displayed", "Assigned order  drop down not displayed");

		bstatus = isElementDisplayed(btn_ChooseImg, true);
		Reporter.log(bstatus, "Categories Image Choose file button displayed",
				"Categories Image  choose file button not displayed");

		bstatus = isElementDisplayed(btn_Submit, true);
		Reporter.log(bstatus, "Submit button displayed", "Submit button not displayed");

	}

	// =============================================================================
	/*
	Name            :   verify_MainCategory_DuplicateRecord
	Description		: 	This method is used to verify error massage is given as "Main Category Name was already exist" when when we clicking on submit button by entering duplicate(existing)  name in Main category field  
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	MainCategoryName -> duplicate Main Category Name, errorMsg -> expected error message
	Modified Date	:	
	Modified By		:
	*/
	// Verify duplicate records by giving existing name in below field Main Category
	public void verify_MainCategory_DuplicateRecord(String MainCategoryName, String errorMsg) {
		edit_MainCategory(MainCategoryName);
		click_Submit();
		boolean bstatus;
		bstatus = verifyText(error_MainCategoryNameExist, errorMsg); // Main Category Name was already exist
		Reporter.log(bstatus, "Error message displayed as Main Category name was already Exist",
				"Error message not displayed as Main Category name was already Exist");

	}

	// =============================================================================
	/*
	Name            :   verify_AddMainCategory_WithoutMandatoryfields
	Description		: 	This method is used to verify error massage is given as "Main Category Name is Mandatory" when we clicking on submit button with out filling mandatory fields
	Author          :   Anwesha
	Date			: 	07th July 2020
	Parameters		: 	errorMsg -> expected error message
	Modified Date	:	
	Modified By		:
	*/
	// this method will verify the error message when we clicking on submit button
	// with out filling mandatory fields
	public void verify_AddMainCategory_WithoutMandatoryfields(String errorMsg) {
		click_Submit();
		boolean bstatus;
		bstatus = verifyText(error_MainCategoryNameMandatory, errorMsg); // Main Category Name is Mandatory
		Reporter.log(bstatus, "Error message displayed as Main Category name is Mandatory",
				"Error message not displayed as Main Category name is Mandatory");

	}

	
	// =============================================================================

}
