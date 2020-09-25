package com.dyt.ors.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dyt.generic.BaseClass;
import com.dyt.ors.screenpages.AddMainCategoriesList;
//import com.dyt.ors.screenpages.AddProductCategories;
import com.dyt.ors.screenpages.AddProducts;
import com.dyt.ors.screenpages.AddSubCategories;
import com.dyt.ors.screenpages.Dashboard;
import com.dyt.ors.screenpages.DeleteProduct;
import com.dyt.ors.screenpages.DisplayMainCategories;
import com.dyt.ors.screenpages.DisplayProductList;
//import com.dyt.ors.screenpages.DisplayProductsList;
import com.dyt.ors.screenpages.DisplaySubCategoriesList;
import com.dyt.ors.screenpages.EditMainCategoriesList;
import com.dyt.ors.screenpages.EditProductExistingImage_Products;
import com.dyt.ors.screenpages.EditProducts;
import com.dyt.ors.screenpages.EditSubCategories;
import com.dyt.ors.screenpages.Home;
import com.dyt.ors.screenpages.Login;
import com.dyt.ors.screenpages.ProductDetails;
import com.dyt.ors.screenpages.ProductList;
import com.dyt.ors.screenpages.SearchFunctionality;
import com.dyt.utilities.ExcelLib;

public class RegressionTestCases extends BaseClass {
	
	@Test
	public static void TC001_adminLoginWithValidData() {
		
		String[] data = ExcelLib.getRowData("TC001_adminLoginWithValidData", Regression_Sheet);
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);

		
		home.navLoginpage();
		
		login.verify_LoginPage_DisplayedElements();
		
		login.loginApp(data[0], data[1]);

	}
