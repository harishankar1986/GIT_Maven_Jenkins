package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class DisplayProductList extends WebLibrary {
	
	// =========WebElements for Display Product List Page ==================
	
	@FindBy(xpath = "//h1[text()='Products']")
		public static WebElement text_Products;

		@FindBy(xpath = "//h6[text()='Display Products List']")
		public static WebElement text_DisplayProductsList;

		@FindBy(xpath = "//select[@name='dataTable_length']")
		public static WebElement select_RowEntries;

		@FindBy(xpath = "//input[@type='search']")
		public static WebElement edit_Search;

		@FindBy(xpath = "//div[@id = 'dataTable_info']")
		public static WebElement text_DisplayRowEntries;

		@FindBy(xpath = "//li[@id = 'dataTable_previous']/a")
		public static WebElement btn_Previous;

		@FindBy(xpath = "//li[@id = 'dataTable_next']/a")
		public static WebElement btn_Next;

		@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/a")
		public static WebElement link_AddProducts;

		@FindBy(xpath = "//*[@id='userDropdown']/img")
		public static WebElement img_AdminImg;

		@FindBy(xpath = "//*[@id=\"content\"]/nav/ul/li[2]/div/a[2]")
		public static WebElement link_LogOut;

		
	// =================DisplayProduct List methods=========================
	/*
		Name            :   verify_TableColumnHeaderText
		Description		: 	verify table column headers are displayed as expected
		Author			: 	Anwesha 
		Date			: 	10th July  2020
		Parameters		: 	array of string 
		Modified Date	:	
		Modified By		:
		*/

		public  void verify_TableColumnHeaderText(String[] arr1) {
			boolean bstatus = false;
			List<WebElement> columnHeaders = driver.findElements(By.xpath("//*[@id='dataTable']/thead/tr/th"));
			String[] arr = new String[columnHeaders.size()];
			for (int i = 1; i <= columnHeaders.size(); i++) {

				arr[i - 1] = driver.findElement(By.xpath("//*[@id='dataTable']/thead/tr/th[" + i + "]")).getText();

			}


			for (int j = 0; j < columnHeaders.size(); j++) {
				if (arr[j].equalsIgnoreCase(arr1[j])) {
					bstatus = true;
				} else {
					bstatus = false;
					break;
				}
			}

			Reporter.log(bstatus, "Table Column headers text verified", "Table Column headers  text not verified");

			if (bstatus == true)
				System.out.println("Column headers text verified");
			else
				System.out.println("Column headers text not verified");

		}

		// =============================================================================
		/*
		Name            :   verify_ProductPageHeader
		Description		: 	Verify Panel Header as "Products " is displayed or not
		Parameters		: 	none
		Author			: 	Anwesha
		Date			: 	10th July 2020	
		Modified Date	        :	
		Modified By		:
		*/
		public  void verify_ProductPageHeader() {

			boolean bstatus;

			bstatus = verifyText(text_Products);
			Reporter.log(bstatus, "Products text verified", "Products text not verified");

		}

		// =============================================================================
		/*
		Name            :   navAddProductspage
		Description		: 	navigate to Add Product Page
		Parameters		: 	none
		Author			: 	Anwesha
		Date			: 	10th July 2020
		Modified Date	        :	
		Modified By		:
		*/
		public  void navAddProductspage() {
			
			boolean bStatus = clickElement(link_AddProducts);
			Reporter.log(bStatus, "Add Products link clicked", "Add Products link not clicked");
		}

		// ===========================================
	 /*
			Name            :   verify_NewlyAddedProduct
			Description		: 	This method is used to verify newly added data reflected into table
			Author			: 	Anwesha
			Date			: 	10th July 2020
			Parameters		: 	cat no, array of string
			Modified Date	        :	
			Modified By		:
			*/
		
		public  void verify_NewlyAddedProduct(String expCatNo, String arr[]) {
			boolean bStatus = false;
			int rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();
			int colCount = driver.findElements(By.xpath("//*[@id='dataTable']/thead/tr/th")).size();
			String nextButtonClassName;
			if (rowCount != 0) {
				do {
					nextButtonClassName = driver.findElement(By.id("dataTable_next")).getAttribute("class");
					for (int i = 1; i <= rowCount; i++) {
						String actCatNo = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[6]"))
								.getText();

						if (actCatNo.trim().equalsIgnoreCase(expCatNo)) {
							for (int j = 3; j < colCount; j++) {
								String rowCellText = driver
										.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[" + j + "]"))
										.getText();
								
								if (!rowCellText.equalsIgnoreCase(arr[j - 3])) {
									bStatus = false;
									break;
								}

							} 
							bStatus = true;
							break;
						} 
					} 

					if (bStatus == false) {

						driver.findElement(By.xpath("//li[@id='dataTable_next']")).click();

						rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();

					}else {
						break;
					}

				} while (!nextButtonClassName.contains("disabled"));
				Reporter.log(bStatus, "Product in result table displayed as expected",
						"Product in result table not displayed as expected");

			} else

				Reporter.logEvent("warning", "No result displayed in result table");

		}
		// ===========================================
		

}
