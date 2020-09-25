package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class SearchFunctionality extends WebLibrary{
	
	@FindBy(xpath="//input[@id='searchRecord']")
	public static WebElement edit_Name;	
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	public static WebElement icon_Search;	
	
	@FindBy(xpath="//span[text()='No Results Found']")
	public static WebElement text_NoResultFound;
	
	@FindBy(xpath="//h5[@class='itemdesc']")
	public static WebElement links_Products;
	
	@FindBy(xpath="//div[text()='No Records Found']")
	public static WebElement COAtext_NoRecordsFound;
	
	@FindBy(xpath="//input[@id='lotNo']")
	public static WebElement edit_Lotno;
	
	@FindBy(xpath="//i[@class='fas fa-search']")
	public static WebElement icon_COASearch;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/span/a")
	public static WebElement download_SDS;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[2]/span/a")
	public static WebElement download_SpecificationSheet;
	
	@FindBy(xpath="//div[@id='rld_Main_Sub']/div/ul/li[2]")
	public static WebElement links_RelatedProducts;
	
	@FindBy(xpath="//div[@id='rld_Main_Sub']/div[2]/ul/li[1]")
	public static WebElement links_RelatedCategories;
	
	@FindBy(xpath="//h4[text()='Related Products']")
	public static WebElement text_RelatedProducts;
	
	@FindBy(xpath="//h4[text()='Related Categories']")
	public static WebElement text_RelatedCategories;
	
	@FindBy(xpath="//span[text()='CAS Number: ']")
	public static WebElement text_CSANO;
	
	@FindBy(xpath="//td[text()='Product Name']")
	public static WebElement text_Productname;
	
	@FindBy(xpath="//td[text()='Grade']")
	public static WebElement text_Grade;
	
	@FindBy(xpath="//th[text()='Packing unit']")
	public static WebElement text_Packunit;
	

	

//=================Search the product with out input the data=========================

	public  void searchProductNotInputingTheData(String Productname)
	{
		boolean bstatus;
		
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Not Entered","Product Name Entered");
		
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		bstatus = verifyText(links_Products);
		Reporter.log(bstatus, "All products list displayed succesfully","All products list not displayed");
		
		
	}

//=================Search the product with invalid data =========================

	public  void searchProductInvalidData(String Productname)
	{
		boolean bstatus;
		
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
		
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		bstatus = verifyText(text_NoResultFound);
		Reporter.log(bstatus, "No result found is displayed", "No result found is not displayed");
		
	}

//===========search with productname and verify the details of the Product==================
	public  void searchWithProductName(String Productname)
	{
		boolean bstatus;
		
		bstatus = verifyText(edit_Name);
		Reporter.log(bstatus, "Search field is available", "Search field is not available");
		
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
		
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		bstatus = verifyText(text_Grade);
		Reporter.log(bstatus, "Product page is opened", "Product page is not opened");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_Packunit);
		Reporter.log(bstatus, "Product page is opened with product full details", "Product page is not opened with product full details");
		
		
		
	}

//===========search with CatNo and verify the details of the Product==================
	public  void searchWithCatNo(String CatNo)
	{
		boolean bstatus;
		
		bstatus = setEditValue(edit_Name, CatNo);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
		
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_Grade);
		Reporter.log(bstatus, "Product page is opened", "Product page is not opened");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_Packunit);
		Reporter.log(bstatus, "Product page is opened with product full details", "Product page is not opened with product full details");
		
	}
	
//===========search with CatNo and verify the details of the Product==================
	public  void searchWithCasNo(String CasNo)
	{
		boolean bstatus;
				
		bstatus = setEditValue(edit_Name, CasNo);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
				
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
				
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
				
		bstatus = verifyText(text_Grade);
		Reporter.log(bstatus, "Product page is opened", "Product page is not opened");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_Packunit);
		Reporter.log(bstatus, "Product page is opened with product full details", "Product page is not opened with product full details");
				
	}
		
