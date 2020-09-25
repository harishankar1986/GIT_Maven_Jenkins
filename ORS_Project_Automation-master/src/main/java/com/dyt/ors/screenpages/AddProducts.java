package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class AddProducts extends WebLibrary {
	// =========WebElements for AddProducts page================

	@FindBy(xpath = "//span[text()='Products']")
	public static WebElement navlink_Products;

	@FindBy(xpath = "//a[text()='Products']")
	public static WebElement link_Products;

	@FindBy(xpath = "//a[text()=' Add Products']")
	public static WebElement btn_AddProducts;

	@FindBy(xpath = "//select[@id='ors_mc_id']")
	public static WebElement select_MainCategory;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[1]/div[1]/div/label")
	public static WebElement text_SelectMainCatergories;

	@FindBy(xpath = "//select[@id='subCatg']")
	public static WebElement select_SubCategory;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[1]/div[3]/div/span")
	public static WebElement text_SelectSubCategories;

	@FindBy(xpath = "//input[@id='catNo']")
	public static WebElement edit_CatNo;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[2]/div[1]/div/label")
	public static WebElement text_CatNo;

	@FindBy(xpath = "//input[@id='prdDesc']")
	public static WebElement edit_prdDesc;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[2]/div[3]/div/label")
	public static WebElement text_ProductDescription;

	@FindBy(xpath = "//input[@id='prdGrade']")
	public static WebElement edit_prdGrade;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[3]/div[1]/div/label")
	public static WebElement text_ProductGrade;

	@FindBy(xpath = "//input[@id='prdSynon']")
	public static WebElement edit_synonyms;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[3]/div[3]/div/label")
	public static WebElement text_Synonyms;

	@FindBy(xpath = "//input[@id='prdCasNo']")
	public static WebElement edit_prdCasNo;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[4]/div[1]/div/label")
	public static WebElement text_CasNo;

	@FindBy(xpath = "//input[@id='prdMake']")
	public static WebElement edit_Make;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[4]/div[3]/div/label")
	public static WebElement text_EnterMake;

	@FindBy(xpath = "//input[@name='ors_prds_pack_size']")
	public static WebElement edit_packsize;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[5]/div[1]/div/label")
	public static WebElement text_PackSize;

	@FindBy(xpath = "//input[@name='ors_prds_avalibility']")
	public static WebElement edit_prdAvalibility;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[5]/div[3]/div/label")
	public static WebElement text_Available;

	@FindBy(xpath = "//input[@name='ors_prds_HS_code']")
	public static WebElement edit_HsCode;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[6]/div[1]/div/label")
	public static WebElement text_HSCode;

	@FindBy(xpath = "//input[@name='ors_prds_price']")
	public static WebElement edit_PrdPrice;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[6]/div[3]/div/label")
	public static WebElement text_ProductPrice;

	@FindBy(xpath = "//select[@id='ors_prds_orderBy']")
	public static WebElement select_Assignorder;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[7]/div[1]/div/label")
	public static WebElement text_Assignedorder;

	@FindBy(xpath = "//input[@id='prdImage']")
	public static WebElement edit_prdImage;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[8]/div[1]/div/label")
	public static WebElement text_ProductImage;

	@FindBy(xpath = "//input[@id='prdSDS']")
	public static WebElement edit_prdSDS;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[9]/div[1]/div/label")
	public static WebElement text_SDS;

	@FindBy(xpath = "//input[@id='prdPSS']")
	public static WebElement edit_prdPSS;

	@FindBy(xpath = "//*[@id=\"prod\"]/div[10]/div[1]/div/label")
	public static WebElement text_SpecificationSheet;

	@FindBy(xpath = "//*[@id=\"servDetails\"]/thead/tr/th[1]")
	public static WebElement text_SNo;

	@FindBy(xpath = "//input[@id='ors_cao_lotNo']")
	public static WebElement edit_caolotNo;

	@FindBy(xpath = "//*[@id=\"servDetails\"]/thead/tr/th[2]")
	public static WebElement text_LotNo;

	@FindBy(xpath = "//input[@id='coaPDF']")
	public static WebElement edit_coaPDF;

	@FindBy(xpath = "//*[@id=\"servDetails\"]/thead/tr/th[3]")
	public static WebElement text_AttachDocument;

	@FindBy(xpath = "//*[@id='servDetails']/tbody/tr/td[4]/i")
	public static WebElement clk_PlusSign;

	@FindBy(xpath = "//*[@id='servDetails']/tbody/tr/td[5]/i")
	public static WebElement clk_MinusSign;

	@FindBy(xpath = "//*[@id=\"servDetails\"]/thead/tr/th[4]")
	public static WebElement text_Action;

	@FindBy(xpath = "//input[@class='btn btn-success']")
	public static WebElement btn_submit;

	// =========================================================
	// ==================================================================================================
	/*
	 * Name        : verify_AddProductCategoryPage_DisplayedElements 
	 * Description : verify Add Product category page contains the following controls Main Category,Sub
	                 Category,Availability,Cat No,Pack Size,Make, Product Description,Product ,Price,Product Grade,Cas No,HS Code,Order By 
	 Parameters    : none
	 Author        : Anwesha 
	 Date          : 10th July 2020
	 Modified Date : 
	 Modified By 
	 */
	public void verify_AddProductCategoryPage_DisplayedElements() {

		boolean bstatus;

		bstatus = isElementDisplayed(select_MainCategory, true);
		Reporter.log(bstatus, "Select Main Catergories  dropdown displayed",
				" Select Main Catergories  dropdown not displayed");

		bstatus = isElementDisplayed(select_SubCategory, true);
		Reporter.log(bstatus, "Select SubCategories  dropdown displayed",
				"Select SubCategories  dropdown not displayed");

		bstatus = isElementDisplayed(edit_prdAvalibility, true);
		Reporter.log(bstatus, "Available  text field displayed", "Available  text field not displayed");

		bstatus = isElementDisplayed(edit_CatNo, true);
		Reporter.log(bstatus, "CatNo  text field displayed", "CatNo  text field not displayed");

		bstatus = isElementDisplayed(edit_packsize, true);
		Reporter.log(bstatus, "Enter Pack Size  text field displayed", "Enter Pack Size  text field not displayed");

		bstatus = isElementDisplayed(edit_Make, true);
		Reporter.log(bstatus, "Enter Make  text field displayed", "Enter Make  text field not displayed");

		bstatus = isElementDisplayed(edit_prdDesc, true);
		Reporter.log(bstatus, "Product Description  text field displayed",
				"Product Description  text field not displayed");

		bstatus = isElementDisplayed(edit_PrdPrice, true);
		Reporter.log(bstatus, "Product Price  text field displayed", "Product Price text field not displayed");

		bstatus = isElementDisplayed(edit_HsCode, true);
		Reporter.log(bstatus, "HSCode  text field displayed", "HSCode  text field not displayed");

		bstatus = isElementDisplayed(edit_prdCasNo, true);
		Reporter.log(bstatus, "Cas No  text field displayed", "Cas No  text field not displayed");

		bstatus = isElementDisplayed(edit_synonyms, true);
		Reporter.log(bstatus, "Synonyms  text field displayed", "Synonyms  text field not displayed");

		bstatus = isElementDisplayed(select_Assignorder, true);
		Reporter.log(bstatus, "Assigned order dropdown displayed", "Assigned order  dropdown  not displayed");

		bstatus = isElementDisplayed(edit_prdImage, true);
		Reporter.log(bstatus, "Product Image  button displayed", "Product Image button   not displayed");

		bstatus = isElementDisplayed(edit_prdSDS, true);
		Reporter.log(bstatus, "SDS  button displayed", "SDS button not displayed");

		bstatus = isElementDisplayed(edit_prdPSS, true);
		Reporter.log(bstatus, "Product Specification Sheet button displayed",
				"Product Specification Sheet  button not displayed");

		bstatus = isElementDisplayed(edit_prdGrade, true);
		Reporter.log(bstatus, "Product Grade  text field displayed", "Product Grade  text not displayed");

		bstatus = isElementDisplayed(edit_caolotNo, true);
		Reporter.log(bstatus, "LotNo  text field displayed", "LotNo  text field not displayed");

		bstatus = isElementDisplayed(edit_coaPDF, true);
		Reporter.log(bstatus, "Attach Document  button displayed", "Categories Image  button not displayed");

		bstatus = isElementDisplayed(clk_PlusSign, true);
		Reporter.log(bstatus, "Plus Sign button displayed", "Plus Sign button not displayed");

		bstatus = isElementDisplayed(clk_MinusSign, true);
		Reporter.log(bstatus, "Minus Sign button displayed", "Minus Sign button  not displayed");

		bstatus = isElementDisplayed(btn_submit, true);
		Reporter.log(bstatus, "submit button is displayed", "submit button is not displayed");

	}

	// ===================================================================================================
	/*
	 * Name        : AddProduct 
	 * Description : this method is used to add a new product
	 * Parameters  : NameMainCategory,NameSubCategory,Catno,prdDesc,prdGrade,synonyms, prdCasNo, Make, packsize, prdAvalibility, HsCode, PrdPrice,
	                selectorder, file1, file2,file3,lotNo,file4 
	 * Author      : Anwesha 
	 * Date        : 10th July 2020 
	 * Modified Date : 
	 * Modified By :
	 */
	public void AddProduct(String NameMainCategory, String NameSubCategory, String Catno, String prdDesc,
			String prdGrade, String synonyms, String prdCasNo, String Make, String packsize, String prdAvalibility,
			String HsCode, String PrdPrice, String selectorder, String file1, String file2, String file3, String lotNo,
			String file4) {
		boolean bStatus;

		bStatus = selectListItem(select_MainCategory, NameMainCategory);
		Reporter.log(bStatus, "MainCategory is selected from the dropdown",
				"MainCategory is not selected from the dropdown");

		bStatus = selectListItem(select_SubCategory, NameSubCategory);
		Reporter.log(bStatus, "SubCategory is selected from the dropdown",
				"SubCategory is not selected from the dropdown");

		bStatus = setEditValue(edit_CatNo, Catno);
		Reporter.log(bStatus, "Catno is inputed in the textbox", "Catno is not inputed in the textbox");

		bStatus = setEditValue(edit_prdDesc, prdDesc);
		Reporter.log(bStatus, "Product Description is inputed in the textbox",
				"Product Description is not inputed in the textbox");

		bStatus = setEditValue(edit_prdGrade, prdGrade);
		Reporter.log(bStatus, "Product grade is inputed in the textbox", "Product grade is not inputed in the textbox");

		bStatus = setEditValue(edit_synonyms, synonyms);
		Reporter.log(bStatus, "synonyms is inputed in the textbox", "synonyms is not inputed in the textbox");

		bStatus = setEditValue(edit_prdCasNo, prdCasNo);
		Reporter.log(bStatus, "CasNo is inputed in the textbox", "CasNo is not inputed in the textbox");

		bStatus = setEditValue(edit_Make, Make);
		Reporter.log(bStatus, "Product Make is inputed in the textbox", "Product Make is not inputed in the textbox");

		bStatus = setEditValue(edit_packsize, packsize);
		Reporter.log(bStatus, "packsize is inputed in the textbox", "packsize is not inputed in the textbox");

		bStatus = setValueEscape(edit_prdAvalibility, prdAvalibility);
		Reporter.log(bStatus, "prdAvalibility is inputed in the textbox",
				"prdAvalibility is not inputed in the textbox");

		bStatus = setEditValue(edit_HsCode, HsCode);
		Reporter.log(bStatus, "HsCode is inputed in the textbox", "HsCode is not inputed in the textbox");

		bStatus = setValueEscape(edit_PrdPrice, PrdPrice);
		Reporter.log(bStatus, "PrdPrice is inputed in the textbox", "PrdPrice is not inputed in the textbox");

		bStatus = selectListItem(select_Assignorder, selectorder);
		Reporter.log(bStatus, "Assignorder is selected from the dropdown",
				"Assignorder is not selected from the dropdown");

		bStatus = uploadFile(edit_prdImage, file1);
		Reporter.log(bStatus, "file is selected", "file is not selected");
		wait(10);
		bStatus = uploadFile(edit_prdSDS, file2);
		Reporter.log(bStatus, "file is selected", "file is not selected");
		wait(10);
		bStatus = uploadFile(edit_prdPSS, file3);
		Reporter.log(bStatus, "file is selected", "file is not selected");
		wait(10);
		bStatus = setEditValue(edit_caolotNo, lotNo);
		Reporter.log(bStatus, "Lot No entered", "Lot No not entered");

		bStatus = uploadFile(edit_coaPDF, file4);
		Reporter.log(bStatus, "file is selected", "file is not selected");
		wait(10);

		bStatus = clickElement(btn_submit);
		Reporter.log(bStatus, "submit button is clicked", "submit button is not clicked");
		wait(10);
	}

	// ==================================================
	public  void addProducts(String NameMainCategory, String NameSubCategory, String Catno, String prdDesc,
			String prdGrade, String synonyms, String prdCasNo, String Make, String packsize, String prdAvalibility,
			String HsCode, String PrdPrice, String selectorder, String Imgfilepath, String SDSfilepath,
			String PSSfilepath) {
		boolean bStatus;

		bStatus = selectListItem(select_MainCategory, NameMainCategory);
		Reporter.log(bStatus, "MainCategory is selected from the dropdown",
				"MainCategory is not selected from the dropdown");

		bStatus = selectListItem(select_SubCategory, NameSubCategory);
		Reporter.log(bStatus, "SubCategory is selected from the dropdown",
				"SubCategory is not selected from the dropdown");

		bStatus = setEditValue(edit_CatNo, Catno);
		Reporter.log(bStatus, "Catno is inputed in the textbox", "Catno is not inputed in the textbox");

		bStatus = setEditValue(edit_prdDesc, prdDesc);
		Reporter.log(bStatus, "Product Description is inputed in the textbox",
				"Product Description is not inputed in the textbox");

		bStatus = setEditValue(edit_prdGrade, prdGrade);
		Reporter.log(bStatus, "Product grade is inputed in the textbox", "Product grade is not inputed in the textbox");

		bStatus = setEditValue(edit_synonyms, synonyms);
		Reporter.log(bStatus, "synonyms is inputed in the textbox", "synonyms is not inputed in the textbox");

		bStatus = setEditValue(edit_prdCasNo, prdCasNo);
		Reporter.log(bStatus, "CasNo is inputed in the textbox", "CasNo is not inputed in the textbox");

		bStatus = setEditValue(edit_Make, Make);
		Reporter.log(bStatus, "Product Make is inputed in the textbox", "Product Make is not inputed in the textbox");

		bStatus = setEditValue(edit_packsize, packsize);
		Reporter.log(bStatus, "packsize is inputed in the textbox", "packsize is not inputed in the textbox");

		bStatus = setEditValue(edit_prdAvalibility, prdAvalibility);
		Reporter.log(bStatus, "prdAvalibility is inputed in the textbox",
				"prdAvalibility is not inputed in the textbox");

		bStatus = setEditValue(edit_HsCode, HsCode);
		Reporter.log(bStatus, "HsCode is inputed in the textbox", "HsCode is not inputed in the textbox");

		bStatus = setEditValue(edit_PrdPrice, PrdPrice);
		Reporter.log(bStatus, "PrdPrice is inputed in the textbox", "PrdPrice is not inputed in the textbox");

		bStatus = selectListItem(select_Assignorder, selectorder);
		Reporter.log(bStatus, "Assignorder is selected from the dropdown",
				"Assignorder is not selected from the dropdown");

		bStatus = uploadFile(edit_prdImage, Imgfilepath);
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = uploadFile(edit_prdSDS, "SDSfilepath");
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = uploadFile(edit_prdPSS, "PSSfilepath");
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = clickElement(btn_submit);
		Reporter.log(bStatus, "submit button is clicked", "submit button is clicked");
	}

	// ==========================add Products without Maindarory===========================================

	public  void addProductswithoutMaindarory(String prdGrade, String synonyms, String prdCasNo, String packsize,
			String prdAvalibility, String HsCode, String selectorder, String Imgfilepath, String SDSfilepath,
			String PSSfilepath) {
		boolean bStatus;

		bStatus = setEditValue(edit_prdGrade, prdGrade);
		Reporter.log(bStatus, "Product grade is inputed in the textbox", "Product grade is not inputed in the textbox");

		bStatus = setEditValue(edit_synonyms, synonyms);
		Reporter.log(bStatus, "synonyms is inputed in the textbox", "synonyms is not inputed in the textbox");

		bStatus = setEditValue(edit_prdCasNo, prdCasNo);
		Reporter.log(bStatus, "CasNo is inputed in the textbox", "CasNo is not inputed in the textbox");

		bStatus = setEditValue(edit_packsize, packsize);
		Reporter.log(bStatus, "packsize is inputed in the textbox", "packsize is not inputed in the textbox");

		bStatus = setEditValue(edit_prdAvalibility, prdAvalibility);
		Reporter.log(bStatus, "prdAvalibility is inputed in the textbox",
				"prdAvalibility is not inputed in the textbox");

		bStatus = setEditValue(edit_HsCode, HsCode);
		Reporter.log(bStatus, "HsCode is inputed in the textbox", "HsCode is not inputed in the textbox");

		bStatus = selectListItem(select_Assignorder, selectorder);
		Reporter.log(bStatus, "Assignorder is selected from the dropdown",
				"Assignorder is not selected from the dropdown");

		bStatus = uploadFile(edit_prdImage, Imgfilepath);
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = uploadFile(edit_prdSDS, "SDSfilepath");
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = uploadFile(edit_prdPSS, "PSSfilepath");
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = clickElement(btn_submit);
		Reporter.log(bStatus, "submit button is clicked", "submit button is clicked");
	}

	// =============================add Product without SubCategory==================================================

	public  void addProductwithoutSubCategory(String NameMainCategory, String Catno, String prdDesc,
			String prdGrade, String synonyms, String prdCasNo, String Make, String packsize, String prdAvalibility,
			String HsCode, String PrdPrice, String selectorder, String Imgfilepath, String SDSfilepath,
			String PSSfilepath) {
		boolean bStatus;

		bStatus = selectListItem(select_MainCategory, NameMainCategory);
		Reporter.log(bStatus, "MainCategory is selected from the dropdown",
				"MainCategory is not selected from the dropdown");

		bStatus = setEditValue(edit_CatNo, Catno);
		Reporter.log(bStatus, "Catno is inputed in the textbox", "Catno is not inputed in the textbox");

		bStatus = setEditValue(edit_prdDesc, prdDesc);
		Reporter.log(bStatus, "Product Description is inputed in the textbox",
				"Product Description is not inputed in the textbox");

		bStatus = setEditValue(edit_prdGrade, prdGrade);
		Reporter.log(bStatus, "Product grade is inputed in the textbox", "Product grade is not inputed in the textbox");

		bStatus = setEditValue(edit_synonyms, synonyms);
		Reporter.log(bStatus, "synonyms is inputed in the textbox", "synonyms is not inputed in the textbox");

		bStatus = setEditValue(edit_prdCasNo, prdCasNo);
		Reporter.log(bStatus, "CasNo is inputed in the textbox", "CasNo is not inputed in the textbox");

		bStatus = setEditValue(edit_Make, Make);
		Reporter.log(bStatus, "Product Make is inputed in the textbox", "Product Make is not inputed in the textbox");

		bStatus = setEditValue(edit_packsize, packsize);
		Reporter.log(bStatus, "packsize is inputed in the textbox", "packsize is not inputed in the textbox");

		bStatus = setEditValue(edit_prdAvalibility, prdAvalibility);
		Reporter.log(bStatus, "prdAvalibility is inputed in the textbox",
				"prdAvalibility is not inputed in the textbox");

		bStatus = setEditValue(edit_HsCode, HsCode);
		Reporter.log(bStatus, "HsCode is inputed in the textbox", "HsCode is not inputed in the textbox");

		bStatus = setEditValue(edit_PrdPrice, PrdPrice);
		Reporter.log(bStatus, "PrdPrice is inputed in the textbox", "PrdPrice is not inputed in the textbox");

		bStatus = selectListItem(select_Assignorder, selectorder);
		Reporter.log(bStatus, "Assignorder is selected from the dropdown",
				"Assignorder is not selected from the dropdown");

		bStatus = uploadFile(edit_prdImage, Imgfilepath);
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = uploadFile(edit_prdSDS, "SDSfilepath");
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = uploadFile(edit_prdPSS, "PSSfilepath");
		Reporter.log(bStatus, "file is selected", "file is not selected");

		bStatus = clickElement(btn_submit);
		Reporter.log(bStatus, "submit button is clicked", "submit button is clicked");
	}

}
