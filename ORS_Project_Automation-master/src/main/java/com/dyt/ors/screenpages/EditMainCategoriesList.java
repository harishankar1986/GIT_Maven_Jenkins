package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class EditMainCategoriesList extends WebLibrary {

	// =========WebElements for Edit Main CategoriesList page==================
	@FindBy(xpath = "//input[@id='ors_mc_category_name']")
	public static WebElement edit_Name;

	@FindBy(xpath = "//*[@id='ors_order']/option[@selected='selected']")
	public static WebElement text_AssignedOrderdropdown;

	@FindBy(xpath = "//select[@id='ors_order']")
	public static WebElement select_AssOrder;

	@FindBy(xpath = "//input[@id='catgImage']")
	public static WebElement btn_ChooseImg;

	@FindBy(xpath = "//input[@type='submit']")
	public static WebElement btn_Submit;

	// ============Methods for Edit Main CategoriesList page==============================
	
	/*
	Name            :   verify_EditMainCategory_PrevoiusDetails
	Description		: 	This method is used to verify the expected main category name and order with actual value available on page
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	MainCategoryName - expected Main Category Name, Order -> expected order
	Modified Date	:	
	Modified By		:
	*/
	public void verify_EditMainCategory_PrevoiusDetails(String MainCategoryName, String Order) {
		boolean bstatus;
		bstatus = verifyEditboxValue(edit_Name, MainCategoryName);
		Reporter.log(bstatus, "Main Category Name text box value matched", // i have sent this
				"Main Category Name text box value not matched");

		bstatus = verifyEditboxValue(text_AssignedOrderdropdown, Order);
		Reporter.log(bstatus, "Assigned Order text box value matched", "Assigned Order text box value not matched");

	}

	// =============================================================================
	/*
	Name            :   update_EditMainCategory
	Description		: 	This method is used to update Main category name, order and upload image 
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	MainCategoryName -> updated Main category name, SelectOrder -> updated order, filePath- updated file path
	Modified Date	:	
	Modified By		:
	*/
	public void update_EditMainCategory(String MainCategoryName, String SelectOrder, String filePath) {
		boolean bstatus;
		bstatus = setValueEscape(edit_Name, MainCategoryName);
		Reporter.log(bstatus, "Main Category Name Entered", "Main Category Name Not Entered");

		bstatus = selectListItem(select_AssOrder, SelectOrder);
		Reporter.log(bstatus, "Main Category Assigned Order Selected", "Main Category Assigned Order not Selected");

		bstatus = uploadFile1(btn_ChooseImg, filePath);
		Reporter.log(bstatus, "Main Category Image Slected", "Main Category Image Not Slected");
        wait(10);
		bstatus = clickElement(btn_Submit);
		Reporter.log(bstatus, "Submit Button Clicked", "submit Button Not Clicked");

	}

	// =============================================================================
}