//===========search with CatNo and verify the details of the Product==================
	public  void searchWithSynonym(String Synonym)
	{
		boolean bstatus;
				
		bstatus = setEditValue(edit_Name, Synonym);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
				
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		bstatus = verifyText(text_NoResultFound);
		Reporter.log(bstatus, "No results found message displayed", "No results found message not displayed");
				
		/*bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
				
		bstatus = verifyText(text_Grade);
		Reporter.log(bstatus, "Product page is opened", "Product page is not opened");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_Packunit);
		Reporter.log(bstatus, "Product page is opened with product full details", "Product page is not opened with product full details");*/
				
	}
//=========================Verify with invalid lotNo in COA Certificate=================
	public  void searchWithInvalidLotNo(String Productname, String LotNo) throws InterruptedException
	{
		boolean bstatus;
		
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
		
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
				
		bstatus = setEditValue(edit_Lotno, LotNo);
		Reporter.log(bstatus, "LotNo Entered","LotNo Not Entered");
				
		bstatus = clickElement(icon_COASearch);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
		
		Thread.sleep(2);
				
		bstatus = verifyText(COAtext_NoRecordsFound);
		Reporter.log(bstatus, "No such records found, message is displayed", "COA Document is avaialble");
				
	}
//==========================Verify related documents available and able to download=================
	public  void verifyrelateddocumnets(String Productname, String LotNo )
	{
		boolean bstatus;
				
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
				
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
				
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
				
		bstatus = verifyText(download_SDS);
		Reporter.log(bstatus, "SDS Document is avaialble", "SDS Document is not avaialble");
		
		bstatus = verifyText(download_SpecificationSheet);
		Reporter.log(bstatus, "SDS Document is avaialble", "SDS Document is not avaialble");
		
		bstatus = clickElement(download_SDS);
		Reporter.log(bstatus, "SDS Download link Clicked", "SDS Download link Not Clicked");
		
		bstatus = clickElement(download_SpecificationSheet);
		Reporter.log(bstatus, "Specification sheet Download link Clicked", "Specification sheet Download link Not Clicked");
		
	    bstatus = setEditValue(edit_Lotno, LotNo );
		Reporter.log(bstatus, "LotNo Entered","LotNo Not Entered");
				
		bstatus = clickElement(icon_COASearch);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");		
	}
//===============================Verify related products=============================
	public  void verifyrelatedProducts(String Productname)
	{
		boolean bstatus; 
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
				
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
				
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_RelatedProducts);
		Reporter.log(bstatus, "Related Products text is avaialble", "Related Products text not is avaialble");
		
		bstatus = mouseHover(links_RelatedProducts);
		Reporter.log(bstatus, "Mouse hover action performed to link", "Mouse hover action not performed to the link");
		
		bstatus = clickElement(links_RelatedProducts);
		Reporter.log(bstatus, "Related Products links is clicked", "Related Products link not clicked");
		
		bstatus = verifyText(text_CSANO);
		Reporter.log(bstatus, "Products page is opened with product details", "Products page is not opened with product details");
	}
//===============================Verify related categories=============================
	public  void verifyrelatedCategories(String Productname)
	{
		boolean bstatus; 
		bstatus = setEditValue(edit_Name, Productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
				
		bstatus = clickElement(icon_Search);
		Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
				
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
		
		bstatus = verifyText(text_RelatedCategories);
		Reporter.log(bstatus, "Related Categories text is avaialble", "Related Categories text not is avaialble");
		
		bstatus = mouseHover(links_RelatedCategories);
		Reporter.log(bstatus, "Mouse hover action performed to link", "Mouse hover action not performed to the link");
		
		bstatus = clickElement(links_RelatedCategories);
		Reporter.log(bstatus, "Related Categories links is clicked", "Related Categories link not clicked");
		
		bstatus = verifyText(text_Productname);
		Reporter.log(bstatus, "Products page is opened", "Products page is not opened");
		
		bstatus = clickElement(links_Products);
		Reporter.log(bstatus, "Products name is clicked", "Products name is not clicked");
		
		bstatus = verifyText(text_CSANO);
		Reporter.log(bstatus, "Products page is opened with product details", "Products page is not opened with product details");

		
	}


}
