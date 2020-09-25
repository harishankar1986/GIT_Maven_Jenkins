package com.dyt.ors.smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dyt.generic.BaseClass;
import com.dyt.ors.screenpages.AddMainCategory;
import com.dyt.ors.screenpages.AddProduct;
import com.dyt.ors.screenpages.Dashboard;
import com.dyt.ors.screenpages.EditMainCategory;
import com.dyt.ors.screenpages.Home;
import com.dyt.ors.screenpages.Login;

public class SmokeTestCases extends BaseClass{
	
	/*@Test
	public static void TC001_addMainCategory()
	{		
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
		
		home.navLoginpage();;
		login.loginApp("admin","admin@123");
		addMainCategory.navAddmainCategory();
		addMainCategory.AddMainCategory("HPCL", "M");
	}*/
	
	@Test
	public static void TC003_addProducts()
	{		
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		AddProduct addproduts= PageFactory.initElements(driver, AddProduct.class);
		
		home.navLoginpage();;
		login.loginApp("admin","admin@123");
		addproduts.navAddProducts();
		addproduts.AddProducts("Acetonic", "samplesub", "111", "Hexafluoro", "A+", "propanol", "345", "reddyslabs", "30", "10", "Code150", "6000", "E");
				
	} 
	
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
}
