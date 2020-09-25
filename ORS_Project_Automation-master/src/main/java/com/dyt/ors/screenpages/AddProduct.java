package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;



public class AddProduct extends WebLibrary{
	
    //=========WebElements for AddProducts page================
	
	@FindBy(xpath="//span[text()='Products']")
	public static WebElement navlink_Products;
	
	@FindBy(xpath="//a[text()='Products']")
	public static WebElement link_Products;
	
	@FindBy(xpath="//a[text()=' Add Products']")
	public static WebElement btn_AddProducts;
	
	@FindBy(xpath="//select[@id='ors_mc_id']")
	public static WebElement select_MainCategory;
	
	@FindBy(xpath="//select[@id='subCatg']")
	public static WebElement select_SubCategory;
	
	@FindBy(xpath="//input[@id='catNo']")
	public static WebElement edit_CatNo;
	
	@FindBy(xpath="//input[@id='prdDesc']")
	public static WebElement edit_prdDesc;
	
	@FindBy(xpath="//input[@id='prdGrade']")
	public static WebElement edit_prdGrade;
	
	@FindBy(xpath="//input[@id='prdSynon']")
	public static WebElement edit_synonyms;
	
	@FindBy(xpath="//input[@id='prdCasNo']")
	public static WebElement edit_prdCasNo;
	
	@FindBy(xpath="//input[@id='prdMake']")
	public static WebElement edit_Make;
	
	@FindBy(xpath="//input[@name='ors_prds_pack_size']")
	public static WebElement edit_packsize;
	
	@FindBy(xpath="//input[@name='ors_prds_avalibility']")
	public static WebElement edit_prdAvalibility;
	
	@FindBy(xpath="//input[@name='ors_prds_HS_code']")
	public static WebElement edit_HsCode;
	
	@FindBy(xpath="//input[@name='ors_prds_price']")
	public static WebElement edit_PrdPrice;
	
	@FindBy(xpath="//select[@id='ors_prds_orderBy']")
	public static WebElement select_Assignorder;
	
	@FindBy(xpath="//input[@id='prdImage']")
	public static WebElement edit_prdImage;
	
	@FindBy(xpath="//input[@id='prdSDS']")
	public static WebElement edit_prdSDS;
	
	@FindBy(xpath="//input[@id='prdPSS']")
	public static WebElement edit_prdPSS;
	
	@FindBy(xpath="//input[@id='ors_cao_lotNo']")
	public static WebElement edit_caolotNo;
	
	@FindBy(xpath="//input[@id='coaPDF']")
	public static WebElement edit_coaPDF;
	
	@FindBy(xpath="//input[@class='btn btn-success']")
	public static WebElement btn_submit;
	
	
	//=========================================================
	public static void AddProducts(String NameMainCategory, String NameSubCategory,String Catno, String prdDesc,
									String prdGrade,String synonyms,String prdCasNo,
									String Make,String packsize,String prdAvalibility,
									String HsCode, String PrdPrice,String selectorder) 
	{
		boolean bStatus;
		
		bStatus = clickElement(btn_AddProducts);
		Reporter.log(bStatus, "AddProducts button clicked", "AddProducts button not clicked");
		
		bStatus = selectListItem(select_MainCategory, NameMainCategory);
		Reporter.log(bStatus, "MainCategory is selected from the dropdown", "MainCategory is not selected from the dropdown");
	
		bStatus = selectListItem(select_SubCategory, NameSubCategory);
		Reporter.log(bStatus, "SubCategory is selected from the dropdown", "SubCategory is not selected from the dropdown");
		
		bStatus = setEditValue(edit_CatNo, Catno);
		Reporter.log(bStatus, "Catno is inputed in the textbox", "Catno is not inputed in the textbox");
		
		bStatus = setEditValue(edit_prdDesc, prdDesc);
		Reporter.log(bStatus, "Product Description is inputed in the textbox", "Product Description is not inputed in the textbox");
		
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
		Reporter.log(bStatus, "prdAvalibility is inputed in the textbox", "prdAvalibility is not inputed in the textbox");
		
		bStatus = setEditValue(edit_HsCode, HsCode);
		Reporter.log(bStatus, "HsCode is inputed in the textbox", "HsCode is not inputed in the textbox");
		
		bStatus = setValueEscape(edit_PrdPrice, PrdPrice);
		Reporter.log(bStatus, "PrdPrice is inputed in the textbox", "PrdPrice is not inputed in the textbox");
		
		bStatus = selectListItem(select_Assignorder, selectorder);
		Reporter.log(bStatus, "Assignorder is selected from the dropdown", "Assignorder is not selected from the dropdown");
		
		bStatus = uploadFile(edit_prdImage,  "C:\\Users\\lenavo\\Documents\\ORS_files_images\\image1.jpg");
		Reporter.log(bStatus, "file is selected", "file is not selected");
		
		bStatus = uploadFile(edit_prdSDS,  "C:\\Users\\lenavo\\Documents\\ORS_files_images\\samplePFD.pdf");
		Reporter.log(bStatus, "file is selected", "file is not selected");
		
		bStatus = uploadFile(edit_prdPSS,  "C:\\Users\\lenavo\\Documents\\ORS_files_images\\file-sample_150kB_PDF.pdf");
		Reporter.log(bStatus, "file is selected", "file is not selected");
		
		bStatus =clickElement(btn_submit);
		Reporter.log(bStatus, "submit button is clicked", "submit button is clicked");
	}
	
}

