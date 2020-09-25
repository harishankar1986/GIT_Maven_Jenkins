package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class DisplayMainCategories extends WebLibrary {

	// =========WebElements for Display Main Categories page==================

	@FindBy(xpath = "//a[text()=' Add Main Categories']")
	public static WebElement btn_AddMainCategories;

	@FindBy(xpath = "//h1[starts-with(text(),'Main')]")
	public static WebElement text_MainCategories;

	@FindBy(xpath = "//h6[starts-with(text(),'Display Main')]")
	public static WebElement text_DisplayMainCategoriesList;

	@FindBy(xpath = "//table/thead/tr/th[1][text()='S No']")
	public static WebElement text_SNo;

	@FindBy(xpath = "//th[text()='Main Categories Image']")
	public static WebElement text_MainCategoriesImage;

	@FindBy(xpath = "//th[text()='Main Categories Name']")
	public static WebElement text_MainCategoriesName;

	@FindBy(xpath = "//th[text()='Order']")
	public static WebElement text_Order;

	@FindBy(xpath = "//th[text()='Action']")
	public static WebElement text_Action;

	// ============Methods for Display Main Categories page==============================
	/*
	Name            :   verify_MainCategories_PageHeader
	Description		: 	Verify Panel Header as "MAIN CATEGORIES " is displayed or not
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	07th July 2020	
	Modified Date	:	
	Modified By		:
	*/
	public void verify_MainCategories_PageHeader() {

		boolean bstatus;

		bstatus = verifyText(text_MainCategories);
		Reporter.log(bstatus, "Main Categories text displayed", "Main Categories text not displayed");

	}

	// =============================================================================
	/*
	Name            :   verify_DisplayMainCategoriesList_TableHeader
	Description		: 	verify table header text as "Display Main Category List " is displayed or not
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Modified Date	:	
	Modified By		:
	*/

	public void verify_DisplayMainCategoriesList_TableHeader() {

		boolean bstatus;

		bstatus = verifyText(text_DisplayMainCategoriesList);
		Reporter.log(bstatus, "Display Main Categories List text displayed",
				"Display Main Categories List text not displayed");

	}

	// =============================================================================
	/*
	Name            :   navAddMainCategoriesPage
	Description		: 	navigate to Add Main Categories Page
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Modified Date	:	
	Modified By		:
	*/
	public void navAddMainCategoriesPage() {
		boolean bstatus;
		bstatus = clickElement(btn_AddMainCategories);
		Reporter.log(bstatus, "Add Main Category Button Clicked", "Add Main Category Button not Clicked");
	}


	// =========================================================================
	/*
	Name            :   verify_MainCategory_DisplayedColumnsHeader
	Description		: 	verify S.No, Main Category Image, Main Category Name, Order, Action are visible on tabular column header
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Modified Date	:	
	Modified By		:
	*/
	public void verify_MainCategory_DisplayedColumnsHeader() {

		boolean bstatus;
		bstatus = isElementDisplayed(text_SNo, true);
		Reporter.log(bstatus, "S.No  text  displayed in Table ",
				"Main Category Name  text field not displayed in table");

		bstatus = isElementDisplayed(text_MainCategoriesImage, true);
		Reporter.log(bstatus, "Main Categories Image  text   displayed in table ",
				"Main Categories Image  text  not displayed in table");

		bstatus = isElementDisplayed(text_MainCategoriesName, true);
		Reporter.log(bstatus, "Main Categories Name  text   displayed in table ",
				"Main Categories Name  text  not displayed in table");

		bstatus = isElementDisplayed(text_Order, true);
		Reporter.log(bstatus, "Order  text   displayed in table", "Order text not displayed in table");

		bstatus = isElementDisplayed(text_Action, true);
		Reporter.log(bstatus, "Action  text   displayed in table ", "Action  text  not displayed is table");

	}

	// =============================================================================================================
	/*
	Name            :   rowCountInTable
	Description		: 	count the rows from table
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/
	public static int rowCountInTable() {
		int rows = driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr/td[3]")).size();
		return rows;
	}

	// =============================================================================
	/*
	Name            :   clicking_MainCategory_EditIcon
	Description		: 	This method is used to search for a particular Main category name and click on respective Edit icon  on tabular column
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expMainCatName - Main category name 
	Modified Date	:	
	Modified By		:
	*/
	// clicking on Edit icon based on main category name
	public void clicking_MainCategory_EditIcon(String expMainCatName) {
		boolean bstatus = false;
		int rowCount = rowCountInTable();
		if (rowCount != 0) {
			for (int i = 1; i <= rowCount; i++) {
				String actMainCatName = driver
						.findElement(By.xpath("//table[@id= 'dataTable']/tbody/tr[" + i + "]/td[3]")).getText();
				if (expMainCatName.trim().equalsIgnoreCase(actMainCatName)) {
					driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[5]/a[1]")).click();
					bstatus = true;
					break;
				}
			} 
			Reporter.log(bstatus, "Edit Icon clicked", "Edit Icon not clicked");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");
	}

	// =============================================================================
	/*
	Name            :   verify_UpdatedMainCategory
	Description		: 	This method is used to verify newly added data reflected into table
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expMainCatName -> expected Main Category Name, arr[] = user given data
	Modified Date	:	
	Modified By		:
	*/
	public void verify_UpdatedMainCategory(String expMainCatName, String arr[]) {
		boolean bstatus = false;
		
		int rowCount = rowCountInTable();
		int colCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr[1]/td")).size();
		if (rowCount != 0) {
			for (int i = 1; i <= rowCount; i++) {
				String actMainCatName = driver
						.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[3]")).getText();
				if (actMainCatName.contains(expMainCatName.trim())) {
					for (int j = 3; j < colCount; j++) {
						String appText = driver
								.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[" + j + "]"))
								.getText();
						if (appText.equalsIgnoreCase(arr[j - 3])) {
							bstatus = true;
						} else {
							bstatus = false;
							break;
						}
					}
				}

			} 
			Reporter.log(bstatus, "Updated details verified", "Updated details not verified");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");

	}

	// =============================================================================
	/*
	Name            :   clicking_MainCategory_DeleteIcon
	Description		: 	This method is used to search for a particular  Main category name and click on respective Delete icon  on tabular column
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expMainCatName - expected Main category name 
	Modified Date	:	
	Modified By		:
	*/
	// clicking on Delete icon based on main category name
	public void clicking_MainCategory_DeleteIcon(String expMainCatName) {
		boolean bstatus = false;
		
		int rowCount = rowCountInTable();
		if (rowCount != 0) {
			for (int i = 1; i <= rowCount; i++) {
				String actMainCatName = driver
						.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[3]")).getText();
				if (expMainCatName.trim().equalsIgnoreCase(actMainCatName)) {
					driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[5]/a[2]")).click();
					bstatus = true;
					break;
				}
			} 
			System.out.println(bstatus);
			Reporter.log(bstatus, "Delete Icon clicked", "Delete Icon not clicked");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");
	}

	// =============================================================================
	/*
	Name            :   verify_MainCategory_DeleteAlertMessage
	Description		: 	This method is used to verify alert message when clicking on Delete icon
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expAlertText -> Expected alert message
	Modified Date	:	
	Modified By		:
	*/
	public void verify_MainCategory_DeleteAlertMessage(String expAlertText) {
		boolean bstatus;
		String actAlertText = get_AlertText();
		if (actAlertText.contains(expAlertText.trim())) {
			bstatus = true;
		} else {
			bstatus = false;
		}
		Reporter.log(bstatus, "Alert text verified", "Alert text not verified");

		System.out.println(bstatus);
	}

	// =============================================================================
	/*
	Name            :   verify_MainCategoryInTable
	Description		: 	verify particular main category name is exist in table
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expMainCatName - Expected Main category name
	Modified Date	:	
	Modified By		:
	*/
	public static boolean verify_MainCategoryInTable(String expMainCatName) {
		boolean bstatus = false;
		
		int rowCount = rowCountInTable();

		if (rowCount != 0) {
			for (int i = 1; i <= rowCount; i++) {
				String actMainCatName = driver
						.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[3]")).getText();
				if (expMainCatName.trim().equalsIgnoreCase(actMainCatName)) {
					bstatus = true;
					break;
				}
			}
		} else
			Reporter.logEvent("warning", "No result displayed in result table");

		return bstatus;
	}

	// =============================================================================
	/*
	Name            :   click_CancelAlert_VerifyMainCategory
	Description		: 	This method is used to cancel the alert and verify main category name is exist in table
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expMainCatName - Main category name
	Modified Date	:	
	Modified By		:
	*/
	public void click_CancelAlert_VerifyMainCategory(String expMainCatName) {

		boolean bstatus = false;
		bstatus = cancelAlert();
		Reporter.log(bstatus, "Alert Cancel button clicked", "Alert Cancel button not clicked");
		swithToMainPage();
		bstatus = verify_MainCategoryInTable(expMainCatName);
		Reporter.log(bstatus, "Main Category Name present", "Main Category Name not present");
	}

	// =============================================================================
	/*
	Name            :   click_OkAlert_VerifyMainCategory
	Description		: 	This method is used to accept the alert and verify deleted main category name is still exist in table
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expMainCatName - Main category name
	Modified Date	:	
	Modified By		:
	*/
	public void click_OkAlert_VerifyMainCategory(String expMainCatName) {

		boolean bstatus = false;
		bstatus = acceptAlert();
		Reporter.log(bstatus, "Alert Ok button clicked", "Alert Ok button not clicked");
		swithToMainPage();
		wait(6);
		bstatus = verify_MainCategoryInTable(expMainCatName);
		if (bstatus == false) {
			bstatus = true;
			Reporter.log(bstatus, "Main Category Name  deleted", "Main Category Name not deleted");
		} else {
			Reporter.log(bstatus, "Main Category Name not deleted", "Main Category Name  deleted");
		}

	}
	// =============================================================================
}
