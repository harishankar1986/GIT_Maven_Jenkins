package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class EditProducts extends WebLibrary{
	
	//=========WebElements for AddProducts page================
	
		@FindBy(xpath="//span[text()='Products']")
		public static WebElement navlink_Products;
		
		@FindBy(xpath="//a[text()='Products']")
		public static WebElement link_Products;
		
		@FindBy(xpath="//table[@id = 'dataTable']/tbody/tr[7]/td[6]")
		public static WebElement click_editicon;
		
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
		
		@FindBy(xpath="//a[text()='Next']")
		public static WebElement btn_next;
		
		@FindBy(xpath="//i[@class='fas fa-pencil-alt']")
		public static WebElement edit_button;
		
		

	//=========Methods for AddProducts page================

		public static boolean selectEditicon(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int trcount=rows.size();
			System.out.println(trcount);
			
			for(int i=1; i<=trcount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[6]")).getText();
			System.out.println(actValue);
			if ((actValue.equals(expValue)))  {
				driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[15]/a[1]/i")).click();
				break;
			}
				else {
					
				}
				}
			}
			
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		}
			
	//=========================================================
		public static void editProduct( String prdDesc,String prdGrade,String Make,String packsize,String prdAvalibility,
						String PrdPrice,String SDSfilepath) 
		{
			boolean bStatus;
			
			/*bStatus = selectListItem(select_MainCategory, NameMainCategory);
			Reporter.log(bStatus, "MainCategory is selected from the dropdown", "MainCategory is not selected from the dropdown");
		
			bStatus = selectListItem(select_SubCategory, NameSubCategory);
			Reporter.log(bStatus, "SubCategory is selected from the dropdown", "SubCategory is not selected from the dropdown");
			
			bStatus = setEditValue(edit_CatNo, Catno);
			Reporter.log(bStatus, "Catno is inputed in the textbox", "Catno is not inputed in the textbox");*/
			
			bStatus = setEditValue(edit_prdDesc, prdDesc);
			Reporter.log(bStatus, "Product Description is inputed in the textbox", "Product Description is not inputed in the textbox");
			
			bStatus = setEditValue(edit_prdGrade, prdGrade);
			Reporter.log(bStatus, "Product grade is inputed in the textbox", "Product grade is not inputed in the textbox");
			
			bStatus = setEditValue(edit_Make, Make);
			Reporter.log(bStatus, "Product Make is inputed in the textbox", "Product Make is not inputed in the textbox");
			
			bStatus = setValueEscape(edit_packsize, packsize);
			Reporter.log(bStatus, "packsize is inputed in the textbox", "packsize is not inputed in the textbox");
			
			bStatus = setValueEscape(edit_prdAvalibility, prdAvalibility);
			Reporter.log(bStatus, "prdAvalibility is inputed in the textbox", "prdAvalibility is not inputed in the textbox");
			
			bStatus = setValueEscape(edit_PrdPrice, PrdPrice);
			Reporter.log(bStatus, "PrdPrice is inputed in the textbox", "PrdPrice is not inputed in the textbox");
			
			bStatus = uploadFile(edit_prdSDS, SDSfilepath);
			Reporter.log(bStatus, "file is selected", "file is not selected");
			
			bStatus =clickElement(btn_submit);
			Reporter.log(bStatus, "submit button is clicked", "submit button is clicked");
		}
		
	//=============================EditProduct================================

		public  void EditProduct()
		{
			boolean bStatus;
			
			bStatus = clickElement(edit_button);
			Reporter.log(bStatus, "Edit Button clicked", "Edit Botton not clicked");
			
			
		}

}
