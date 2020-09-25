package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class AddSubCategories extends WebLibrary {
	// =========WebElements for Add Sub Categories page==================
	@FindBy(xpath = "//select[@id ='mainCatgDropdown']")
	public static WebElement select_mainCategory;

	@FindBy(xpath = "//input[@id ='subCatgName']")
	public static WebElement edit_SubCategory;

	@FindBy(xpath = "//select[@id ='ors_sub_order']")
	public static WebElement select_AssignedOrder;

	@FindBy(xpath = "//input[@id='LitImage']")
	public static WebElement select_LiteratureImage;

	@FindBy(xpath = "//input[@id='LitPDF']")
	public static WebElement select_LiteratureDocument;

	@FindBy(xpath = "//input[@class='btn btn-success']")
	public static WebElement btn_Submit;
	
	@FindBy(xpath = "//span[contains(text(),'Name was already exist')]")
	public static WebElement error_SubCategoryNameExist;
	
	@FindBy(xpath = "//table[@id='servDetails']/thead/tr/th[1]")
	public static WebElement text_SNo_Table1;
	
	@FindBy(xpath = "//th[text()='Upload Literature Image']")
	public static WebElement text_UploadLiteratureImage;
	
	@FindBy(xpath = "//th[text()='Upload Literature Document']")
	public static WebElement text_UploadLiteratureDocument;
	
	@FindBy(xpath = "//*[@id='servDetails']/thead/tr/th[4]")
	public static WebElement text_Action_Table1;
	
	@FindBy(xpath="//input[@id='LitImage']")
	public static WebElement btn_LiteratureImage;
	
	@FindBy(xpath="//*[@id='LitPDF']")
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

	// ============Methods for Add Sub Categories page==============================
	/*
	Name            :   verify_AddSubCategoriesPage_DisplayedElements
	Description		: 	verify Add MainCategory List Page displaying the following controls Main Category Name ,Sub Category Name,Assigned Order,Category Images
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/

	public  void verify_AddSubCategoriesPage_DisplayedElements() {

		boolean bstatus;

		bstatus = isElementDisplayed(select_mainCategory, true);
		Reporter.log(bstatus, "Main Category drop displayed ", "Main Category  drop down not displayed");

		bstatus = isElementDisplayed(edit_SubCategory, true);
		Reporter.log(bstatus, "Sub Category text field displayed", "Sub Category text field not displayed");

		bstatus = isElementDisplayed(select_AssignedOrder, true);
		Reporter.log(bstatus, "Assigned order drop down  displayed", "Assigned order drop down not displayed");

		bstatus = isElementDisplayed(btn_Submit, true);
		Reporter.log(bstatus, "Submit button displayed", "Submit button not displayed");

	}
	
	// =============================================================================
	/*
	Name            :   select_MainCategoryName
	Description		: 	select main category  based on visible text from Main category drop down
	Author			: 	Anwesha
	Date			: 	07th July 2020
	Parameters		: 	maincategoryname -> selected main category name
	Modified Date	:	
	Modified By		:
	*/
	
	public static void select_MainCategoryName(String maincategoryname) {
		boolean bstatus;

		bstatus = selectListItem(select_mainCategory, maincategoryname);
		Reporter.log(bstatus, "Main category is selected from dropdown", "Main Category is not selected");
		
	}

	// =============================================================================
	/*
	Name            :   edit_SubCategoryName
	Description		: 	To set value to Sub category text field
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	subcategoryname -> entered sub category name
	Modified Date	:	
	Modified By		:
	*/
	public static void edit_SubCategoryName(String subcategoryname) {
		boolean bstatus;

		bstatus = setEditValue(edit_SubCategory, subcategoryname);
		Reporter.log(bstatus, "Sub Category name is Entered", "Sub Category name not entered");
		
	}

	// =============================================================================
	/*
	Name            :   select_AssignedOrderValue
	Description		: 	select order  based on visible text from Assigned order drop down
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	assignorder -> selected order
	Modified Date	:	
	Modified By		:
	*/
	public static void select_AssignedOrderValue(String assignorder) {
		boolean bstatus;

		bstatus = selectListItem(select_AssignedOrder, assignorder);
		Reporter.log(bstatus, "Assigned Order is selected from dropdown", "Assigned Order is not selected");

		
	}

	// =============================================================================
	/*
	Name            :   click_SubmitButton
	Description		: 	click on submit button
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	none
	Modified Date	:	
	Modified By		:
	*/
	public static void click_SubmitButton() {
		boolean bstatus;

		bstatus = clickElement(btn_Submit);
		Reporter.log(bstatus, "Submit Button is clicked", "Submit Button not clicked");

		
	}
	// =============================================================================
	/*
	Name            :   upload_Image
	Description		: 	This method is used to upload image
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	filePath -> path of the uploaded image
	Modified Date	:	
	Modified By		:
	*/
	public static void upload_Image(String filePath) {
		boolean bstatus;

		bstatus = uploadFile1(btn_LiteratureImage, filePath);
		Reporter.log(bstatus, "Image Slected", "Image Not Slected");

	}
	// =============================================================================
	/*
	Name            :   addSubCategory
	Description		: 	This method is used to add new Sub category name under a particular main category name, order and upload image 
	Author			: 	Anwesha
	Date			: 	09th July 2020
	Parameters		: 	maincategoryname -> selected Main Category Name, subcategoryname->entered sub Category Name,assignorder -> selected Order , filePath -> path of uploaded file
	Modified Date	:	
	Modified By		:
	*/
	public void addSubCategory(String maincategoryname, String subcategoryname, String assignorder,String filePath) {
		
		select_MainCategoryName(maincategoryname);
		edit_SubCategoryName(subcategoryname);
		select_AssignedOrderValue(assignorder);
		upload_Image(filePath);
		wait(20);
		click_SubmitButton();

	}
	
	// =============================================================================
	/*
	Name            :   addSubCategory_WithoutMandatoryfields
	Description		: 	This method is used to verify alert massage is given as "Sub Category is Mandatory" when we clicking on submit button with out filling mandatory fields
	Author          :   Anwesha
	Date			: 	09th July 2020
	Parameters		: 	ExpAlertText -> expected error message
	Modified Date	:	
	Modified By		:
	*/
	public  void addSubCategory_WithoutMandatoryfields(String ExpAlertText) {
		boolean bstatus;

		click_SubmitButton();

		String actAlertText = get_AlertText();
		if (actAlertText.contains(ExpAlertText.trim())) {
			bstatus = true;
		} else {
			bstatus = false;
		}
		Reporter.log(bstatus, "Alert text verified", "Alert text not verified");
		System.out.println(bstatus);

		bstatus = acceptAlert();
		Reporter.log(bstatus, "Alert Ok button clicked", "Alert Ok button not clicked");
	}
	// =============================================================================
	/*
	Name            :   addSubCategory_WithoutSelectingOrder
	Description		: 	This method is used to verify user can able to create a sub category name under a particular main category without giving order
	Author          :   Anwesha
	Date			: 	09th July 2020
	Parameters		: 	maincategoryname -> selected main category name, subcategoryname-> entered sub category name
	Modified Date	:	
	Modified By		:
	*/ 
	   public  void addSubCategory_WithoutSelectingOrder(String maincategoryname, String subcategoryname) {
		   select_MainCategoryName(maincategoryname);
		   edit_SubCategoryName(subcategoryname);
		   click_SubmitButton();
		   
	}
	 // =============================================================================
	   /*
		Name            :   verify_AddSubCategory_DuplicateRecord
		Description		: 	This method is used to verify error massage is given as "Sub Category Name was already exist" when when we clicking on submit button by entering duplicate(existing)  name in Sub category field under a main category  
		Author			: 	Anwesha
		Date			: 	09th July 2020
		Parameters		: 	maincategoryname -> selected Main Category Name,subcategoryname-> entered duplicate sub category name, assignorder-> selected order,errorMsg -> expected error message
		Modified Date	:	
		Modified By		:
		*/
		// Verify duplicate records by giving existing name in below sub Category field 
				public  void verify_AddSubCategory_DuplicateRecord(String maincategoryname, String subcategoryname, String assignorder,String errorMsg) {
					boolean bstatus;
					select_MainCategoryName(maincategoryname);
					edit_SubCategoryName(subcategoryname);
					select_AssignedOrderValue(assignorder);
					click_SubmitButton();
					bstatus = verifyText(error_SubCategoryNameExist,errorMsg);  //Sub Category Name was already exist
					Reporter.log(bstatus, "Error message displayed as Sub Category Name was already exist",
							"Error message not displayed as Sub Category Name was already exist");

				}
	

	// =============================================================================
	   

}
