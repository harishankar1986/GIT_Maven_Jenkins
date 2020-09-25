package com.dyt.ors.screenpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class DisplaySubCategoriesList extends WebLibrary {

	// =========WebElements for Display Sub Categories List page==================

	@FindBy(xpath = "//table/thead/tr/th[1][text()='S No']")
	public static WebElement columnHeader_SNo;

	@FindBy(xpath = "//table/thead/tr/th[2][text()='Main Category']")
	public static WebElement columnHeader_MainCategory;

	@FindBy(xpath = "//th[text()='Sub Category']")
	public static WebElement columnHeader_SubCategory;

	@FindBy(xpath = "//th[text()='Order']")
	public static WebElement columnHeader_Order;

	@FindBy(xpath = "//th[text()='Action']")
	public static WebElement columnHeader_Action;

	@FindBy(xpath = "//h1[text()='Sub Categories']")
	public static WebElement text_SubCategories;

	@FindBy(xpath = "//a[@class='d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm']")
	public static WebElement btn_AddSubCategories;

	//

	// ============Methods for Display SubCategories List page==============================
	/*
	Name            :   verify_SubCategory_DisplayedColumnsHeader
	Description		: 	verify S.No, Main Category Name,Sub Category, Order, Action are visible on tabular column header
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	08th July 2020
	Modified Date	:	
	Modified By		:
	*/

	public void verify_SubCategory_DisplayedColumnsHeader() {

		boolean bstatus;
		bstatus = isElementDisplayed(columnHeader_SNo, true);
		Reporter.log(bstatus, "S.No  text  displayed in Table ",
				"Main Category Name  text field not displayed in table");

		bstatus = isElementDisplayed(columnHeader_MainCategory, true);
		Reporter.log(bstatus, "Main Category   text   displayed in table ",
				"Main Category text  not displayed in table");

		bstatus = isElementDisplayed(columnHeader_SubCategory, true);
		Reporter.log(bstatus, "Sub Category  text   displayed in table ",
				"Sub Category  text  not displayed in table");

		bstatus = isElementDisplayed(columnHeader_Order, true);
		Reporter.log(bstatus, "Order  text   displayed in table", "Order text not displayed in table");

		bstatus = isElementDisplayed(columnHeader_Action, true);
		Reporter.log(bstatus, "Action  text   displayed in table ", "Action  text  not displayed is table");

	}

	// =======================================================================
	/*
	Name            :   verify_SubCategories_PageHeader
	Description		: 	Verify Panel Header as "Sub Categories" is displayed or not
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	09th July 2020	
	Modified Date	:	
	Modified By		:
	*/
	public void verify_SubCategories_PageHeader() {

		boolean bstatus;

		bstatus = verifyText(text_SubCategories);
		Reporter.log(bstatus, "Sub Categories text displayed", "Sub Categories text not displayed");

	}

	// =======================================================================
	/*
	Name            :   verify_AddSubCategoriesLink
	Description		: 	Verify Add SubCategories Link is displayed or not
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	9th July 2020	
	Modified Date	:	
	Modified By		:
	*/

	public void verify_AddSubCategoriesLink() {

		boolean bstatus;

		bstatus = isElementDisplayed(btn_AddSubCategories, true);
		Reporter.log(bstatus, "Add Sub Categories link displayed", "Add Sub Categories link not displayed");

	}

	// =======================================================================
	/*
	Name            :   navAddSubCategoriesPage
	Description		: 	navigate to Add Sub Categories Page
	Parameters		: 	none
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Modified Date	:	
	Modified By		:
	*/

	public void navAddSubCategoriesPage() {
		boolean bstatus;
		bstatus = clickElement(btn_AddSubCategories);
		Reporter.log(bstatus, "Add Sub Categories Button Clicked", "Add Sub Categories Button not Clicked");
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

	// =============================================================================================================
	public void verify_SubCategoriesOrder(String expSubCatName, String expOrder) { 
		boolean bstatus = false;
		
		int rowcount = rowCountInTable();

		if (rowcount != 0) {
			for (int i = 1; i <= rowcount; i++) {
				String actSubCatName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				if (expSubCatName.trim().equalsIgnoreCase(actSubCatName)) {
					String actOrder = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[" + i + "]/td[4]"))
							.getText();
					if (expOrder.trim().equals(actOrder)) {
						bstatus = true;
						break;
					}

				}
			} 

			Reporter.log(bstatus, "sub Category Order verified", "sub Category Order not verified");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");

	}
	// =============================================================================================================
	/*
	Name            :   clicking_SubCategory_EditIcon
	Description		: 	This method is used to search for a particular sub category name mentioned in method parameters and click on respective Edit icon  on tabular column
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expSubCatName - Sub category name 
	Modified Date	:	
	Modified By		:
	*/

	public void clicking_SubCategory_EditIcon(String expSubCatName) { 
		boolean bstatus = false;
		
		int rowcount = rowCountInTable();

		if (rowcount != 0) {
			for (int i = 1; i <= rowcount; i++) {
				String actSubCatName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				if (expSubCatName.trim().equalsIgnoreCase(actSubCatName)) {
					driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[5]/a[1]")).click();
					bstatus = true;
					break;
				}
			}
			Reporter.log(bstatus, "Edit Icon clicked", "Edit Icon not clicked");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");
	}

	// =============================================================================================================
	/*
	Name            :   verify_UpdatedSubCategory
	Description		: 	This method is used to verify newly added data reflected into table
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expSubCatName -> expected Sub Category Name, arr[] = user given data
	Modified Date	:	
	Modified By		:
	*/
	public void verify_UpdatedSubCategory(String expSubCatName, String arr[]) { 
		boolean bstatus = false;
		
		int rowcount = rowCountInTable();
		int colCount = driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td")).size();
		
		if (rowcount != 0) {
			for (int i = 1; i <= rowcount; i++) {

				String actSubCatName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				
				if (actSubCatName.contains(expSubCatName.trim())) {

					for (int j = 2; j < colCount; j++) {
						String appText = driver
								.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[" + j + "]"))
								.getText();

						if (appText.equalsIgnoreCase(arr[j - 2])) {

							bstatus = true;
						} else {

							bstatus = false;
							break;
						}
					}
				}

			}
			System.out.println(bstatus);
			Reporter.log(bstatus, "Updated details verified", "Updated details not verified");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");

	}

	// =============================================================================================================
	/*
	Name            :   clicking_SubCategory_DeleteIcon
	Description		: 	This method is used to search for a particular record Sub category name mentioned in method parameters and click on respective Delete icon  on tabular column
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expSubCatName - expected Sub category name 
	Modified Date	:	
	Modified By		:
	*/
	public void clicking_SubCategory_DeleteIcon(String expSubCatName) { 
		boolean bstatus = false;
		
		int rowcount = rowCountInTable();
		if (rowcount != 0) {
			for (int i = 1; i <= rowcount; i++) {
				String actSubCatName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				if (expSubCatName.trim().equalsIgnoreCase(actSubCatName)) {
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

	// =============================================================================================================
	/*
	Name            :   verify_SubCategory_DeleteAlertMessage
	Description		: 	This method is used to verify alert message when clicking on Delete icon
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expAlertText -> Expected alert message
	Modified Date	:	
	Modified By		:
	*/
	public void verify_SubCategory_DeleteAlertMessage(String expAlertText) {
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
	Name            :   verify_SubCategoryInTable
	Description		: 	verify particular sub category name is exist in table
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	expSubCatName - Expected sub category name
	Modified Date	:	
	Modified By		:
	*/

	public static boolean verify_SubCategoryInTable(String expSubCatName) { 
		boolean bstatus = false;
		
		int rowcount = rowCountInTable();

		if (rowcount != 0) {
			for (int i = 1; i <= rowcount; i++) {
				String actSubCatName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				if (expSubCatName.trim().equalsIgnoreCase(actSubCatName)) {
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
	Name            :   click_CancelAlert_VerifySubCategory
	Description		: 	This method is used to cancel the alert and verify sub category name is exist in table
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expMainCatName - sub category name
	Modified Date	:	
	Modified By		:
	*/
	public void click_CancelAlert_VerifySubCategory(String expSubCatName) {

		boolean bstatus = false;
		bstatus = cancelAlert();
		Reporter.log(bstatus, "Alert Cancel button clicked", "Alert Cancel button not clicked");
		swithToMainPage();
		bstatus = verify_SubCategoryInTable(expSubCatName);
		Reporter.log(bstatus, "Sub Category Name present", "Sub Category Name not present");
	}

	// =============================================================================
	/*
	Name            :   click_OkAlert_VerifySubCategory
	Description		: 	This method is used to accept the alert and verify deleted Sub category name is still exist in table
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expSubCatName - Sub category name
	Modified Date	:	
	Modified By		:
	*/
	public void click_OkAlert_VerifySubCategory(String expSubCatName) {

		boolean bstatus = false;
		bstatus = acceptAlert();
		Reporter.log(bstatus, "Alert Ok button clicked", "Alert Ok button not clicked");
		swithToMainPage();
		wait(6);
		bstatus = verify_SubCategoryInTable(expSubCatName);
		if (bstatus == false) {
			bstatus = true;
			Reporter.log(bstatus, "Sub Category Name  deleted", "Sub Category Name not deleted");
		} else {
			Reporter.log(bstatus, "Sub Category Name not deleted", "Sub Category Name  deleted");
		}

	}

	// =============================================================================
	/*
	Name            :   wait_Time
	Description		: 	This method is used to accept the alert and verify deleted Sub category name is still exist in table
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	expSubCatName - Sub category name
	Modified Date	:	
	Modified By		:
	*/

	public void wait_Time(int seconds) {
		wait(seconds);
	}
	// =============================================================================
}
