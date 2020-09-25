package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class Home extends WebLibrary{
	
	@FindBy(xpath="//a[text()='Login']")
	public static WebElement link_Login;
	
	@FindBy(xpath="//a[text()='Register']")
	public static WebElement link_Register;
	
	@FindBy(xpath="//div[@id='navbarTogglerDemo02']/ul/li[2]/a")
	public static WebElement tab_AboutOrbit;
	
	@FindBy(xpath="//div[@id='navbarTogglerDemo02']/ul/li[3]/a")
	public static WebElement tab_Product;
	
	@FindBy(xpath="//div[@id='navbarTogglerDemo02']/ul/li[4]/a")
	public static WebElement tab_COA;
	
	@FindBy(xpath="//div[@id='navbarTogglerDemo02']/ul/li[5]/a")
	public static WebElement tab_Literatures;
	
	@FindBy(xpath="//div[@id='navbarTogglerDemo02']/ul/li[6]/a")
	public static WebElement tab_Contactus;


	@FindBy(xpath="//input[@id='searchRecord']")
	public static WebElement edit_Name;	
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	public static WebElement icon_Search;	
	
	
	
	@FindBy(xpath="//span[text()='No Results Found']")
	public static WebElement text_NoResultFound;
	
	@FindBy(xpath="//h5[@class='itemdesc']")
	public static WebElement links_Products;	
	
	
	
	@FindBy(xpath="//input[@name='searchRecord']")
	public static WebElement searchRecord;
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	public static WebElement searchButton;
	
	//===========================================
	//====================Navigate to login page==================
	public static void navLoginpage() {		
		boolean bStatus = clickElement(link_Login);
		Reporter.log(bStatus, "Login link clicked", "Login link not clicked");
	}	
	//=====================To verify Login link===============================
	
			public  void verifyLoginlink() {		
				boolean bStatus = verifyText(link_Login);
				Reporter.log(bStatus, "Login link is available", "Login link is not available");
			}	
	//=====================To verify Register link===============================
			public  void verifyRegisterlink() {		
				boolean bStatus = verifyText(link_Register);
				Reporter.log(bStatus, "Register link is available", "Register link is not available");
			}	
	//======================Navigate to Register page==============================
			public  void navRegisterpage() {		
				boolean bStatus = clickElement(link_Register);
				Reporter.log(bStatus, "Register link clicked", "Register link not clicked");
			}	
	//======================To verify Search Bar==============================
				public  void verifySearchBar() {		
					boolean bStatus = verifyText(edit_Name);
					Reporter.log(bStatus, "Search field is available", "Search field is not available");
				}	
			

	//====================Navigate to AboutOrbit tab ========================================	
				public  void navAboutOrbit()
				{
					boolean bstatus;
					
					bstatus = verifyText(tab_AboutOrbit);
					Reporter.log(bstatus, "AboutOrbit tab is available","AboutOrbit tab Not available");
					
					bstatus = clickElement(tab_AboutOrbit);
					Reporter.log(bstatus, "AboutOrbit tab is Clicked","AboutOrbit tab Not Clicked");
				}
	   //=====================Navigate to Product tab=========================
				public  void navProduct()
				{
					boolean bstatus;
					
					bstatus = verifyText(tab_Product);
					Reporter.log(bstatus, "Product tab is available","Product tab is Not available");
					
					bstatus = clickElement(tab_Product);
					Reporter.log(bstatus, "Product tab is Clicked","Product tab is Not Clicked");
				}
	//========================Navigate to COA tab======================
				public  void navCOA()
				{
					boolean bstatus;
					
					bstatus = verifyText(tab_COA);
					Reporter.log(bstatus, "COA tab is available","COA tab is Not available");
					
					bstatus = clickElement(tab_COA);
					Reporter.log(bstatus, "COA tab is Clicked","COA tab is Not Clicked");
				}
	//=========================Navigate to Literatures tab=====================
				public  void navLiteratures()
				{
					boolean bstatus;
					
					bstatus = verifyText(tab_Literatures);
					Reporter.log(bstatus, "Literatures tab is available","Literatures tab is Not available");
					
					bstatus = clickElement(tab_Literatures);
					Reporter.log(bstatus, "Literatures tab is Clicked","Literatures tab is Not Clicked");
				}
	//========================Navigate to Contact us======================
				public  void navContactus()
				{
					boolean bstatus;
					
					bstatus = verifyText(tab_Contactus);
					Reporter.log(bstatus, "Contactus tab is available","Contactus tab is Not available");
					
					bstatus = clickElement(tab_Contactus);
					Reporter.log(bstatus, "Contactus tab is Clicked","Contactus tab is Not Clicked");
				}
	//===========search with productname and verify the details of the Product==================
				
				
				public  void searchproduct(String Productname)
				{
					boolean bstatus;
					
					bstatus = setEditValue(edit_Name, Productname);
					Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
					
					bstatus = clickElement(icon_Search);
					Reporter.log(bstatus, "Search Icon Clicked","Search Icon Not Clicked");
					
					bstatus = clickElement(links_Products);
					Reporter.log(bstatus, "Particular Product Clicked", "Particular Product Not Clicked");
					
					boolean bStatus = verifyText(edit_Name);
					Reporter.log(bStatus, "Search field is available", "Search field is not available");
					
				}
	
	//===========================================
	/*
	Name            :   SearchProduct
	Description		: 	This method is used to search a product based on product name or cas no
	Author			: 	Anwesha
	Date			: 	12th July 2020
	Parameters		: 	productname -> entered data into search field
	Modified Date	:	
	Modified By		:
	*/
	
	public  void SearchProduct(String productname)
	{
		boolean bstatus;
		
		bstatus = setEditValue(searchRecord, productname);
		Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
		
		bstatus = clickElement(searchButton);
		Reporter.log(bstatus, "Search button Clicked","Search button Not Clicked");
	}
}