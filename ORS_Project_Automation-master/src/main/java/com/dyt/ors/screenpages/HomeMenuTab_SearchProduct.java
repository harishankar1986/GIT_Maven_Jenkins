package com.dyt.ors.screenpages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.dyt.generic.WebLibrary;
	import com.dyt.reports.Reporter;

	public class HomeMenuTab_SearchProduct extends WebLibrary{	
		//===============WebElements for Home Page Menutabs and search products====================
		
		@FindBy(xpath="//a[@class='nav-link'][@href='/ORS_SIT/']") 
		public static WebElement Link_Home;
		
		@FindBy(xpath="//a[@class='nav-link'][@href='/ORS_SIT/aboutUs']") 
		public static WebElement Link_AboutOrbit;
		
		
		@FindBy(xpath="//a[text() = 'Products']")   
		public static WebElement Link_Products;
		
		@FindBy(xpath="//a[text() = 'COA'") 
		public static WebElement Link_COA;
		
		@FindBy(xpath="//a[text() = 'Literatures']")   
		public static WebElement Link_Literatures;
		
		@FindBy(xpath="//a[@class='nav-link'][text() = 'Contact Us']")   
		public static WebElement Link_ContactUs;
		
		@FindBy(xpath="//input[@name='searchRecord']")
		public static WebElement searchRecord;
		
		@FindBy(xpath="//button[@class='btn btn-secondary']")
		public static WebElement searchButton;
		
		@FindBy(xpath="//a[text()='Acetaminopen']")
		public static WebElement Productlink;	
		
		
	//=================Method for Home Page Menu Tabs==============================

		public static void HomeMenuTabs(){ 
			boolean bStatus;
			bStatus = clickElement(Link_AboutOrbit);
			Reporter.log(bStatus,"AboutOrbit tab clicked", "AboutOrbit tab not clicked");

			bStatus = clickElement(Link_Products);
			Reporter.log(bStatus,"Products tab clicked", "Products tab not clicked");
			
			bStatus = clickElement(Link_COA);
			Reporter.log(bStatus,"COA tab clicked", "COA tab not clicked");
			

			bStatus = clickElement(Link_Literatures);
			Reporter.log(bStatus,"Literatures tab clicked", "Literatures tab not clicked");
			
			bStatus = clickElement(Link_ContactUs);
			Reporter.log(bStatus,"ContactUs tab clicked", "ContactUs tab not clicked");
			
			bStatus = clickElement(Link_Home);
			Reporter.log(bStatus,"Home tab clicked", "Home tab not clicked");
		}	
			
	//==============Method for Search Product in Homepage==============================	
		public static void SearchProduct(String productname)
		{
			boolean bstatus;
			
			bstatus = setEditValue(searchRecord, productname);
			Reporter.log(bstatus, "Product Name Entered","Product Name Not Entered");
			
			bstatus = clickElement(searchButton);
			Reporter.log(bstatus, "Search button Clicked","Search button Not Clicked");
			
			bstatus = clickElement(Productlink);
			Reporter.log(bstatus, "Product link Clicked", "Product link Not Clicked");
					
		}
		
	}


