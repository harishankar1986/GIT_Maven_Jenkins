package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class ProductDetails extends WebLibrary {

	// ===============WebElements for ProductDetails Page ====================
	@FindBy(xpath = "//th[text()='Cat No']")
	public static WebElement text_CatNo;

	@FindBy(xpath = "//th[text()='Packing unit']")
	public static WebElement text_Packingunit;

	@FindBy(xpath = "//th[text()='Price']")
	public static WebElement text_Price;

	@FindBy(xpath = "//th[text()='Availability']")
	public static WebElement text_Availability;

	@FindBy(xpath = "//h4[text()='Related Categories']")
	public static WebElement text_RelatedCategories;

	@FindBy(xpath = "//*[@id=\"lotNo\"]")
	public static WebElement edit_SearchField;

	@FindBy(xpath = "//button[@class = 'btn btn-info']")
	public static WebElement btn_Search;

	@FindBy(xpath = "//div[@id = 'errorMesg']")
	public static WebElement error_RecordsFound;

	// =================Method for ProductDetails Page =============================
	/*
	Name            :   verify_ProductDetails_DisplayedElements
	Description		: 	"Products Details" page with all detailed information about the particular product like Cat No, Packing Unit, 
	                    price and Availability are displayed or not                    	                    .
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/
	// it will search for user requested product,when find it ,click on it to see the product details page
	public void verify_ProductDetails_DisplayedElements() {
		boolean bStatus;
		bStatus = isElementDisplayed(text_CatNo, true);
		Reporter.log(bStatus, "Cat No is  displayed", "Cat No is not displayed");

		bStatus = isElementDisplayed(text_Packingunit, true);
		Reporter.log(bStatus, "Packing unit is  displayed", "Packing unit is not displayed");

		bStatus = isElementDisplayed(text_Price, true);
		Reporter.log(bStatus, "Price is  displayed", "Price is not displayed");

		bStatus = isElementDisplayed(text_Availability, true);
		Reporter.log(bStatus, "Availability is  displayed", "Availability is not displayed");

	}

	// ==========================================================================
	/*
	Name            :   verify_ProductDetails_DisplayedRelatedCategories
	Description		: 	This method is used to check Related Categories is displayed on "Products Details" page
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/
	public void verify_ProductDetails_DisplayedRelatedCategories() {
		boolean bStatus;
		bStatus = isElementDisplayed(text_RelatedCategories, true);
		Reporter.log(bStatus, "Related Categories is  displayed", "Related Categories is not displayed");

	}

	// ==========================================================================
	/*
	Name            :   verify_RelatedCategories_DisplayNames
	Description		: 	This method will print all the link names under Related Categories on "Products Details" page
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/
	// it will verify all related Categories names displaying under Related
	// Categories
	public void verify_RelatedCategories_DisplayNames() {
		boolean bStatus = false;
		int rowCount = driver.findElements(By.xpath("//div[@id='rld_Main_Sub']/div[2]/ul/li")).size();
		if (rowCount != 0)
			for (int i = 1; i <= rowCount; i++) {
				String categoriesNames = driver
						.findElement(By.xpath("//div[@id='rld_Main_Sub']/div[2]/ul/li[" + i + "]/a")).getText();
				bStatus = true;
				Reporter.log(bStatus, categoriesNames + " is  displayed under Related Categories",
						categoriesNames + " is  displayed under Related Categories");
			}
		else
			Reporter.logEvent("warning", "No result displayed in result table");
	}
	
	// ==========================================================================
	/*
	Name            :   clicking_RelatedCategoriesNames
	Description		: 	This method will click on a particular link under Related Categories on "Products Details" page 
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	ExpcategoriesNames -> name under  Related Categories
	Modified Date	:	
	Modified By		:
	*/
	// use can click on any category name under Related Categories
	public void clicking_RelatedCategoriesNames(String ExpcategoriesNames) {
		boolean bStatus = false;
		int rowCount = driver.findElements(By.xpath("//div[@id='rld_Main_Sub']/div[2]/ul/li")).size();
		if (rowCount != 0) {
			for (int i = 1; i <= rowCount; i++) {
				String ActcategoriesNames = driver
						.findElement(By.xpath("//div[@id='rld_Main_Sub']/div[2]/ul/li[" + i + "]/a")).getText();
				if (ActcategoriesNames.equalsIgnoreCase(ExpcategoriesNames)) {
					driver.findElement(By.xpath("//div[@id='rld_Main_Sub']/div[2]/ul/li[" + i + "]/a")).click();
					bStatus = true;
					break;
				}
			}
			Reporter.log(bStatus, ExpcategoriesNames + " is  clicked under Related Categories",
					ExpcategoriesNames + " is  clicked under Related Categories");
		} else
			Reporter.logEvent("warning", "No result displayed in result table");
	}

	// ==========================================================================
	/*
	Name            :   verify_COASearch_InvalidLotNo
	Description		: 	This method is used to entered invalid or null lot no in the COA Search Field and checked it is showed
	                    the expected error message or not
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	lotno - entered lot no , errorMsg - expected error message
	Modified Date	:	
	Modified By		:
	*/
	public void verify_COASearch_InvalidLotNo(String lotno, String errorMsg) {

		boolean bStatus;
		bStatus = setEditValue(edit_SearchField, lotno);
		Reporter.log(bStatus, "Lot No is entered in search field", "Lot No is not entered in search field");

		bStatus = clickElement(btn_Search);
		Reporter.log(bStatus, "search button clicked", "search button not clicked");

		bStatus = verifyText(error_RecordsFound, errorMsg);   // No Records Found
		Reporter.log(bStatus, "Error message displayed as No Records Found",
				"Error message not displayed as No Records Found");

	}

	// ==========================================================================
}
