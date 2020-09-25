package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class addproduct_Anwesha extends WebLibrary{
	
		// =========WebElements for Add Product Categories Page ==================

		@FindBy(xpath = "//select[@id = 'ors_mc_id']")
		public static WebElement select_MainCatergories;
		
		@FindBy(xpath = "//select[@id = 'subCatg']")
		public static WebElement select_SubCategories;
		
		@FindBy(xpath = "//input[@id = 'catNo']")
		public static WebElement edit_CatNo;
		
		@FindBy(xpath = "//input[@id = 'prdDesc']")
		public static WebElement edit_ProductDescription;
		
		@FindBy(xpath = "//input[@id = 'prdGrade']")
		public static WebElement edit_ProductGrade;
		
		@FindBy(xpath = "//input[@id = 'prdSynon']")
		public static WebElement edit_Synonyms;
		
		@FindBy(xpath = "//input[@id = 'prdCasNo']")
		public static WebElement edit_CasNo;
		
		@FindBy(xpath = "//input[@id = 'prdMake']")
		public static WebElement edit_Make;
		
		@FindBy(xpath = "//input[@name = 'ors_prds_pack_size']")
		public static WebElement edit_PackSize;
		
		
		@FindBy(xpath = "//input[@id = 'ors_prds_avalibility']")
		public static WebElement edit_Available;
		
		@FindBy(xpath = "//input[@name = 'ors_prds_HS_code']")
		public static WebElement edit_HSCode;
		
		@FindBy(xpath = "//input[@id = 'prdPrize']")
		public static WebElement edit_ProductPrice;
		
		@FindBy(xpath = "//select[@id = 'ors_prds_orderBy']")
		public static WebElement select_Assignedorder;
		
		@FindBy(xpath = "//input[@id = 'prdImage']")
		public static WebElement btn_ProductImageChooseFile;
		
		@FindBy(xpath = "//input[@id = 'prdSDS']")
		public static WebElement btn_SDSChooseFile;
		
		@FindBy(xpath = "//input[@id = 'prdPSS']")
		public static WebElement btn_SpecificationSheetChooseFile;
		
		@FindBy(xpath = "//input[@id = 'ors_cao_lotNo']")
		public static WebElement edit_LotNo;
		
		@FindBy(xpath = "//input[@id = 'coaPDF']")
		public static WebElement btn_AttachDocumentChooseFile;
		
		@FindBy(xpath = "//*[@id='servDetails']/tbody/tr/td[4]/i")
		public static WebElement clk_PlusSign;
		
		@FindBy(xpath = "//*[@id='servDetails']/tbody/tr/td[5]/i")
		public static WebElement clk_MinusSign;
		
		@FindBy(xpath = "//input[@value='Submit']")
		public static WebElement btn_Submit;
		
		

		// =================methods for Add Product Categories Page =========================
		
		
		public static void addProduct(String mainCat, String subcat, String catNo, String description,String make, String price,String size,String grade, String casNo,String hsCode,String order,String pathFile, String lotNo) {
			
			boolean bStatus;		
			bStatus = selectListItem(select_MainCatergories, mainCat);
			Reporter.log(bStatus, "Main Catergories selected", "Main Catergories not selected");
			
			bStatus = selectListItem(select_SubCategories, subcat);
			Reporter.log(bStatus, "Sub Catergories selected", "Sub Catergories not selected");
			
			bStatus = setEditValue(edit_CatNo, catNo);
			Reporter.log(bStatus, "Cat no entered", "Cat No not entered");
			
			bStatus = setEditValue(edit_ProductDescription, description);
			Reporter.log(bStatus, "Product Description entered", "Product Description not entered");
			
			bStatus = setEditValue(edit_Make, make);
			Reporter.log(bStatus, "Make entered", "Make not entered");
			
			bStatus = setValueEscape(edit_ProductPrice, price);
			Reporter.log(bStatus, "Product Price entered", "Product Price not entered");
			
			bStatus = setEditValue(edit_PackSize, size);
			Reporter.log(bStatus, "Pack Size entered", "Pack Size not entered");
			
			bStatus = setEditValue(edit_ProductGrade, grade);
			Reporter.log(bStatus, "Product Grade entered", "Product Grade not entered");
			
			bStatus = setEditValue(edit_CasNo, casNo);
			Reporter.log(bStatus, "Cas No entered", "Cas No not entered");
			
			bStatus = setEditValue(edit_HSCode, hsCode);
			Reporter.log(bStatus, "HS Code entered", "HS Code not entered");
			
			bStatus = selectListItem(select_Assignedorder, order);
			Reporter.log(bStatus, "Assigned order selected", "Assigned order not selected");
			
			bStatus = uploadFile(btn_ProductImageChooseFile, pathFile);
			Reporter.log(bStatus, "Submit button clicked", "Submit button not clicked");
			
			bStatus = setEditValue(edit_LotNo, lotNo);
			Reporter.log(bStatus, "Lot No entered", "Lot No not entered");

			bStatus = clickElement(btn_Submit);
			Reporter.log(bStatus, "Submit button clicked", "Submit button not clicked");
			
		}



}
