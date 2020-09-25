package com.dyt.ors.smoke;

	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

	import com.dyt.generic.BaseClass;
	import com.dyt.ors.screenpages.AddMainCategory;
	import com.dyt.ors.screenpages.AddProduct;
	import com.dyt.ors.screenpages.Dashboard;
	import com.dyt.ors.screenpages.DisplayProductsList;
	import com.dyt.ors.screenpages.EditMainCategory;
	import com.dyt.ors.screenpages.EditProduct;
	import com.dyt.ors.screenpages.Home;
	import com.dyt.ors.screenpages.Login;
	import com.dyt.ors.screenpages.addproduct_Anwesha;
	import com.dyt.utilities.ExcelLib;

	public class SmokeTC extends BaseClass{
		
		@Test
		public static void TC001_addMainCategory()
		{		
			String[] data = ExcelLib.getRowData("TC001_addMainCategory", "Sheet1");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
			//Step 1: Login as an admin
			Home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashboard.navMainCategories();
			addMainCategory.AddMainCategory(data[2], data[3]);
			
			
			//Step 2: Navigate to Main Category page		
			
			
			// Step n : Logout		
		}

		
		/*@Test
		public static void TC001_addMainCategory()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
			
			home.navLoginpage();
			login.loginApp("admin","admin@123");
			addMainCategory.navAddmainCategory();
			addMainCategory.AddMainCategory("1,4-Naphthoquinone", "B");
		}*/
		
		/*@Test
		public static void TC003_addProducts()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddProduct addproduts= PageFactory.initElements(driver, AddProduct.class);
			
			home.navLoginpage();;
			login.loginApp("admin","admin@123");
			addproduts.navAddProducts();
			addproduts.AddProducts("Acetonic", "samplesub", "111", "Hexafluoro", "A+", "propanol", "345", "reddyslabs", "30", "10", "Code150", "6000", "B");					
		} */
		
		/*@Test
		public static void TC004_editProduct()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			EditProduct editProduct= PageFactory.initElements(driver, EditProduct.class);
			
			home.navLoginpage();;
			login.loginApp("admin","admin@123");
			//editProduct.navProductsPage();
			editProduct.selectEditicon("wwwww");
			editProduct.editProduct("cat123", "123D", "B+", "produ", "123", "123S", "asd");					
		} */
		
		/*@Test
		public static void TC002_editMainCategory()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashBoard = PageFactory.initElements(driver, Dashboard.class);
			EditMainCategory editMainCategory= PageFactory.initElements(driver, EditMainCategory.class);
			
			home.navLoginpage();;
			login.loginApp("admin","admin@123");
			dashBoard.navMainCategories();
			editMainCategory.selectEditicon("Acetone");
			editMainCategory.editMainCategoryPage("Acetonic", "C");
	}*/
		
		/*@Test
		public static void TC003_addProduct()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			DisplayProductsList displayproductlist = PageFactory.initElements(driver, DisplayProductsList.class);
			addproduct_Anwesha addproductcategories = PageFactory.initElements(driver, addproduct_Anwesha.class);
			
			
			//Step 1: Login as an admin
			Home.navLoginpage();
			login.loginApp("admin","admin@123");
			
			//Step 2: Navigate to Product page
			dashboard.navProducts();
			
			//Step 3:Navigate to Add Products page
			DisplayProductsList.navAddProductspage();
			
			//Step 4:Enter all the details and Click on Submit button 
			addproductcategories.addProduct("Tylenol", "Advil", "12ab", "PARACETAMOL", "61c", "6000", "7", "B", "56ef", "HS0123", "M", "C:\\Users\\lenavo\\Documents\\ORS_files_images\\image1.jpg", "LOT0011");
			
			
			//Step 5: Newly added product displayed in product list table
			DisplayProductsList.verifyNewAddedProduct("12ab");
			
			// Step n : Logout	
			//DisplayProductsList.logOut();
		}*/
		
	
}
