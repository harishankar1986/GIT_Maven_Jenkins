package com.dyt.ors.screenpages;


import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class DisplayProductsList extends WebLibrary{



		// =========WebElements for Display Products List Page ==================
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

		

		// =================DisplayProductsList methods=========================

		public static void navAddProductspage() {
			boolean bStatus = clickElement(link_AddProducts);
			Reporter.log(bStatus, "Add Products link clicked", "Add Products link not clicked");
		}

		// ===========================================
		
		public static void searchCategory() {

			boolean bStatus = setValueEscape(edit_Search, "Testmain");
			Reporter.log(bStatus, "Search value entered", "Search value not entered");

		}

		// ===========================================

		public static void selectTableRowEntries(String item) {

			boolean bStatus = selectListItem(select_RowEntries, item);
			Reporter.log(bStatus, "item selected", "item not selected");

		}

		// ===========================================

		public static int tableHeaderColumnCount() {
			int headerCols;
			headerCols = driver.findElements(By.xpath("//table[@id='dataTable']/thead/tr/th")).size();

			return headerCols;
		}

		// ===========================================

		public static String get_DataTableCellText(int rowIndex, int colIndex) {

			String cellText = driver
					.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
					.getText();
			// System.out.println("Cell Text is: "+ cellText);

			return cellText;

		}

		// ===========================================

		public static void display_DataTableRowData(int rowIndex) {

			List<WebElement> colElements = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr[1]/td]"));
			int n = colElements.size();
			for (int i = 0; i < n; i++) {
				String eleText = driver
						.findElement(By.xpath("//table[@id = 'dataTable']/tbody/tr[" + rowIndex + "]/td[" + i + "]"))
						.getText();
				System.out.println(eleText);
			}

		}

		// ===========================================
		public static void display_DataTableColumnData(int colIndex) {
			List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr]"));
			int n = rowElements.size();
			for (int i = 0; i < n; i++) {
				String eleText = driver
						.findElement(By.xpath("//table[@id ='dataTable']/tbody/tr[" + i + "]/td[" + colIndex + "]"))
						.getText();
				System.out.println(eleText);
			}

		}

		// ===========================================
		public static void printAllTableText() {
			
			List<String> names = new ArrayList<String>();
			String nextButtonClassName;
			int rowCount, columnCount;
			do {
				rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();
				columnCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr[1]/td")).size();
				if (rowCount != 0) {
					for (int i = 0; i < rowCount; i++) {
						for (int j = 0; j < columnCount; j++) {
							String eleText = driver
									.findElement(By.xpath("//table[@id ='dataTable']/tbody/tr[" + i + "]/td[" + j + "]"))
									.getText();
							names.add(eleText);

						} 
					} 

				} 
				nextButtonClassName = driver.findElement(By.id("dataTable_next")).getAttribute("class");
				if (!nextButtonClassName.contains("disabled")) {
					
					driver.findElement(By.xpath("//li[@id='dataTable_next']")).click();
				}

			} while (!nextButtonClassName.contains("disabled"));// end of while

			// print the Element text from array list
			for (String name : names) {
				System.out.println(name);
			}

		}
		

		// ===========================================
		// verify newly product added based on unique Cat No
		public static void verifyNewAddedProduct(String catNo) {
			boolean bStatus = false;
			int rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();
			String nextButtonClassName;
			if (rowCount != 0) {
				do {
					nextButtonClassName = driver.findElement(By.id("dataTable_next")).getAttribute("class");
					for (int i = 1; i <= rowCount; i++) {
						String catText = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[6]"))
								.getText();

						if (catText.trim().equalsIgnoreCase(catNo)) {
							bStatus = true;
							break;
						}

					} 

					if (bStatus == false) {
						
						driver.findElement(By.xpath("//li[@id='dataTable_next']")).click();
						
						rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();

					}

				} while (!nextButtonClassName.contains("disabled"));
				Reporter.log(bStatus, "Product in result table displayed as expected",
						"Product in result table not displayed as expected");

			} 
			else
				Reporter.logEvent("warning", "No result displayed in result table");

		}

		
		
		
		// ===========================================
		public static void logOut() {
			boolean bStatus;

			bStatus = clickElement(img_AdminImg);
			Reporter.log(bStatus, "Admin image clicked", "Admin image not clicked");

			bStatus = clickElement(link_LogOut);
			Reporter.log(bStatus, "Log Out link clicked", "Log Out link not clicked");

		}
	}