//=======================================================================
	@Test
	public static void TC002_adminLoginWithInValidData() {
		
		String[] data = ExcelLib.getRowData("TC002_adminLoginWithInValidData", Regression_Sheet);
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);



		home.navLoginpage();
		
		login.verify_LoginPage_DisplayedElements();

		// Enter the Valid Login id, Invalid password and click on Login button.
		login.loginApp(data[0], data[1]);
		login.verifyAlertMessage(data[6]);

		// Enter the Invalid Login id, Invalid password and click on Login button.
		login.loginApp(data[2], data[3]);
		login.verifyAlertMessage(data[6]);

		// Enter the Invalid Login id, Valid password and click on Login button.
		login.loginApp(data[4], data[5]);
		login.verifyAlertMessage(data[6]);

		// With out input the data in Admin user ID, Password and Click on Login button.
		login.loginApp("", "");
		login.verifyAlertMessage(data[6]);

	}
	//=======================================================================

	@Test
	public static void TC003_AddMainCategory() {
		
		String[] data = ExcelLib.getRowData("TC003_AddMainCategory", Regression_Sheet);
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplayMainCategories displaymaincategories = PageFactory.initElements(driver, DisplayMainCategories.class);
		AddMainCategoriesList addmainCategorieslist = PageFactory.initElements(driver, AddMainCategoriesList.class);
		
        //navigate to log in page
		home.navLoginpage();
		
        //verify user name and password text field displayed or not
		login.verify_LoginPage_DisplayedElements();
        
		//log into apps
		login.loginApp(data[0], data[1]);
		
		// navigate to main category
		dashboard.navMainCategories();
		
		// verify Table header as Display main category list is present or not
		displaymaincategories.verify_DisplayMainCategoriesList_TableHeader();
		
		// verify table column headers are displayed on Display main category page
		displaymaincategories.verify_MainCategory_DisplayedColumnsHeader();
		
		// verify Main category as page header is displayed or not
		displaymaincategories.verify_MainCategories_PageHeader();
		
		// navigate to add main category page
		displaymaincategories.navAddMainCategoriesPage();
		
		// verify crucial elements are displayed or not on Add main category page
		addmainCategorieslist.verify_AddMainCategoryListPage_DisplayedElements();
		
		// values are entered on main category, assign order, image selected,then click on submit
		addmainCategorieslist.addMainCategory(data[2], data[3], data[4]);
		
		// verify added main category is displayed on table
		 String[] arr = { data[2], data[3] };
		 displaymaincategories.verify_UpdatedMainCategory(data[2], arr);

	}
	
	//=======================================================================

	@Test
	public static void TC004_AddMainCategory_Duplicaterecord() {
		
		String[] data = ExcelLib.getRowData("TC004_AddMainCategory_Duplicaterecord", Regression_Sheet);
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplayMainCategories displaymaincategories = PageFactory.initElements(driver, DisplayMainCategories.class);
		AddMainCategoriesList addmainCategorieslist = PageFactory.initElements(driver, AddMainCategoriesList.class);
		
		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password text field displayed or not
		login.verify_LoginPage_DisplayedElements();
		
		// log into apps
		login.loginApp(data[0], data[1]);
		
		// navigate to main category
		dashboard.navMainCategories();
		
		// verify Table header as Display main category list is present or not
		displaymaincategories.verify_DisplayMainCategoriesList_TableHeader();
		
		// verify table column headers are displayed on Display main category page
		displaymaincategories.verify_MainCategory_DisplayedColumnsHeader();
		
		// verify Main category as page header is displayed or not
		displaymaincategories.verify_MainCategories_PageHeader();
		
		// navigate to add main category page
		displaymaincategories.navAddMainCategoriesPage();
		
		// verify crucial elements are displayed or not on Add main category page
		addmainCategorieslist.verify_AddMainCategoryListPage_DisplayedElements();
		
		// give existing duplicate main cat value and verify the error message
		addmainCategorieslist.verify_MainCategory_DuplicateRecord(data[2], data[3]);
		
	}
	
	//=======================================================================

	@Test
	public static void TC005_AddMainCategory_WithoutMandatoryfields() {
		
		String[] data = ExcelLib.getRowData("TC005_AddMainCategory_WithoutMandatoryfields", Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplayMainCategories displaymaincategories = PageFactory.initElements(driver, DisplayMainCategories.class);
		AddMainCategoriesList addmainCategorieslist = PageFactory.initElements(driver, AddMainCategoriesList.class);
		
		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password text field displayed or not
		login.verify_LoginPage_DisplayedElements();
		
		// log into apps
		login.loginApp(data[0], data[1]);
		
		// navigate to main category
		dashboard.navMainCategories();
		
		// verify Table header as Display main category list is displayed or not
		displaymaincategories.verify_DisplayMainCategoriesList_TableHeader();
		
		// verify table column headers are displayed on display main category page
		displaymaincategories.verify_MainCategory_DisplayedColumnsHeader();
		
		// verify Main category as page header is displayed or not
		displaymaincategories.verify_MainCategories_PageHeader();
		
		// navigate to add main category page
		displaymaincategories.navAddMainCategoriesPage();
		
		// verify crucial elements are displayed or not on Add main category page
		addmainCategorieslist.verify_AddMainCategoryListPage_DisplayedElements();
		
		// on main category page with out entering any value click on submit and verify the error message
		addmainCategorieslist.verify_AddMainCategory_WithoutMandatoryfields(data[2]);
	}
	
	//=======================================================================

	@Test
	public static void TC006_EditMainCategory() {
		
		String[] data = ExcelLib.getRowData("TC006_EditMainCategory", Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplayMainCategories displaymaincategories = PageFactory.initElements(driver, DisplayMainCategories.class);
		EditMainCategoriesList editMaincategorieslist = PageFactory.initElements(driver, EditMainCategoriesList.class);
		
        // navigate to log in page
		home.navLoginpage();
		
		// verify user name and password text field displayed or not
		login.verify_LoginPage_DisplayedElements();
		
		// log into apps
		login.loginApp(data[0], data[1]);
		
        // navigate to display main categories list page
		dashboard.navMainCategories();
		
		// verify Table header as Display main category list is displayed or not
		displaymaincategories.verify_DisplayMainCategoriesList_TableHeader();
		
		// verify table column headers are displayed on Display main category page
		displaymaincategories.verify_MainCategory_DisplayedColumnsHeader();
		
		// search for a particular Main category name and click on respective Edit icon  on tabular column
		displaymaincategories.clicking_MainCategory_EditIcon(data[2]);
		
		// verify the previous details
		editMaincategorieslist.verify_EditMainCategory_PrevoiusDetails(data[2], data[3]);
		
		// modify the details on Edit main categories page
		editMaincategorieslist.update_EditMainCategory(data[4], data[5], data[6]);
		
		// verify modified main category is displayed on table
		String[] arr = { data[4], data[5] };
		displaymaincategories.verify_UpdatedMainCategory(data[4], arr);

	}
	
	//=======================================================================

	@Test
	public static void TC007_DeleteMainCategory() {
		
		String[] data = ExcelLib.getRowData("TC007_DeleteMainCategory", Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplayMainCategories displaymaincategories = PageFactory.initElements(driver, DisplayMainCategories.class);
		
		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password text field displayed or not
		login.verify_LoginPage_DisplayedElements();
		
		// log into apps
		login.loginApp(data[0], data[1]);
		
		//navigate to display main categories list page
		dashboard.navMainCategories();
		
		// verify Table header as Display main category list is displayed or not
		displaymaincategories.verify_DisplayMainCategoriesList_TableHeader();
		
		// verify table column headers are displayed on Display main category page
		displaymaincategories.verify_MainCategory_DisplayedColumnsHeader();
		
		//search for a particular  Main category name and click on respective Delete icon  on tabular column
		displaymaincategories.clicking_MainCategory_DeleteIcon(data[2]);
		
		//verify alert message when clicking on Delete icon
		displaymaincategories.verify_MainCategory_DeleteAlertMessage(data[3]);
		
		//cancel the alert and verify main category name is exist in table
		displaymaincategories.click_CancelAlert_VerifyMainCategory(data[2]);
		
		//search for a particular  Main category name and click on respective Delete icon  on tabular column
		displaymaincategories.clicking_MainCategory_DeleteIcon(data[2]);

		//accept the alert and verify deleted main category name is still exist in table
		displaymaincategories.click_OkAlert_VerifyMainCategory(data[2]);

	}
	
	//=======================================================================

	@Test
	public static void TC008_AddSubCategory() {
		
		String[] data = ExcelLib.getRowData("TC008_AddSubCategory", Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplaySubCategoriesList displaysubcategorieslist = PageFactory.initElements(driver,
				DisplaySubCategoriesList.class);
		AddSubCategories addsubcategories = PageFactory.initElements(driver, AddSubCategories.class);
		
		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password field are displayed on Log in page
		login.verify_LoginPage_DisplayedElements();
		
		// entered user name , password and click on submit
		login.loginApp(data[0], data[1]);
		
		// navigate to display sub category page
		dashboard.navSubCategories();
		
        //verify S.No, Main Category Name,Sub Category, Order, Action are visible on tabular column header
		displaysubcategorieslist.verify_SubCategory_DisplayedColumnsHeader();
		
        //Verify Panel Header as "Sub Categories" is displayed or not
		displaysubcategorieslist.verify_SubCategories_PageHeader();
		
        //Verify Add SubCategories Link is displayed or not
		displaysubcategorieslist.verify_AddSubCategoriesLink();
		
        //navigate to Add Sub Categories Page
		displaysubcategorieslist.navAddSubCategoriesPage();
		
        //verify Add MainCategory List Page displayed the following controls Main Category Name ,Sub Category Name,Assigned Order,Category Images
		addsubcategories.verify_AddSubCategoriesPage_DisplayedElements();
		
        //add new Sub category name under a particular main category name, order and upload image
		addsubcategories.addSubCategory(data[2],data[3],data[4],data[5]);
		
		//used to verify new data is reflected on  table on Display Sub category page based on sub category name
		String[] arr1 = {data[2],data[3],data[4]};
		displaysubcategorieslist.verify_UpdatedSubCategory(data[3], arr1);

	}
	
	//=======================================================================

	@Test
	public static void TC009_AddSubCategory_WithoutMandatoryfields() {
		
		String[] data = ExcelLib.getRowData("TC009_AddSubCategory_WithoutMandatoryfields",Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplaySubCategoriesList displaysubcategorieslist = PageFactory.initElements(driver,
				DisplaySubCategoriesList.class);
		AddSubCategories addsubcategories = PageFactory.initElements(driver, AddSubCategories.class);

		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password field are displayed on Log in page
		login.verify_LoginPage_DisplayedElements();
		
		// entered user name , password and click on submit
		login.loginApp(data[0], data[1]);
		
		// navigate to display sub category page
		dashboard.navSubCategories();
		
        //verify S.No, Main Category Name,Sub Category, Order, Action are visible on tabular column header
		displaysubcategorieslist.verify_SubCategory_DisplayedColumnsHeader();
		
        //Verify Panel Header as "Sub Categories" is displayed or not
		displaysubcategorieslist.verify_SubCategories_PageHeader();
		
        //navigate to Add Sub Categories Page
		displaysubcategorieslist.navAddSubCategoriesPage();
		
        //verify Add MainCategory List Page displayed the following controls Main Category Name ,Sub Category Name,Assigned Order,Category Images
		addsubcategories.verify_AddSubCategoriesPage_DisplayedElements();
		
		// verify with out filling the mandatory fields when clicking on submit button expected alert message is showing
		addsubcategories.addSubCategory_WithoutMandatoryfields(data[2]);
		
		// create a new sub category under a main category with out selecting order
		addsubcategories.addSubCategory_WithoutSelectingOrder(data[3], data[4]);
		
		// verify if user don't select order while creating a new sub category, then by default A is selected as Order
		String[] arr1 = { data[3], data[4], data[5] };
		displaysubcategorieslist.verify_UpdatedSubCategory(data[4], arr1);

	}
	//=======================================================================
	@Test
	public static void TC010_AddSubCategory_Duplicaterecord() {
		
		String[] data = ExcelLib.getRowData("TC010_AddSubCategory_Duplicaterecord",Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplaySubCategoriesList displaysubcategorieslist = PageFactory.initElements(driver,
				DisplaySubCategoriesList.class);
		AddSubCategories addsubcategories = PageFactory.initElements(driver, AddSubCategories.class);

		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password field are displayed on Log in page
		login.verify_LoginPage_DisplayedElements();
		
		// entered user name , password and click on submit
		login.loginApp(data[0], data[1]);
		
		// navigate to display sub category page
		dashboard.navSubCategories();
		
        //verify S.No, Main Category Name,Sub Category, Order, Action are visible on tabular column header
		displaysubcategorieslist.verify_SubCategory_DisplayedColumnsHeader();
		
        //navigate to Add Sub Categories Page
		displaysubcategorieslist.navAddSubCategoriesPage();
		
		//verify Add MainCategory List Page displayed the following controls Main Category Name ,Sub Category Name,Assigned Order,Category Images
		addsubcategories.verify_AddSubCategoriesPage_DisplayedElements();
		
		// verify when we click on submit by entering duplicate sub category name under a main category, expected error message should shown
		addsubcategories.verify_AddSubCategory_DuplicateRecord(data[2], data[3], data[4], data[5]);

	}
	
	//=======================================================================

	@Test
	public static void TC011_EditSubCategory() {
		
		String[] data = ExcelLib.getRowData("TC011_EditSubCategory",Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplaySubCategoriesList displaysubcategorieslist = PageFactory.initElements(driver,
				DisplaySubCategoriesList.class);
		EditSubCategories editsubcategories = PageFactory.initElements(driver, EditSubCategories.class);

		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password field are displayed on Log in page
		login.verify_LoginPage_DisplayedElements();
		
		// entered user name , password and click on submit
		login.loginApp(data[0], data[1]);
		
		// navigate to display sub category page
		dashboard.navSubCategories();
		
        //verify S.No, Main Category Name,Sub Category, Order, Action are visible on tabular column header
		displaysubcategorieslist.verify_SubCategory_DisplayedColumnsHeader();
		
		// search for a particular sub category name record given in parameters and click on respective Edit icon on tabular column
		displaysubcategorieslist.clicking_SubCategory_EditIcon(data[2]);
		
		// verify the expected main category name, sub category name and order with actual value available on page
		editsubcategories.verify_EditSubCategory_PrevoiusDetails(data[3], data[2], data[4]);
		
		// update Main Category Name only while the other items remains same on Edit Sub Category page
		editsubcategories.update_EditSubCategories_MainCategory(data[5]);
		
		// verify updated details are reflected into table on Display sub category list page
		String[] arr1 = { data[5], data[2], data[4] };		
		displaysubcategorieslist.verify_UpdatedSubCategory(data[2], arr1);
		
		// search for a particular sub category name record given in parameters and click on respective Edit icon on tabular column
		displaysubcategorieslist.clicking_SubCategory_EditIcon(data[2]);
		
		// update Sub Category Name only while the other items remains same on Edit Sub Category page
		editsubcategories.update_EditSubCategory(data[6]);
		
		// verify updated details are reflected into table on Display sub category list  page
		String[] arr2 = { data[5], data[6], data[4] };
		displaysubcategorieslist.verify_UpdatedSubCategory(data[6], arr2);
		
		// search for a particular sub category name record given in parameters and click on respective Edit icon on tabular column
		displaysubcategorieslist.clicking_SubCategory_EditIcon(data[6]);
		
		// update assigned order only while the other items remains same on Edit Sub Category page
		editsubcategories.update_EditSubCategories_Order(data[7]);
		
		// verify updated details are reflected into table on Display sub category list page
		String[] arr3 = { data[5], data[6], data[7] };
		displaysubcategorieslist.verify_UpdatedSubCategory(data[6], arr3);

	}
	
	//=======================================================================

	@Test
	public static void TC012_DeleteSubCategory() {
		
		String[] data = ExcelLib.getRowData("TC012_DeleteSubCategory",Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplaySubCategoriesList displaysubcategorieslist = PageFactory.initElements(driver,
				DisplaySubCategoriesList.class);

		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password field are displayed on Log in page
		login.verify_LoginPage_DisplayedElements();
		
		// entered user name , password and click on submit
		login.loginApp(data[0], data[1]);
		
		// navigate to display sub category page
		dashboard.navSubCategories();
		
		// verify S.No, Main Category Name,Sub Category, Order, Action are visible on tabular column header
		displaysubcategorieslist.verify_SubCategory_DisplayedColumnsHeader();
		
		// search for a particular record Sub category name and click on respective Delete icon on tabular column
		displaysubcategorieslist.clicking_SubCategory_DeleteIcon(data[2]);
		
		// verify alert message when clicking on Delete icon
		displaysubcategorieslist.verify_SubCategory_DeleteAlertMessage(data[3]);
		
		// cancel the alert and verify sub category name is exist in table
		displaysubcategorieslist.click_CancelAlert_VerifySubCategory(data[2]);
		
		// search for a particular record Sub category name and click on respective Delete icon on tabular column
		displaysubcategorieslist.clicking_SubCategory_DeleteIcon(data[2]);
		
		// accept the alert and verify deleted Sub category name is still exist in table
		displaysubcategorieslist.click_OkAlert_VerifySubCategory(data[2]);

	}
	//=======================================================================

	@Test
	public static void TC013_AddProducts() {
	
		String[] data = ExcelLib.getRowData("TC013_AddProducts",Regression_Sheet);
		Home home = PageFactory.initElements(driver, Home.class);
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		DisplayProductList displayproductlist = PageFactory.initElements(driver, DisplayProductList.class);
		AddProducts addproducts = PageFactory.initElements(driver, AddProducts.class);


		// navigate to log in page
		home.navLoginpage();
		
		// verify user name and password field are displayed on Log in page
		login.verify_LoginPage_DisplayedElements();
		
		// entered user name , password and click on submit
		login.loginApp(data[0], data[1]);
		
		// navigate to display product list page
		dashboard.navProducts();
		
		//verify table column headers are displayed as expected
		String arr[] = { "S No", "Product Image", "Main Category", "Sub Category", "Availability", "Cat No","Pack Size", "Make", "Product Description", "Product Price", "Product Grade", "Cas No", "HS Code","Order By", "Action" };
		displayproductlist.verify_TableColumnHeaderText(arr);
		
		//Verify Panel Header as "Products " is displaying or not
		displayproductlist.verify_ProductPageHeader();
		
		//navigate to Add Product Page
		displayproductlist.navAddProductspage();
		
		//verify important elements are displayed
		addproducts.verify_AddProductCategoryPage_DisplayedElements();
		
		//this method is used to add a new product
		addproducts.AddProduct(data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11],
				data[12], data[13], data[14], data[15], data[16], data[17], data[18],data[19]);
		
		//This method is used to verify newly added data reflected into table
		String arr1[] = { data[2], data[3], data[11], data[4], data[10], data[9], data[5], data[13], data[6], data[8], data[12], data[14] };
		displayproductlist.verify_NewlyAddedProduct(data[4], arr1);
		

	}
	
	//=======================================================================
	
	 @Test
		public static void TC014_addProductswithoutMaindatoryFields()
		{		
		    String[] data = ExcelLib.getRowData("TC014_addProductswithoutMaindatoryFields",Regression_Sheet);
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);	
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
		
			home.navLoginpage();
			login.loginApp(data[0], data[1]);
			dashboard.navProducts();
			addproduct.addProductswithoutMaindarory("c", "Fever", "302", "4/4", "53", "706", "S", "C:\\Users\\Singam Sirisha\\Desktop\\file_example_JPG_100kB.jpg", 
					"C:\\Users\\Singam Sirisha\\Desktop\\file-sample_150kB.pdf", "C:\\Users\\Singam Sirisha\\Desktop\\file-example_PDF_500_kB.pdf");

}
	 
	//============================Add Products with out SubCategory=====================	
			public static void TC015_addProductWithoutSubCategory()
			{	
				String[] data = ExcelLib.getRowData("TC015_addProductWithoutSubCategory",Regression_Sheet);
				Login login = PageFactory.initElements(driver, Login.class);
				Home home = PageFactory.initElements(driver, Home.class);
				Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
				AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);

				home.navLoginpage();
				login.loginApp(data[0], data[1]);
				dashboard.navProducts();
				addproduct.addProductwithoutSubCategory("SINAREST1","205", "For Cold", "C", "For Cold", "706", "CIPLA2", "6/6",
				"20", "22150", "150", "B", "C:\\Users\\Singam Sirisha\\Desktop\\image1.jpg", 
						"C:\\Users\\Singam Sirisha\\Desktop\\file-example_PDF_1MB.pdf", "C:\\Users\\Singam Sirisha\\Desktop\\dummy.pdf");	
			}
	 //============================Add Products with Duplicate product=====================		
			public static void TC016_addProductwithDuplicateProduct()
			{	
				String[] data = ExcelLib.getRowData("TC016_addProductwithDuplicateProduct",Regression_Sheet);
				Login login = PageFactory.initElements(driver, Login.class);
				Home home = PageFactory.initElements(driver, Home.class);
				Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
				AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
				
				home.navLoginpage();
				login.loginApp(data[0], data[1]);
				
				dashboard.navProducts();
				addproduct.addProducts("SINAREST", "PARACIP", "201", "For Cold", "C", "For Cold", "708", "CIPLA", "6/6",
				"20", "224150", "155", "B", "C:\\Users\\Singam Sirisha\\Desktop\\image2.jpg", 
						"C:\\Users\\Singam Sirisha\\Desktop\\Sample1.PDF", "C:\\Users\\Singam Sirisha\\Desktop\\Sample2.PDF");			
			} 
	//=========================Edit product========================
		@Test
			public static void TC017_EditProducts()
			{	
			    String[] data = ExcelLib.getRowData("TC017_EditProducts",Regression_Sheet);
				Login login = PageFactory.initElements(driver, Login.class);
				Home home = PageFactory.initElements(driver, Home.class);
				Dashboard dashBoard = PageFactory.initElements(driver, Dashboard.class);
				AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
				EditProducts editProduct= PageFactory.initElements(driver, EditProducts.class);
				
				home.navLoginpage();
				login.loginApp(data[0], data[1]);
				dashBoard.navProducts();
				
				boolean BTag=true;
				for(int row=1;row<=10;row++)
				{
					String cellText=driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr["+row+"]/td[3]")).getText();
					
					
					
					if((cellText.contains("dimethy")))
							
							{
						
						editProduct.EditProduct();
						addproduct.addProducts("SINAREST", "PARACIP", "201", "For Cold", "C", "For Cold Tablet", "706", "CIPLA", "6/6",
						"20", "224150", "150", "B", "C:\\Users\\Singam Sirisha\\Desktop\\image3.jpg", 
						"C:\\Users\\Singam Sirisha\\Desktop\\Sample3.PDF", "C:\\Users\\Singam Sirisha\\Desktop\\xlsdemo2.pdf");
						
					
					}
					BTag=false;
					break;
					
						
							}
			
			
				
				if(BTag=true)
				{
					System.out.println("Details Edited Succesfully");
				}
				else
				{
					System.out.println("Details Not Edited");
				
		       }
			}
	//===============================EditProductExistingImage_Products=====================================

			@Test
			public static void TC018_EditProductExistingImage_Products()
		{		
			String[] data = ExcelLib.getRowData("TC018_EditProductExistingImage_Products",Regression_Sheet);
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			EditProductExistingImage_Products editProductimage= PageFactory.initElements(driver,EditProductExistingImage_Products.class);
			
			home.navLoginpage();;
			login.loginApp(data[0], data[1]);
			dashboard.navProducts();
			editProductimage.selectEditicon("cat-78");
			editProductimage.editProductImage();
			editProductimage.verifyNewAddedProduct("cat-78");
		} 
	//=====================Delete the product==========================================
		
		@Test
		public static void TC019_deleteProduct() throws InterruptedException
		{		
			String[] data = ExcelLib.getRowData("TC019_deleteProduct", Regression_Sheet);
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
			DeleteProduct deleteproduct = PageFactory.initElements(driver, DeleteProduct.class);
						
			home.navLoginpage();;
			login.loginApp(data[0],data[1]);
			dashboard.navProducts();
			Thread.sleep(3000);
			deleteproduct.selectDeleteicon(data[2]);
			Thread.sleep(3000);
			deleteproduct.acceptAlert();
			deleteproduct.verifyDeletedProduct(data[3]);
						
		}
	//===================Verify home page ==================================================
		
		@Test
		public static void TC020_homePage()
		{		
			String[] data = ExcelLib.getRowData("TC020_homePage", Regression_Sheet);
			Home home = PageFactory.initElements(driver, Home.class);
			
			home.verifyLoginlink();
			home.verifyRegisterlink();
			home.searchproduct(data[0]);
			home.navAboutOrbit();
			home.navCOA();
			home.navLiteratures();
			home.navProduct();
			home.navContactus();
		}
	//==================verify the search bar without inputing the data========================
		
		@Test
		public static void TC021_searchWithoutInputTheData()
		{		
			String[] data = ExcelLib.getRowData("TC021_searchWithoutInputTheData", Regression_Sheet);
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);
			
			searchfuntionality.searchProductNotInputingTheData(data[0]);
		}
			
	//==================verify the search bar with Invalid data========================
		
			@Test
			public static void TC022_searchWithInvalidData()
			{		
				String[] data = ExcelLib.getRowData("TC022_searchWithInvalidData", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);
				
				searchfuntionality.searchProductInvalidData(data[0]);
			}
	//========================Search the Product with product name========================		
			@Test
			public static void TC023_searchWithProductName()
			{		
				String[] data = ExcelLib.getRowData("TC023_searchWithProductName", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);			
				
				searchfuntionality.searchWithProductName(data[0]);
			}
			
	//========================Search the Product with Synonym========================		
			@Test
			public static void TC024_searchWithSynonym()
			{		
				String[] data = ExcelLib.getRowData("TC024_searchWithSynonym", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);					
				
				searchfuntionality.searchWithSynonym(data[0]);
			}
			
	 //========================Search the Product with CatNo========================		
			@Test
			public static void TC025_searchWithCatNo()
			{		
				String[] data = ExcelLib.getRowData("TC025_searchWithCatNo", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);							
				
				searchfuntionality.searchWithCatNo(data[0]);
			}
	//========================Search the Product with CasNo========================		
			@Test
			public static void TC026_searchWithCasNo()
			{		
				String[] data = ExcelLib.getRowData("TC026_searchWithCasNo", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
				
				searchfuntionality.searchWithCasNo(data[0]);
			}
			
			//================Verify related Products available are not======================
			@Test
			public static void TC027_searchRelatedProducts()
			{		
			   String[] data = ExcelLib.getRowData("TC027_searchRelatedProducts", Regression_Sheet);
			   SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
						
			   searchfuntionality.verifyrelatedProducts(data[0]);
					
			}
			
	//================Verify related Categories available are not======================
			@Test
			public static void TC028_Search_RelatedCategories() {
				
	            String[] data = ExcelLib.getRowData("TC028_Search_RelatedCategories",Regression_Sheet);
				Home home = PageFactory.initElements(driver, Home.class);
				ProductList productlist = PageFactory.initElements(driver, ProductList.class);
				ProductDetails productdetails = PageFactory.initElements(driver, ProductDetails.class);

				home.SearchProduct(data[0]);
				
				productlist.clickOnProduct(data[1]);
				
				productdetails.verify_ProductDetails_DisplayedElements();
				
				productdetails.verify_ProductDetails_DisplayedRelatedCategories();
				
				productdetails.verify_RelatedCategories_DisplayNames();
				
				productdetails.clicking_RelatedCategoriesNames(data[2]);

			}
			
			@Test
			public static void TC028_searchRelatedCategories()
			{		
			   String[] data = ExcelLib.getRowData("TC028_searchRelatedCategories", Regression_Sheet);
			   SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
								
			   searchfuntionality.verifyrelatedCategories(data[0]);
							
			}
	 //================Verify related documents available are not======================
			@Test
			public static void TC029_searchRelatedDocuments()
			{		
				String[] data = ExcelLib.getRowData("TC029_searchRelatedDocuments", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
				
				searchfuntionality.verifyrelateddocumnets(data[0], data[1]);
			}
	//===============verify with invalid LotNo in COA=================================	
			@Test
			public static void TC030_Search_RelatedDocuments_InValidLotNo() {
				String[] data = ExcelLib.getRowData("TC030_Search_RelatedDocuments_InValidLotNo",Regression_Sheet);
				Home home = PageFactory.initElements(driver, Home.class);
				ProductList productlist = PageFactory.initElements(driver, ProductList.class);
				ProductDetails productdetails = PageFactory.initElements(driver, ProductDetails.class);

				home.SearchProduct(data[0]);
				
				productlist.clickOnProduct(data[1]);
				
				productdetails.verify_ProductDetails_DisplayedElements();
				
				productdetails.verify_COASearch_InvalidLotNo(data[2], data[3]);

			}
			
			@Test
			public static void TC030_searchWithInvalidLotNo() throws InterruptedException
			{		
				String[] data = ExcelLib.getRowData("TC030_searchWithInvalidLotNo", Regression_Sheet);
				SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
				
				searchfuntionality.searchWithInvalidLotNo(data[0],data[1]);
			}
	 
	 
}
