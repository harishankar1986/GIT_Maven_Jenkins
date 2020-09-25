package com.dyt.ors.smoke;

	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

	import com.dyt.generic.BaseClass;
	import com.dyt.ors.screenpages.AddMainCategory;
	import com.dyt.ors.screenpages.AddProduct;
	import com.dyt.ors.screenpages.AddSubCategory;
	import com.dyt.ors.screenpages.Dashboard;
	import com.dyt.ors.screenpages.EditMainCategory;
	import com.dyt.ors.screenpages.EditProduct;
	import com.dyt.ors.screenpages.EditSubCategory;
	import com.dyt.ors.screenpages.Home;
	import com.dyt.ors.screenpages.HomeMenuTab_SearchProduct;
	import com.dyt.ors.screenpages.Login;

	public class SmokeTestCases extends BaseClass{
		
		@Test
		public static void TC001_addMainCategory()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
			
			home.navLoginpage();
			login.loginApp("admin","admin@123");
			dashboard.navMainCategories();
			addMainCategory.AddMainCategory("Antibiotics", "W");
		}
		
		
		@Test
		public static void TC002_addSubCategory()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			AddSubCategory addsubcategory= PageFactory.initElements(driver, AddSubCategory.class);
			
			home.navLoginpage();;
			login.loginApp("admin","admin@123");
			dashboard.navSubCategories();
			addsubcategory.AddSubCategory("Tylenol", "DIMETHY", "Y");
								
		} 
	
		/*@Test
		public static void TC005_editSubCategory()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			EditSubCategory editsubcategory= PageFactory.initElements(driver, EditSubCategory.class);
			
			home.navLoginpage();;
			login.loginApp("admin","admin@123");
			dashboard.navSubCategories();
			editsubcategory.selectEditicon("sample");
			editsubcategory.editSubCategoryPage("Tylenol", "paracetamol", "Y");
								
		} 
		*/
		/*@Test
		public static void TC003_addProducts()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			AddProduct addproduts= PageFactory.initElements(driver, AddProduct.class);
			
			home.navLoginpage();
			login.loginApp("admin","admin@123");
			dashboard.navProducts();
			addproduts.AddProducts("GLENMAARKS1", "FAVIPARIS7", "231", "Acetaminopen", "A+", "propanol", "12A", "reddyslabs", "50", "20", "Code10", "60", "V");					
		} */
		
		/*@Test
		public static void TC004_editMainCategory()
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
		public static void TC006_editProduct()
		{		
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			EditProduct editProduct= PageFactory.initElements(driver, EditProduct.class);
			
			home.navLoginpage();;
			login.loginApp("admin","admin@123");
			dashboard.navProducts();
			editProduct.selectEditicon("111");
			editProduct.editProduct("cat123", "123D1", "B++", "products", "123A", "123A", "123");					
		} 
		*/
		
		@Test
		public static void TC001_HomePage()
		{		
			HomeMenuTab_SearchProduct homepage = PageFactory.initElements(driver, HomeMenuTab_SearchProduct.class);
			
			homepage.HomeMenuTabs();
			homepage.SearchProduct("Acetaminopen");
				
		}
		
}
